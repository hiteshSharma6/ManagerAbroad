package com.finessy.web.notification.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.finessy.web.commonDAO.CommonDAO;

public class NotificationDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Integer> calcGroups(int studentId) throws ClassNotFoundException, SQLException {
	
		ArrayList<Integer> groupArrayList = new ArrayList<Integer>();
		try {
			
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(NotificationSQL.CALC_GROUPS);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			
			
			if (!rs.isBeforeFirst() ) { 
				groupArrayList.add(0);
				return groupArrayList;
			} 
			
			while(rs.next()) {
				groupArrayList.add(rs.getInt(1));
			}
			return groupArrayList;
			
		
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}
	
	public ArrayList<NotificationDTO> eachGroupQuestion(int studentId, String date1) throws ClassNotFoundException, SQLException{
		
		ArrayList<Integer> groupArrayList = new ArrayList<Integer>();
		groupArrayList = calcGroups(studentId);
		
		ArrayList<NotificationDTO> questionList = new ArrayList<NotificationDTO>();
		
//		if(groupArrayList.lastIndexOf(0) == 0) {
//			System.out.println("no elements");
//			ArrayList<String> questions = new ArrayList<String>();
//			questions.add("null");
//			questionMap.put(new Integer(0), questions);
//			return questionMap;
//		}
			
		try {
		con = CommonDAO.getConnection();
		ps = con.prepareStatement(NotificationSQL.READ_ALL_QUESTIONS_BY_GROUP_AND_DATE);
				
		
			for(Integer i:groupArrayList) {
				
				ArrayList<String> questions = new ArrayList<String>();
				
				ps.setInt(1, i);
				ps.setString(2, date1);
				rs = ps.executeQuery();
				
				if(!rs.isBeforeFirst()) {
					questions.add(" ");
					
					questionList.add(new NotificationDTO(i, questions));
				}
				else {
					while(rs.next()) {
						questions.add(rs.getString(1));
					}
					questionList.add(new NotificationDTO( i, questions));
				}
				
			}
//			System.out.println(questionList);
			
			return questionList;							
			
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}
	
    public String getPreviousDate(int studentId) throws ClassNotFoundException, SQLException {
    	String lastLogin = null;
    	try {
    		con = CommonDAO.getConnection();
    		ps = con.prepareStatement(NotificationSQL.FIND_LAST_LOGIN);
    		ps.setInt(1, studentId);
    		
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			lastLogin = rs.getString(1);
    		}
    		return lastLogin;
    	}finally {
    		CommonDAO.closeConnection(rs, ps, con);
    	}
    }
    
    public void updateLastLogin(int studentId) throws SQLException, ClassNotFoundException {
    	try {
    		con = CommonDAO.getConnection();
    		ps = con.prepareStatement(NotificationSQL.UPDATE_LAST_LOGIN);
    		ps.setInt(1, studentId);
    		
    		int i = ps.executeUpdate();
    		
    	}finally {
    		CommonDAO.closeConnection(rs, ps, con);
    	}
    }
    


}
