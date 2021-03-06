package com.ayottewillson.lib;

import org.json.JSONException;
import org.json.JSONObject;


public class JSON {

	// JSON object
	
	public static JSONObject buildJSON() {

		JSONObject weatherObject = new JSONObject();
		try {
			JSONObject dataObject = new JSONObject();

			// Create weather objects in dataObject
			for (Enum items : Enum.values()) {
				JSONObject currentConditionObject = new JSONObject();

				currentConditionObject.put("humidity", items.setHumidity());
				currentConditionObject.put("temp", items.setTemp());
				currentConditionObject.put("wind direction", items.setWindDir());
				currentConditionObject.put("wind speed", items.setWindSpeed());

				dataObject.put(items.name().toString(), currentConditionObject);
			}
			weatherObject.put("data", dataObject);

		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		return weatherObject;
	}

	// Read JSON object

	public static String readJSON(String selected) {

		String result, humidity,temp, dir, speed;

		JSONObject object = buildJSON();

		try {
			humidity = object.getJSONObject("data").getJSONObject(selected).getString("humidity");
			temp = object.getJSONObject("data").getJSONObject(selected).getString("temp");
			dir = object.getJSONObject("data").getJSONObject(selected).getString("wind direction");
			speed = object.getJSONObject("data").getJSONObject(selected).getString("wind speed");

			result = "Humidity: " + humidity +"%\r\n"
					+ "Temp: " + temp +(char) 0x00B0 +"F" + "\r\n"
					+ "Wind Speed: " + speed + " mph\r\n"
					+ "Wind Direction: "  + dir;
		} catch (JSONException e) {
			e.printStackTrace();
			result = e.toString();
		}
		return result;
	}
}