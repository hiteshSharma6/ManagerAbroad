package com.finessy.web.forum.group.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.ForumSQL;

public class ProgramDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	public ProgramDTO getProgram(int programId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			
			ps = con.prepareStatement(ForumSQL.GET_PROGRAM);
			ps.setInt(1, programId);
			
			ProgramDTO program = null;
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				program = new ProgramDTO(0, " ");
			}
			else {
				while(rs.next()) {
					program = new ProgramDTO(programId, rs.getString(2));
				}
			}
			
			return program;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

}
