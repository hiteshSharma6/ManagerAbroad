package com.finessy.web.dashborad;

public interface DashboardSQL {

	String GET_GROUPS_DETAILS = "SELECT SN.group_id, UN.university_name, RG.region_name,"
			+ " NC.native_country_name, DG.degree_name, PG.program_name"
			+ " FROM student_notifications SN"
			+ " INNER JOIN groups G ON SN.group_id = G.group_id"
			+ " INNER JOIN university UN ON UN.university_id = G.university_id"
			+ " INNER JOIN region RG ON RG.region_id = G.region_id"
			+ " INNER JOIN native_country NC ON NC.native_country_id = G.native_country_id"
			+ " INNER JOIN degree DG ON DG.degree_id = G.degree_id"
			+ " INNER JOIN program PG ON PG.program_id = G.program_id"
			+ " WHERE SN.student_id = ?;";
	
	String READ_QUESTIONS_BY_GROUP_AND_DATE = "SELECT question_id, description, post_by, post_on, tags FROM question_details WHERE group_id = ? AND post_on > ?;";

	String GET_LAST_LOGIN_DATE = "SELECT last_login FROM student_login WHERE student_id = ?;";

	String UPDATE_LAST_LOGIN_DATE = "UPDATE student_login SET last_login = NOW() WHERE student_id = ?;";

}
