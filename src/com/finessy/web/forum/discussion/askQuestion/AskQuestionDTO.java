package com.finessy.web.forum.discussion.askQuestion;

public class AskQuestionDTO {

	private GroupDTO group;
	private int questionId;
	private int postBy;
	private String tags;
	private String description;
	private String postOn;

	public AskQuestionDTO(GroupDTO group, int postBy, String tags, String description, String postOn) {
		super();
		this.group = group;
		this.postBy = postBy;
		this.tags = tags;
		this.description = description;
		this.postOn = postOn;
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

	public int getPostBy() {
		return postBy;
	}

	public void setPostBy(int postBy) {
		this.postBy = postBy;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostOn() {
		return postOn;
	}

	public void setPostOn(String postOn) {
		this.postOn = postOn;
	}

}
