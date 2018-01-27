package com.finessy.web.forum;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.forum.group.degree.DegreeDTO;
import com.finessy.web.forum.group.nativeCountry.NativeCountryDTO;
import com.finessy.web.forum.group.program.ProgramDTO;
import com.finessy.web.forum.group.region.RegionDTO;
import com.finessy.web.forum.group.university.UniversityDTO;

public class ForumCtrl {
	static ForumDAO forumDAO = new ForumDAO();

	public static ForumDTO getForumGroups() {
		
		ForumDTO forumDTO = null;
		
		ArrayList<UniversityDTO> universityDTO;
		ArrayList<RegionDTO> regionDTO;
		ArrayList<NativeCountryDTO> nativeCountryDTO;
		ArrayList<DegreeDTO> degreeDTO;
		ArrayList<ProgramDTO> programDTO;
		
		try {
			universityDTO = forumDAO.getUniversityEntry();
			forumDTO.setUniversity(universityDTO);
			
			regionDTO = forumDAO.getRegionEntry();
			forumDTO.setRegion(regionDTO);
			
			nativeCountryDTO = forumDAO.getNativeCountryEntry();
			forumDTO.setNativeCountry(nativeCountryDTO);
			
			degreeDTO = forumDAO.getDegreeEntry();
			forumDTO.setDegree(degreeDTO);
			
			programDTO = forumDAO.getProgramEntry();
			forumDTO.setProgram(programDTO);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
