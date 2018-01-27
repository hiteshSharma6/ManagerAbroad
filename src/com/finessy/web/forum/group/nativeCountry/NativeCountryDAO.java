package com.finessy.web.forum.group.nativeCountry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.ForumSQL;

public class NativeCountryDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	public NativeCountryDTO getNativeCountry(int nativeCountryId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			
			ps = con.prepareStatement(ForumSQL.GET_NATIVE_COUNTRY);
			ps.setInt(1, nativeCountryId);
			
			NativeCountryDTO nativeCountryDTO = null;
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				nativeCountryDTO = new NativeCountryDTO(0, " ");
			}
			else {
				while(rs.next()) {
					nativeCountryDTO = new NativeCountryDTO(nativeCountryId, rs.getString(2));
				}
			}
			
			return nativeCountryDTO;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

}
