package com.finessy.web.dashborad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.finessy.web.forum.discussion.GroupDTO;

public class DashboardCtrl {

	public static ArrayList<DashboardDTO> getNewQuestions(int studentId) {
		DashboardDAO dashboardDAO = new DashboardDAO();
		List<GroupDTO> groupList = new ArrayList<GroupDTO>();
		ArrayList<DashboardDTO> dashboardList = new ArrayList<DashboardDTO>();
		ArrayList<DashQuestionDTO> questList = new ArrayList<DashQuestionDTO>();
		
		try {
			groupList = dashboardDAO.getGroups(studentId);
			
			String beforeDate = dashboardDAO.getLastLoginDate(studentId);
			
			for(GroupDTO group : groupList) {
				int groupId = group.getGroupId();
				
				questList = dashboardDAO.getQuestions(groupId, beforeDate);
				dashboardList.add(new DashboardDTO(group, questList));
			}
						
			dashboardDAO.updateLastLoginTime(studentId);
			
			return dashboardList;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dashboardList;

	}

}
