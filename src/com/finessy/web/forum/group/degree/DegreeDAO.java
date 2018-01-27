package com.finessy.web.forum.group.degree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.ForumSQL;

public class DegreeDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	public DegreeDTO getDegree(int degreeId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			
			ps = con.prepareStatement(ForumSQL.GET_DEGREE);
			ps.setInt(1, degreeId);
			
			DegreeDTO degree = null;
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				degree = new DegreeDTO(0, " ");
			}
			else {
				while(rs.next()) {
					degree = new DegreeDTO(rs.getInt(1), rs.getString(2));
				}
			}
			
			return degree;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

}
