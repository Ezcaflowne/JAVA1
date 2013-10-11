package com.ayottewillson.lib;


///Class Location

public class Location implements Weather {

	String zip;

	public Location(String zip) {
		setZip(zip);
	}

	@Override
	public boolean setZip(String zip) {
		this.zip = zip;
		return true;
	}

	@Override
	public String getZip() {
		return this.zip;
	}

}
