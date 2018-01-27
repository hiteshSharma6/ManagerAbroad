package com.finessy.web.forum.group.nativeCountry;

public class NativeCountryDTO {
	private int nativeCountryId;
	private String nativeCountryName;

	public NativeCountryDTO(int nativeCountryId, String nativeCountryName) {
		super();
		this.nativeCountryId = nativeCountryId;
		this.nativeCountryName = nativeCountryName;
	}

	public int getNativeCountryId() {
		return nativeCountryId;
	}

	public void setNativeCountryId(int nativeCountryId) {
		this.nativeCountryId = nativeCountryId;
	}

	public String getNativeCountryName() {
		return nativeCountryName;
	}

	public void setNativeCountryName(String nativeCountryName) {
		this.nativeCountryName = nativeCountryName;
	}

}
