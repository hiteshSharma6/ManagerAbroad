package com.finessy.web.registration;

public interface RegistrationSQL {
  
	String REGISTER_USER = "INSERT INTO student_login(`firstname`, `lastname`, `emailid`, `password`, `lastlogin`) VALUES(?,?,?,?,now());";
	
	String IS_EXIST_EMAIL = "select * from student_login where emailid=?;";
	
	String IS_EMAIL_ACTIVE = "select status from student_login where emailid=?;";
}
