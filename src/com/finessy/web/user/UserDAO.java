package com.finessy.web.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.finessy.web.commonDAO.CommonDAO;
import com.finessy.web.registration.RegistrationSQL;

public class UserDAO {
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public boolean isExist(String email) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			psmt = con.prepareStatement(RegistrationSQL.IS_EXIST_EMAIL);
			psmt.setString(1, email);
			
			rs = psmt.executeQuery();
			if (!rs.isBeforeFirst() ) {
				return false;
			}
			else {
				return true;
			}
		}finally {
			if(psmt != null)
				psmt.close();
			if(con != null)
				con.close();
		}
	}
	
	public String isActive(String email) throws ClassNotFoundException, SQLException {
		String status = "registered";
		try {
			
			con = CommonDAO.getConnection();
			psmt = con.prepareStatement(RegistrationSQL.IS_EMAIL_ACTIVE);
			psmt.setString(1, email);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				 status = rs.getString(1);
			}
			return status;
			
		}finally {
			
		}
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
			psmt.setString(5, dto.getEmailHash());
			psmt.setString(6, dto.getStatus());
			
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
	
	public int findStudentId(String email) throws ClassNotFoundException, SQLException {
		int studentId = 0;
		
		try {
			con = CommonDAO.getConnection();
			psmt = con.prepareStatement(RegistrationSQL.FIND_STUDENT_ID);
			psmt.setString(1, email);
			
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				studentId = rs.getInt(1);
			}
			return studentId;
			
		}finally {
			if(psmt != null)
				psmt.close();
			if(con != null)
				con.close();
		}
	}
	
	public boolean verifyEmailHash(int studentId, String emailHash) throws ClassNotFoundException, SQLException {
		
		try {
		con = CommonDAO.getConnection();
		psmt = con.prepareStatement(RegistrationSQL.VERIFY_EMAIL_HASH);
		psmt.setInt(1,studentId);
		
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			if(emailHash.equals(rs.getString(1))) {
				return true;
			}
			
		}
		return false;
		}finally {
			if(psmt != null)
				psmt.close();
			if(con != null)
				con.close();
		}
	}
	
public void updateStatus(int studentId) throws ClassNotFoundException, SQLException {
		
		try {
		con = CommonDAO.getConnection();
		psmt = con.prepareStatement(RegistrationSQL.UPDATE_STATUS);
		psmt.setString(1,"active");
		psmt.setInt(2, studentId);
		
		rs = psmt.executeQuery();
		
		
		}finally {
			if(psmt != null)
				psmt.close();
			if(con != null)
				con.close();
		}
	}
		
}
