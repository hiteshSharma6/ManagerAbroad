package com.finessy.web.forum;

import java.util.ArrayList;

import com.finessy.web.forum.group.degree.DegreeDTO;
import com.finessy.web.forum.group.nativeCountry.NativeCountryDTO;
import com.finessy.web.forum.group.program.ProgramDTO;
import com.finessy.web.forum.group.region.RegionDTO;
import com.finessy.web.forum.group.university.UniversityDTO;

public class ForumDTO {
	
	private ArrayList<UniversityDTO> university;
	private ArrayList<RegionDTO> region;
	private ArrayList<NativeCountryDTO> nativeCountry;
	private ArrayList<DegreeDTO> degree;
	private ArrayList<ProgramDTO> program;

	public ForumDTO(ArrayList<UniversityDTO> university, ArrayList<RegionDTO> region,
			ArrayList<NativeCountryDTO> nativeCountry, ArrayList<DegreeDTO> degree, ArrayList<ProgramDTO> program) {
		super();
		this.university = university;
		this.region = region;
		this.nativeCountry = nativeCountry;
		this.degree = degree;
		this.program = program;
	}

	public ArrayList<UniversityDTO> getUniversity() {
		return university;
	}

	public void setUniversity(ArrayList<UniversityDTO> university) {
		this.university = university;
	}

	public ArrayList<RegionDTO> getRegion() {
		return region;
	}

	public void setRegion(ArrayList<RegionDTO> region) {
		this.region = region;
	}

	public ArrayList<NativeCountryDTO> getNativeCountry() {
		return nativeCountry;
	}

	public void setNativeCountry(ArrayList<NativeCountryDTO> nativeCountry) {
		this.nativeCountry = nativeCountry;
	}

	public ArrayList<DegreeDTO> getDegree() {
		return degree;
	}

	public void setDegree(ArrayList<DegreeDTO> degree) {
		this.degree = degree;
	}

	public ArrayList<ProgramDTO> getProgram() {
		return program;
	}

	public void setProgram(ArrayList<ProgramDTO> program) {
		this.program = program;
	}

}
