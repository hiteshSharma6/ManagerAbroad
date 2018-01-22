package com.finessy.web.forum;

public interface ForumSQL {

	String GET_UNIVERSITY_DETAILS = ""
			+ "SELECT university_id, university_name"
			+ "FROM university";
	
	String GET_REGION_DETAILS = ""
			+ "SELECT region_id, region_name"
			+ "FROM region";
	
	String GET_NATIVE_COUNTRY_DETAILS = ""
			+ "SELECT native_country_id, native_country_name"
			+ "FROM native_country";
	
	String GET_DEGREE_DETAILS = ""
			+ "SELECT degree_id, degree_name"
			+ "FROM degree";
	
	String GET_PROGRAM_DETAILS = ""
			+ "SELECT program_id, program_name"
			+ "FROM program";
	
}
