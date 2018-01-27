package com.finessy.web.forum.group.degree;

import java.sql.SQLException;

public class DegreeCtrl {
	static DegreeDAO degreeDAO = new DegreeDAO();

	public static DegreeDTO getDegreeDetail(int degreeId) {
		
		DegreeDTO degreeDTO = null;
		
		try {
			degreeDTO = degreeDAO.getDegree(degreeId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return degreeDTO;
	}
	
	

}
