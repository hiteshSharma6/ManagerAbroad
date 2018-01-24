package com.finessy.web.forum.discussion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.discussion.DiscussionSQL;

public class DiscussionDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int getGroupId(int universityId, int regionId, int nativeCountryId, int degreeId, int programId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(DiscussionSQL.DO_GROUP_EXIST);
			ps.setInt(1, universityId);
			ps.setInt(2, regionId);
			ps.setInt(3, nativeCountryId);
			ps.setInt(4, degreeId);
			ps.setInt(5, programId);
			
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				return 0;
			}
			rs.next();
			return rs.getInt(1);
		}
		finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}
	}

	public boolean doGroupExist(int groupId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(DiscussionSQL.DO_GROUPID_EXIST);
			ps.setInt(1, groupId);
			
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				return false;
			}
			return true;
		}
		finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}
	}

	public ArrayList<QuestionDTO> getQuestionsFromGroup(int groupId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(DiscussionSQL.READ_QUESTIONS_BY_GROUP);
			ps.setInt(1, groupId);
			
			ArrayList<QuestionDTO> questions = new ArrayList<QuestionDTO>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				questions.add(new QuestionDTO(0, " ", 0, " ", " "));
			}
			else {
				while(rs.next()) {
					questions.add(new QuestionDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
				}
			}
			
			return questions;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}
	}

}
