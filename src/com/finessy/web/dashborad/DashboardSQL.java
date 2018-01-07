package com.finessy.web.dashborad;

public interface DashboardSQL {

	String GET_GROUPS_DETAILS = ""
			+ "	SELECT G.group_id, G.university_id, G.region_id, G.native_country_id, G.degree_id, G.program_id"
			+ " FROM student_notifications SN"
			+ " 	INNER JOIN groups G ON SN.group_id = G.group_id"
			+ " WHERE student_id = ?;";
	
	String READ_QUESTIONS_BY_GROUP_AND_DATE = ""
			+ "	SELECT question_id, description, post_by, post_on, tags"
			+ "	FROM questions_details"
			+ "	WHERE ("
			+ "		group_id = ?"
			+ "		AND post_on >= ?"
			+ "	);";

	String GET_LAST_LOGIN_DATE = "SELECT last_login FROM student_login WHERE student_id = ?;";

	String UPDATE_LAST_LOGIN_DATE = ""
			+ "	UPDATE student_login"
			+ "	SET last_login = NOW()"
			+ "	WHERE student_id = ?;";

}
