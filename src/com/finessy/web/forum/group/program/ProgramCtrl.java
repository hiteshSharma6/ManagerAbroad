package com.finessy.web.forum.group.program;

import java.sql.SQLException;

public class ProgramCtrl {
	static ProgramDAO programDAO = new ProgramDAO();

	public static ProgramDTO getProgramDetail(int programId) {
		
		ProgramDTO programDTO = null;
		
		try {
			programDTO = programDAO.getProgram(programId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return programDTO;
	}
	
	

}
