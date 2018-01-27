package com.finessy.web.forum.group.university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.ForumSQL;

public class UniversityDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	public UniversityDTO getUniversity(int universityId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			
			ps = con.prepareStatement(ForumSQL.GET_UNIVERSITY);
			ps.setInt(1, universityId);
			
			UniversityDTO university = null;
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				university = new UniversityDTO(0, " ");
			}
			else {
				while(rs.next()) {
					university = new UniversityDTO(universityId, rs.getString(1));
				}
			}
			
			return university;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

}
