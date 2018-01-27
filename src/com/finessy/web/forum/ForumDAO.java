package com.finessy.web.forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.finessy.web.connection.JDBCConnection;
import com.finessy.web.forum.ForumSQL;
import com.finessy.web.forum.discussion.DiscussionSQL;
import com.finessy.web.forum.discussion.QuestionDTO;
import com.finessy.web.forum.group.degree.DegreeDTO;
import com.finessy.web.forum.group.nativeCountry.NativeCountryDTO;
import com.finessy.web.forum.group.program.ProgramDTO;
import com.finessy.web.forum.group.region.RegionDTO;
import com.finessy.web.forum.group.university.UniversityDTO;

public class ForumDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<UniversityDTO> getUniversityEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_UNIVERSITY_DETAILS);
			
			ArrayList<UniversityDTO> university = new ArrayList<UniversityDTO>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				university.add(new UniversityDTO(0, " "));
			}
			else {
				while(rs.next()) {
					university.add(new UniversityDTO(rs.getInt(1), rs.getString(2)));
				}
			}
			
			return university;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}
	
	public ArrayList<RegionDTO> getRegionEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_REGION_DETAILS);
			
			ArrayList<RegionDTO> region = new ArrayList<RegionDTO>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				region.add(new RegionDTO(0, " "));
			}
			else {
				while(rs.next()) {
					region.add(new RegionDTO(rs.getInt(1), rs.getString(2)));
				}
			}
			
			return region;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}
	
	public ArrayList<NativeCountryDTO> getNativeCountryEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_NATIVE_COUNTRY_DETAILS);
			
			ArrayList<NativeCountryDTO> nativeCountry = new ArrayList<NativeCountryDTO>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				nativeCountry.add(new NativeCountryDTO(0, " "));
			}
			else {
				while(rs.next()) {
					nativeCountry.add(new NativeCountryDTO(rs.getInt(1), rs.getString(2)));
				}
			}
			
			return nativeCountry;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}
	
	public ArrayList<DegreeDTO> getDegreeEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_DEGREE_DETAILS);
			
			ArrayList<DegreeDTO> degree = new ArrayList<DegreeDTO>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				degree.add(new DegreeDTO(0, " "));
			}
			else {
				while(rs.next()) {
					degree.add(new DegreeDTO(rs.getInt(1), rs.getString(2)));
				}
			}
			
			return degree;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

	public ArrayList<ProgramDTO> getProgramEntry() throws ClassNotFoundException, SQLException {
		try {
			con = JDBCConnection.getConnection();
			ps = con.prepareStatement(ForumSQL.GET_PROGRAM_DETAILS);
			
			ArrayList<ProgramDTO> program = new ArrayList<ProgramDTO>();
			rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				program.add(new ProgramDTO(0, " "));
			}
			else {
				while(rs.next()) {
					program.add(new ProgramDTO(rs.getInt(1), rs.getString(2)));
				}
			}
			
			return program;
			
		} finally {
			JDBCConnection.closeConnection(rs, ps, con);
		}		
	}

}
