package com.finessy.web.forum;

import java.util.Map;

public class ForumDTO {
	
	private Map<Integer, String> university;
	private Map<Integer, String> region;
	private Map<Integer, String> nativeCountry;
	private Map<Integer, String> degree;
	private Map<Integer, String> program;

	public ForumDTO(Map<Integer, String> university, Map<Integer, String> region, Map<Integer, String> nativeCountry,
			Map<Integer, String> degree, Map<Integer, String> program) {
		super();
		this.university = university;
		this.region = region;
		this.nativeCountry = nativeCountry;
		this.degree = degree;
		this.program = program;
	}

	public ForumDTO() {
	}

	public Map<Integer, String> getUniversity() {
		return university;
	}

	public void setUniversity(Map<Integer, String> university) {
		this.university = university;
	}

	public Map<Integer, String> getRegion() {
		return region;
	}

	public void setRegion(Map<Integer, String> region) {
		this.region = region;
	}

	public Map<Integer, String> getNativeCountry() {
		return nativeCountry;
	}

	public void setNativeCountry(Map<Integer, String> nativeCountry) {
		this.nativeCountry = nativeCountry;
	}

	public Map<Integer, String> getDegree() {
		return degree;
	}

	public void setDegree(Map<Integer, String> degree) {
		this.degree = degree;
	}

	public Map<Integer, String> getProgram() {
		return program;
	}

	public void setProgram(Map<Integer, String> program) {
		this.program = program;
	}

}
