package com.finessy.web.forum.group.university;

import java.sql.SQLException;

public class UniversityCtrl {
	static UniversityDAO universityDAO = new UniversityDAO();

	public static UniversityDTO getUniversityDetail(int universityId) {
		
		UniversityDTO universityDTO = null;
		
		try {
			universityDTO = universityDAO.getUniversity(universityId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return universityDTO;
	}
	
	

}
