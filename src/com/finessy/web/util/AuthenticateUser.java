package com.finessy.web.util;

import java.sql.SQLException;

import com.finessy.web.user.UserDAO;

public class AuthenticateUser {

	public static boolean exist(String email, String pass) {
		try {
			return new UserDAO().doExist(email, pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean valid(String email, String pass) {
		if(email != null || pass != null) {
			if(email.trim().length() != 0 || pass.trim().length() != 0) {
				return Validator.validate(email, pass);
			}
		}
		return false;
	}

}
