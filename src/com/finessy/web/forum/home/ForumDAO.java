package com.finessy.web.forum.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.commonDAO.CommonDAO;
import com.finessy.web.forum.home.ForumSQL;

public class ForumDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<ForumDTO> readAll() throws ClassNotFoundException, SQLException{
		ArrayList<ForumDTO> questionList = new ArrayList<ForumDTO>();
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ForumSQL.READ_ALL_QUESTIONS);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				questionList.add(new ForumDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			return questionList;
			
			
		} finally {
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
	
	public ArrayList<ForumDTO> readAllQuesByGroupNDate(int groupId, String date1, String date2) throws ClassNotFoundException, SQLException{
		ArrayList<ForumDTO> questionList = new ArrayList<ForumDTO>();
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ForumSQL.READ_ALL_QUESTIONS_BY_GROUP_AND_DATE);
			ps.setInt(1, groupId);
			ps.setString(2, date1);
			ps.setString(3, date2);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				questionList.add(new ForumDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			return questionList;
			
			
		} finally {
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
	
	
}
