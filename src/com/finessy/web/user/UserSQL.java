package com.finessy.web.user;

public interface UserSQL {

	String DO_USER_EXIST = "select * from student_login where email_id=?;";

}
