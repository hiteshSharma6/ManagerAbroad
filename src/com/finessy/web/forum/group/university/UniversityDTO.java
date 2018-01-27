package com.finessy.web.forum.group.university;

public class UniversityDTO {
	private int universityId;
	private String universityName;

	public UniversityDTO(int universityId, String universityName) {
		super();
		this.universityId = universityId;
		this.universityName = universityName;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

}
