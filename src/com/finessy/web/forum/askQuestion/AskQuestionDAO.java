package com.finessy.web.forum.discussion.askQuestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finessy.web.connection.JDBCConnection;
import com.mysql.jdbc.Statement;

public class AskQuestionDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int addGroup(int universityId, int regionId, int nativeCountryId, int degreeId, int programId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(AskQuestionSQL.CREATE_GROUP, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, universityId);
			ps.setInt(2, regionId);
			ps.setInt(3, nativeCountryId);
			ps.setInt(4, degreeId);
			ps.setInt(5, programId);
			
			if(ps.executeUpdate() > 0) {
				rs = ps.getGeneratedKeys();
				rs.next();
				return rs.getInt(1);
			}
		}
		finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}
		return 0;
	}

	public int addQuestion(int groupId, int postBy, String tags, String description) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(AskQuestionSQL.CREATE_QUESTION, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, groupId);
			ps.setInt(2, postBy);
			ps.setString(3, tags);
			ps.setString(4, description);
			
			if(ps.executeUpdate()> 0) {
				rs = ps.getGeneratedKeys();
				rs.next();
				return rs.getInt(1);
			}
		}
		finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}
		return 0;
	}

	public boolean doGroupExist(int universityId, int regionId, int nativeCountryId, int degreeId, int programId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(AskQuestionSQL.DO_GROUP_EXIST);
			ps.setInt(1, universityId);
			ps.setInt(2, regionId);
			ps.setInt(3, nativeCountryId);
			ps.setInt(4, degreeId);
			ps.setInt(5, programId);
			
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

	public String getQuestionPostDate(int questionId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(AskQuestionSQL.GET_POST_DATE);
			ps.setInt(1, questionId);
			
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				return " ";
			}
			
			rs.next();
			return rs.getString(1);
		}
		finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}
	}

	public boolean doGroupExist(int groupId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(AskQuestionSQL.DO_GROUPID_EXIST);
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

}
