package com.finessy.web.notification.question;

import java.util.ArrayList;

public class NotificationDTO {
	
	private int groupId;
	private ArrayList<String> questions;
	public NotificationDTO(int groupId, ArrayList<String> questions) {
		this.groupId = groupId;
		this.questions = questions;
	}
			
	@Override
	public String toString() {
		return "NotificationDTO [groupId=" + groupId + ", questions=" + questions + "]";
	}

	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public ArrayList<String> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}
	
	

}
