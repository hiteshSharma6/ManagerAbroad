package com.finessy.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private final static String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private final static Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static boolean validate(String email, String pass) {
		if(emailValidator(email) && passwordValidator(pass)) {
			return true;
		}
		return false;
	}

	private static boolean emailValidator(String email) {
		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}

	private static boolean passwordValidator(String pass) {
		return true;
	}

}
