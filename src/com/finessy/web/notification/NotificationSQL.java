package com.finessy.web.notification.question;

public interface NotificationSQL {

	String CALC_GROUPS = "select group_id from student_notifications where student_id=?;";
	
	String READ_ALL_QUESTIONS_BY_GROUP_AND_DATE = "select description from question_details where group_id=? AND post_on>?;";
	
	String FIND_LAST_LOGIN = "select last_login from student_login where student_id=?;";
	
	String UPDATE_LAST_LOGIN = "update student_login set last_login=now() where student_id=?";
	
	
}
