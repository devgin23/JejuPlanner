package com.gteam.planner.domain;

public class PlaceVO {

	private String placeName;
	private String placeAddress;
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceAddress() {
		return placeAddress;
	}
	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}
	@Override
	public String toString() {
		return "PlaceVO [placeName=" + placeName + ", placeAddress=" + placeAddress + "]";
	}
	
	
}
