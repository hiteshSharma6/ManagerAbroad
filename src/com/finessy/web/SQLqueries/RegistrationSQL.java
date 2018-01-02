package com.finessy.web.SQLqueries;

public interface RegistrationSQL {
  
	String REGISTER_USER = "INSERT INTO student_login(`firstname`, `lastname`, `emailid`, `password`, `lastlogin`) VALUES(?,?,?,?,now());";
}
