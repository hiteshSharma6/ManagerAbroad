package com.finessy.web.forum.group.nativeCountry;

import java.sql.SQLException;

public class NativeCountryCtrl {
	static NativeCountryDAO nativeCountryDAO = new NativeCountryDAO();

	public static NativeCountryDTO getNativeCountryDetail(int nativeCountryId) {
		
		NativeCountryDTO nativeCountryDTO = null;
		
		try {
			nativeCountryDTO = nativeCountryDAO.getNativeCountry(nativeCountryId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nativeCountryDTO;
	}
	
	

}
