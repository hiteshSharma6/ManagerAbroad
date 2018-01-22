package com.finessy.web.forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.ForumSQL;
import com.finessy.web.forum.discussion.DiscussionSQL;
import com.finessy.web.forum.discussion.QuestionDTO;

public class ForumDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Map<Integer, String> getUniversityEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_UNIVERSITY_DETAILS);
			
			Map<Integer, String> university = new HashMap<Integer, String>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				university.put(0, " ");
			}
			else {
				while(rs.next()) {
					university.put(rs.getInt(1), rs.getString(2));
				}
			}
			
			return university;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}
	
	public Map<Integer, String> getRegionEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_REGION_DETAILS);
			
			Map<Integer, String> region = new HashMap<Integer, String>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				region.put(0, " ");
			}
			else {
				while(rs.next()) {
					region.put(rs.getInt(1), rs.getString(2));
				}
			}
			
			return region;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}
	
	public Map<Integer, String> getNativeCountryEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_NATIVE_COUNTRY_DETAILS);
			
			Map<Integer, String> nativeCountry = new HashMap<Integer, String>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				nativeCountry.put(0, " ");
			}
			else {
				while(rs.next()) {
					nativeCountry.put(rs.getInt(1), rs.getString(2));
				}
			}
			
			return nativeCountry;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}
	
	public Map<Integer, String> getDegreeEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_DEGREE_DETAILS);
			
			Map<Integer, String> degree = new HashMap<Integer, String>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				degree.put(0, " ");
			}
			else {
				while(rs.next()) {
					degree.put(rs.getInt(1), rs.getString(2));
				}
			}
			
			return degree;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

	public Map<Integer, String> getProgramEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_PROGRAM_DETAILS);
			
			Map<Integer, String> program = new HashMap<Integer, String>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				program.put(0, " ");
			}
			else {
				while(rs.next()) {
					program.put(rs.getInt(1), rs.getString(2));
				}
			}
			
			return program;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

}
