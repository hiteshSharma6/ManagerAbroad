package com.finessy.web.forum.discussion;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.forum.group.GroupDTO;

public class DiscussionCtrl {
	static DiscussionDAO discussionDAO = new DiscussionDAO();

	public static DiscussionDTO getDiscussionPage(GroupDTO groupDTO) {
		try {
//			int groupId = groupDTO.getGroupId();
			int groupId = getGroupId(groupDTO);
			System.out.println(groupId);
			
			if(groupId == 0) {
				return new DiscussionDTO(groupDTO, new ArrayList<QuestionDTO>());
			}
			groupDTO.setGroupId(groupId);
			
			DiscussionDTO discussionDTO = getThisGroupQuestions(groupDTO);
			
			return discussionDTO;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static DiscussionDTO getThisGroupQuestions(GroupDTO groupDTO) throws ClassNotFoundException, SQLException {
		ArrayList<QuestionDTO> questions = discussionDAO.getQuestionsFromGroup(groupDTO.getGroupId()); 
		return new DiscussionDTO(groupDTO, questions);
	}

	private static boolean doGroupExist(int groupId) throws ClassNotFoundException, SQLException {
		if(groupId == 0)
			return false;
		return discussionDAO.doGroupExist(groupId);
	}

	private static int getGroupId(GroupDTO group) throws ClassNotFoundException, SQLException {
		int universityId = group.getUniversityId();
		int regionId = group.getRegionId();
		int nativeCountryId = group.getNativeCountryId();
		int degreeId = group.getDegreeId();
		int programId = group.getProgramId();
		System.out.println(universityId+degreeId+programId);
		
		return discussionDAO.getGroupId(universityId, regionId, nativeCountryId, degreeId, programId);
		
	}

}
