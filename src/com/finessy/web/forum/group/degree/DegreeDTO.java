package com.finessy.web.forum.group.degree;

public class DegreeDTO {
	private int degreeId;
	private String degreeName;

	public DegreeDTO(int degreeId, String degreeName) {
		super();
		this.degreeId = degreeId;
		this.degreeName = degreeName;
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

}
