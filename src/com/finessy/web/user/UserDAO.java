package com.finessy.web.user;

public class UserDAO {
	
	public boolean doExist(String email, String pass) {
		if(email.equals("hitesh@gmail.com") && pass.equals("hitesh"))
			return true;
		return false;
	}

}
