package com.finessy.web.util;

import org.mindrot.jbcrypt.BCrypt;

public class Hash {
	
	public static String hashPassword(String pass) {
		return BCrypt.hashpw(pass, BCrypt.gensalt());
	}

}
