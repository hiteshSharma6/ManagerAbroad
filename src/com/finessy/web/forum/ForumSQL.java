package com.finessy.web.forum;

public interface ForumSQL {

	String READ_ALL_QUESTIONS = "select * from question_details";;
	String READ_ALL_QUESTIONS_BY_GROUP_AND_DATE = "select * from question_details where group_id=? AND post_on>? AND post_on<?;";
	String READ_ALL_QUESTIONS_BY_GROUP = "select * from question_details where group_id=?;";
}
