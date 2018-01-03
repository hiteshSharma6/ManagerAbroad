package com.finessy.web.notification.question;

public interface NotificationSQL {

	String CALC_GROUPS = "select group_id from student_notifications where student_id=?;";
	
	String READ_ALL_QUESTIONS_BY_GROUP_AND_DATE = "select * from question_details where group_id=? AND post_on<?;";
	
//	String TEST = "insert into datetimediff values(?);";
	
	

}
