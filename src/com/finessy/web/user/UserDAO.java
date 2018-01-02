package com.finessy.web.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.finessy.web.commonDAO.CommonDAO;
import com.finessy.web.SQLqueries.RegistrationSQL;

public class UserDAO {
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public boolean doExist(String email, String pass) {
		if(email.equals("hitesh@gmail.com") && pass.equals("hitesh"))
			return true;
		return false;
	}
	
	public boolean register(UserDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			psmt = con.prepareStatement(RegistrationSQL.REGISTER_USER);
			
			psmt.setString(1, dto.getFirstName());
			psmt.setString(2, dto.getLastName());
			psmt.setString(3, dto.getEmailId());
			psmt.setString(4, dto.getPassword());
			
			if(psmt.executeUpdate()>0) {
				con.commit();
				return true;
			}
			else {
				con.rollback();
				return false;
			}
		}finally {
			if(psmt != null)
				psmt.close();
			if(con != null)
				con.close();
		}
		
		
	}

}
