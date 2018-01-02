package com.finessy.web.util;

import com.finessy.web.user.UserDAO;

public class AuthenticateUser {

	public static boolean exist(String email, String pass) {
		return new UserDAO().doExist(email, pass);
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
