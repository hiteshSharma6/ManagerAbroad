package com.finessy.web.forum.group;

public class GroupDTO {

	private int groupId;
	private int universityId;
	private int regionId;
	private int nativeCountryId;
	private int degreeId;
	private int programId;

	public GroupDTO() {}

	public GroupDTO(int groupId, int universityId, int regionId, int nativeCountryId, int degreeId, int programId) {
		super();
		this.groupId = groupId;
		this.universityId = universityId;
		this.regionId = regionId;
		this.nativeCountryId = nativeCountryId;
		this.degreeId = degreeId;
		this.programId = programId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getNativeCountryId() {
		return nativeCountryId;
	}

	public void setNativeCountryId(int nativeCountryId) {
		this.nativeCountryId = nativeCountryId;
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

}
