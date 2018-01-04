package com.finessy.web.ques_ans;

public class QuesAnsDTO {
	private int answerId;
	private String postBy;
	private String description;
	private String postOn;
	
	public QuesAnsDTO(int answerId, String postBy, String description, String postOn) {
		this.answerId = answerId;
		this.postBy = postBy;
		this.description = description;
		this.postOn = postOn;
	}

	@Override
	public String toString() {
		return "QuesAnsDTO [answerId=" + answerId + ", postBy=" + postBy + ", description=" + description + ", postOn="
				+ postOn + "]";
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getPostBy() {
		return postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
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