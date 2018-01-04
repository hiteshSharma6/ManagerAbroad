package com.finessy.web.dashborad;

public class GroupDTO {

	private int groupId;
	private String universityName;
	private String regionName;
	private String nativeCountryName;
	private String degreeName;
	private String programName;

	public GroupDTO(int groupId, String universityName, String regionName, String nativeCountryName, String degreeName,
			String programName) {
		super();
		this.groupId = groupId;
		this.universityName = universityName;
		this.regionName = regionName;
		this.nativeCountryName = nativeCountryName;
		this.degreeName = degreeName;
		this.programName = programName;
	}

	public int getGroupId() {
		return groupId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public String getRegionName() {
		return regionName;
	}

	public String getNativeCountryName() {
		return nativeCountryName;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public String getProgramName() {
		return programName;
	}

}
