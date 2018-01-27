package com.finessy.web.forum.group.region;

import java.sql.SQLException;

public class RegionCtrl {
	static RegionDAO regionDAO = new RegionDAO();

	public static RegionDTO getRegionDetail(int regionId) {
		
		RegionDTO regionDTO = null;
		
		try {
			regionDTO = regionDAO.getRegion(regionId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return regionDTO;
	}
	
	

}
