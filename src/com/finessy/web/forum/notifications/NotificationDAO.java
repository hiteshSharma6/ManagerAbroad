package com.finessy.web.notifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
//	public HashMap<Integer,ArrayList<String>> eachGroupQuestion(int studentId, String date1) throws ClassNotFoundException, SQLException{
//		
//		ArrayList<Integer> groupArrayList = new ArrayList<Integer>();
//		groupArrayList = calcGroups(studentId);
//		
//		Map<Integer,ArrayList<String>> questionMap = new HashMap<Integer,ArrayList<String>>();
//		con = CommonDAO.getConnection();
//		ps = con.prepareStatement("");
//		
//		try {
//			for(Integer i:groupArrayList) {
//				
//				ps.setInt(1, i);
//				ps.setString(2, date1);
//			}
//			
//			
//			
//		}finally {
//			
//		}
//	}
	
//	public void test(String s) throws ClassNotFoundException, SQLException {
//		
//		try {
//		con = CommonDAO.getConnection();
//		ps = con.prepareStatement(NotificationSQL.TEST);
//		ps.setString(1, s);
//		int a = ps.executeUpdate();
//		
//		while(rs.next()) {
//			System.out.println(rs.getString(1));
//		}
//		}finally {
//			if(rs != null) {
//				rs.close();
//			}
//			if(ps != null) {
//				ps.close();
//			}
//			if(con != null) {
//				con.close();
//			}
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		
//		NotificationDAO dao = new NotificationDAO();
//		try {
//			dao.test("2017-12-27 10:40:30");
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//	}

}
