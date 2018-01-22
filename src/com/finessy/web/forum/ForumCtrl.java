package com.finessy.web.forum;

import java.sql.SQLException;
import java.util.Map;

public class ForumCtrl {
	private static final String UNIVERSITY_TABLE = "universiy";
	private static final String REGION_TABLE = "region";
	private static final String NATIVE_COUNTRY_TABLE = "native_country";
	private static final String DEGREE_TABLE = "degree";
	private static final String PROGRAM_TABLE = "program";

	static ForumDAO forumDAO = new ForumDAO();

	public static ForumDTO getForumGroups() {
		
			Map<Integer, String> table;
			ForumDTO forumDTO = new ForumDTO();
			
			try {
				table = getDetailsFor(ForumCtrl.UNIVERSITY_TABLE);
				forumDTO.setProgram(table);
				
				table = getDetailsFor(ForumCtrl.REGION_TABLE);
				forumDTO.setRegion(table);
				
				table = getDetailsFor(ForumCtrl.NATIVE_COUNTRY_TABLE);
				forumDTO.setNativeCountry(table);
				
				table = getDetailsFor(ForumCtrl.DEGREE_TABLE);
				forumDTO.setDegree(table);
				
				table = getDetailsFor(ForumCtrl.PROGRAM_TABLE);
				forumDTO.setProgram(table);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

	private static Map<Integer, String> getDetailsFor(String tableName) throws ClassNotFoundException, SQLException {
		Map<Integer, String> detail;
		
		switch(tableName) {

		case ForumCtrl.UNIVERSITY_TABLE : {
			detail = forumDAO.getUniversityEntry();
		}break;

		case ForumCtrl.REGION_TABLE : {
			detail = forumDAO.getRegionEntry();
		}break;

		case ForumCtrl.NATIVE_COUNTRY_TABLE : {
			detail = forumDAO.getNativeCountryEntry();
		}break;

		case ForumCtrl.DEGREE_TABLE : {
			detail = forumDAO.getDegreeEntry();
		}break;

		case ForumCtrl.PROGRAM_TABLE : {
			detail = forumDAO.getProgramEntry();
		}break;
		
		default: {
			detail = null;
		}
		}
		
		return detail;
	}

}
