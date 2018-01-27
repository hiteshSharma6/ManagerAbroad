package com.finessy.web.forum.group.program;

public class ProgramDTO {
	private int programId;
	private String programName;

	public ProgramDTO(int programId, String programName) {
		super();
		this.programId = programId;
		this.programName = programName;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

}
