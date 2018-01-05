package com.finessy.web.forum.question;

public interface QuesAnsSQL {
	
	String FIND_ANSWER_ID = "select answer_id from answers where question_id=?;";
	
	String FIND_ANSWER_DETAILS = "select * from answer_details where answer_id=?;";
	
	String FIND_RELATED_QUESTION_DETAILS = "select * from question_details where tags in (select tags from question_details where question_id=?);";
	
	String FIND_NAME = "select first_name, last_name from student_login where student_id=?;";
}