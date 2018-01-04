package com.finessy.web.dashborad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.commonDAO.CommonDAO;

public class DashboardDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<GroupDTO> getGroups(int studentId) throws ClassNotFoundException, SQLException {
		
		ArrayList<GroupDTO> groupArrayList = new ArrayList<GroupDTO>();
		try {
			
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(DashboardSQL.GET_GROUPS_DETAILS);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			
			if (!rs.isBeforeFirst() ) { 
				groupArrayList.add(new GroupDTO(0, " ", " ", " ", " ", " "));
			} 
			else {
				while(rs.next()) {
					groupArrayList.add(new GroupDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
			}
			
			return groupArrayList;
			
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}

	public ArrayList<DashQuestionDTO> getQuestions(int groupId, String beforeDate) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(DashboardSQL.READ_QUESTIONS_BY_GROUP_AND_DATE);
			ps.setInt(1, groupId);
			ps.setString(2, beforeDate);
			
			ArrayList<DashQuestionDTO> questions = new ArrayList<DashQuestionDTO>();
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				questions.add(new DashQuestionDTO(0, " ", " ", " ", " "));
			}
			else {
				while(rs.next()) {
					questions.add(new DashQuestionDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
			}
			
			return questions;
			
		} finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}

	public String getLastLoginDate(int studentId) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(DashboardSQL.GET_LAST_LOGIN_DATE);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			
			rs.next();
			return rs.getString(1);
		} finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}

	public void updateLastLoginTime(int studentId) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(DashboardSQL.UPDATE_LAST_LOGIN_DATE);
			ps.setInt(1, studentId);
			
			ps.executeUpdate();
		}
		finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
		
	}

}
