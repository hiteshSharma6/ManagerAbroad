package com.finessy.web.dashborad;

public class DashQuestionDTO {

	private int questionId;
	private String description;
	private int postBy;
	private String postOn;
	private String tags;

	public DashQuestionDTO(int questionId, String description, int postBy, String postOn, String tags) {
		super();
		this.questionId = questionId;
		this.description = description;
		this.postBy = postBy;
		this.postOn = postOn;
		this.tags = tags;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;;
	}

	public String getDescription() {
		return description;
	}

//	public void setDescription(String description) {
//		this.description = description;
//	}

	public int getPostBy() {
		return postBy;
	}

//	public void setPostBy(int postBy) {
//		this.postBy = postBy;
//	}

	public String getPostOn() {
		return postOn;
	}

//	public void setPostOn(String postOn) {
//		this.postOn = postOn;
//	}

	public String getTags() {
		return tags;
	}

//	public void setTags(String tags) {
//		this.tags = tags;
//	}

}
