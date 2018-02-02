package com.finessy.web.forum.discussion;

import java.util.ArrayList;
import java.util.List;

import com.finessy.web.forum.group.GroupDTO;

public class DiscussionDTO {

	private GroupDTO group;
	List<QuestionDTO> questions;

	public DiscussionDTO(GroupDTO group, ArrayList<QuestionDTO> questions) {
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

	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}

}
