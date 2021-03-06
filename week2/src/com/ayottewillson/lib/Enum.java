package com.ayottewillson.lib;

public enum Enum {

	//Las Vegas
	Summerlin(106,90.5,"NE","10"),
	
	//Henderson
	Henderson(108,93.2,"NE","10"),
	
	//Pharump
	Pharump(95,100.8,"NE","14"),
	
	//Las Vegas
	Vegas(110,95,"NE","13");

	//humidity
	private final int humidity;
	
	//temp
	private final double temp;
	
	//wind direction
	private final String windDir;
	
	//wind speed
	private final String windSpeed;


	private Enum(int humidity, double temp, String windDir, String windSpeed) {
		this.humidity = humidity;
		this.temp = temp;
		this.windDir = windDir;
		this.windSpeed = windSpeed;
	}

	public int setHumidity() {
		return humidity;
	}

	public double setTemp() {
		return temp;
	}

	public String setWindDir() {
		return windDir;
	}

	public String setWindSpeed() {
		return windSpeed;
	}
}