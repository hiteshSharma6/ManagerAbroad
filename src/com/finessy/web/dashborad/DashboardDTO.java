package com.finessy.web.dashborad;

import java.util.ArrayList;
import java.util.List;

public class DashboardDTO {

	private GroupDTO group;
	List<DashQuestionDTO> questions;

	public DashboardDTO(GroupDTO group, ArrayList<DashQuestionDTO> questions) {
		super();
		this.group = group;
		this.questions = questions;
	}

	public GroupDTO getGroup() {
		return group;
	}

	public void setGroup(GroupDTO group) {
		this.group = group;
	}

	public List<DashQuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<DashQuestionDTO> questions) {
		this.questions = questions;
	}

}
