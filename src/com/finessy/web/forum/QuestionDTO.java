package com.finessy.web.forum.discussion;

public class QuestionDTO {

	private int questionId;
	private String description;
	private int postBy;
	private String postOn;
	private String tags;

	public QuestionDTO(int questionId, String description, int postBy, String postOn, String tags) {
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

	public int getPostBy() {
		return postBy;
	}

	public String getPostOn() {
		return postOn;
	}

	public String getTags() {
		return tags;
	}

}
