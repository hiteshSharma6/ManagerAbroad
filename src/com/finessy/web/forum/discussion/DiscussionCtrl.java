package com.finessy.web.forum.discussion;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.web.forum.GroupDTO;

public class DiscussionCtrl {
	static DiscussionDAO discussionDAO = new DiscussionDAO();

	public static DiscussionDTO getDiscussionPage(GroupDTO groupDTO) {
		try {
			int groupId = groupDTO.getGroupId();
			
//			It is supposed that groupId is maintained on client side
			boolean groupExist = doGroupExist(groupId);
//			If groupId is not maintained on client side
//			boolean groupExist = doGroupExist(askQuestionDTO.getGroup());
			if(!groupExist) {
				return new DiscussionDTO(groupDTO, new ArrayList<QuestionDTO>());
			}
			
			DiscussionDTO discussionDTO = getThisGroupQuestions(groupDTO);
			
			return discussionDTO;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static DiscussionDTO getThisGroupQuestions(GroupDTO groupDTO) throws ClassNotFoundException, SQLException {
		ArrayList<QuestionDTO> questions =discussionDAO.getQuestionsFromGroup(groupDTO.getGroupId()); 
		return new DiscussionDTO(groupDTO, questions);
	}

	private static boolean doGroupExist(int groupId) throws ClassNotFoundException, SQLException {
		if(groupId == 0)
			return false;
		return discussionDAO.doGroupExist(groupId);
	}

	private static boolean doGroupExist(GroupDTO group) throws ClassNotFoundException, SQLException {
		int universityId = group.getUniversityId();
		int regionId = group.getRegionId();
		int nativeCountryId = group.getNativeCountryId();
		int degreeId = group.getDegreeId();
		int programId = group.getProgramId();
		
		return discussionDAO.doGroupExist(universityId, regionId, nativeCountryId, degreeId, programId);
	}

}
