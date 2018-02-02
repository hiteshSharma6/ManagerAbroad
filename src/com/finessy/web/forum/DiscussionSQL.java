package com.finessy.web.forum.discussion;

public interface DiscussionSQL {

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

	String DO_GROUPID_EXIST = ""
			+ " SELECT group_id"
			+ " FROM groups"
			+ " WHERE group_id = ?;";

	String READ_QUESTIONS_BY_GROUP = ""
			+ "	SELECT question_id, description, post_by, post_on, tags"
			+ "	FROM questions_details"
			+ " WHERE group_id = ?;";

}
