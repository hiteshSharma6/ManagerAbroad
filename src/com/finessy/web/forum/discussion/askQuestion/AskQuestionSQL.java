package com.finessy.web.forum.discussion.askQuestion;

public interface AskQuestionSQL {

	String CREATE_GROUP = ""
			+ "SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;"
			+ " INSERT INTO groups ("
			+ " 	university_id, region_id, native_country_id, degree_id, program_id)"
			+ " ) VALUES ("
			+ " 	?, ?, ?, ?, ?"
			+ " );"
			+ "SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;";
	
	String CREATE_QUESTION = ""
			+ " INSERT INTO questions_details ("
			+ " 	group_id, post_by, tags, description, post_on"
			+ " ) VALUES ("
			+ " 	?, ?, ?, ?, NOW()"
			+ " );";
	
	String DO_GROUP_EXIST = ""
			+ " SELECT group_id"
			+ " FROM groups"
			+ " WHERE ("
			+ " 	university_id = ?"
			+ " 	AND region_id = ?"
			+ " 	AND native_country_id = ?"
			+ " 	AND degree_id = ?"
			+ " 	AND program_id = ?"
			+ " );";

	String GET_POST_DATE = ""
			+ " SELECT post_on"
			+ " FROM questions_details"
			+ " WHERE question_id = ?;";

}
