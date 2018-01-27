package com.finessy.web.forum.discussion.askQuestion;

import java.sql.SQLException;

import com.finessy.web.forum.group.GroupDTO;

public class AskQuestionCtrl {
	static AskQuestionDAO askQuestionDAO = new AskQuestionDAO();

	public static AskQuestionDTO addQuestion(AskQuestionDTO askQuestionDTO) {
		try {
			int groupId = askQuestionDTO.getGroup().getGroupId();
			
//			It is supposed that groupId is maintained on client side
			boolean groupExist = doGroupExist(groupId);
//			If groupId is not maintained on client side, use this - 
//			boolean groupExist = doGroupExist(askQuestionDTO.getGroup());
			if(!groupExist) {
				groupId = addGroup(askQuestionDTO.getGroup());
				askQuestionDTO.getGroup().setGroupId(groupId);
			}
			
			int postBy = askQuestionDTO.getPostBy();
			String tags = askQuestionDTO.getTags();
			String description = askQuestionDTO.getDescription();
			
			int questionId = askQuestionDAO.addQuestion(groupId, postBy, tags, description);
			askQuestionDTO.setQuestionId(questionId);
			
			String postOn = questionPostDate(questionId);
			askQuestionDTO.setPostOn(postOn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return askQuestionDTO;
	}

	private static String questionPostDate(int questionId) throws ClassNotFoundException, SQLException {
		return askQuestionDAO.getQuestionPostDate(questionId);
	}

	private static int addGroup(GroupDTO group) throws ClassNotFoundException, SQLException {
		int universityId = group.getUniversityId();
		int regionId = group.getRegionId();
		int nativeCountryId = group.getNativeCountryId();
		int degreeId = group.getDegreeId();
		int programId = group.getProgramId();
		
		return askQuestionDAO.addGroup(universityId, regionId, nativeCountryId, degreeId, programId);
	}

	private static boolean doGroupExist(int groupId) throws ClassNotFoundException, SQLException {
		if(groupId == 0)
			return false;
		return askQuestionDAO.doGroupExist(groupId);
	}

	private static boolean doGroupExist(GroupDTO group) throws ClassNotFoundException, SQLException {
		int universityId = group.getUniversityId();
		int regionId = group.getRegionId();
		int nativeCountryId = group.getNativeCountryId();
		int degreeId = group.getDegreeId();
		int programId = group.getProgramId();
		
		return askQuestionDAO.doGroupExist(universityId, regionId, nativeCountryId, degreeId, programId);
	}

}
