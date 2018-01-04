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
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean doExist(String email) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(RegistrationSQL.IS_EXIST_EMAIL);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst() ) {
				return false;
			}
			else {
				return true;
			}
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}
	
	public boolean doExist(String email, String password) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UserSQL.DO_USER_EXIST);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst() ) {
				return false;
			}
			else {
				return true;
			}
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}
	
	public String isActive(String email) throws ClassNotFoundException, SQLException {
		String status = "registered";
		try {
			
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(RegistrationSQL.IS_EMAIL_ACTIVE);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				 status = rs.getString(1);
			}
			return status;
			
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}
	
	public boolean register(UserDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(RegistrationSQL.REGISTER_USER);
			
			ps.setString(1, dto.getFirstName());
			ps.setString(2, dto.getLastName());
			ps.setString(3, dto.getEmailId());
			ps.setString(4, dto.getPassword());
			ps.setString(5, dto.getEmailHash());
			ps.setString(6, dto.getStatus());
			
			if(ps.executeUpdate()>0) {
				con.commit();
				return true;
			}
			else {
				con.rollback();
				return false;
			}
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
		
		
	}
	
	public int findStudentId(String email) throws ClassNotFoundException, SQLException {
		int studentId = 0;
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(RegistrationSQL.FIND_STUDENT_ID);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				studentId = rs.getInt(1);
			}
			return studentId;
			
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}
	
	public boolean verifyEmailHash(int studentId, String emailHash) throws ClassNotFoundException, SQLException {
		
		try {
		con = CommonDAO.getConnection();
		ps = con.prepareStatement(RegistrationSQL.VERIFY_EMAIL_HASH);
		ps.setInt(1,studentId);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			if(emailHash.equals(rs.getString(1))) {
				return true;
			}
			
		}
		return false;
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}
	
	public void updateStatus(int studentId) throws ClassNotFoundException, SQLException {
		
		try {
		con = CommonDAO.getConnection();
		ps = con.prepareStatement(RegistrationSQL.UPDATE_STATUS);
		ps.setString(1,"active");
		ps.setInt(2, studentId);
		
		rs = ps.executeQuery();
		
		
		}finally {
			CommonDAO.closeConnection(rs, ps, con);
		}
	}

}
