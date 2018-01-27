package com.finessy.web.forum.group.region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.ForumSQL;

public class RegionDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	public RegionDTO getRegion(int regionId) throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			
			ps = con.prepareStatement(ForumSQL.GET_REGION);
			ps.setInt(1, regionId);
			
			RegionDTO region = null;
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				region = new RegionDTO(0, " ");
			}
			else {
				while(rs.next()) {
					region = new RegionDTO(rs.getInt(1), rs.getString(2));
				}
			}
			
			return region;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

}
