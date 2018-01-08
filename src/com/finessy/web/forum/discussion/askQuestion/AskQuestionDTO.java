package com.finessy.web.forum.discussion.askQuestion;

import com.finessy.web.forum.discussion.GroupDTO;

public class AskQuestionDTO {

	private GroupDTO group;
	private int questionId;
	private String description;
	private int postBy;
	private String postOn;
	private String tags;

	public AskQuestionDTO(GroupDTO group, int questionId, String description, int postBy, String postOn, String tags) {
		super();
		this.group = group;
		this.questionId = questionId;
		this.description = description;
		this.postBy = postBy;
		this.postOn = postOn;
		this.tags = tags;
	}

	public GroupDTO getGroup() {
		return group;
	}

	public void setGroup(GroupDTO group) {
		this.group = group;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPostBy() {
		return postBy;
	}

	public void setPostBy(int postBy) {
		this.postBy = postBy;
	}

	public String getPostOn() {
		return postOn;
	}

	public void setPostOn(String postOn) {
		this.postOn = postOn;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
