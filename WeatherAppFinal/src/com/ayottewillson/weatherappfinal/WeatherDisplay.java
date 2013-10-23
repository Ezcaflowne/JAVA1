package com.ayottewillson.weatherappfinal;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

	//The Class WeatherDisplay.
public class WeatherDisplay extends GridLayout {

    //Create variables
	//context
    Context _context;
    
    //description
    TextView _description;
    
    //temp c
    TextView _tempC;
    
    //temp f
    TextView _tempF;
    
    //humidity
    TextView _humidity;
    
    //wind speed
    TextView _windSpeed;
    
    //wind direction
    TextView _windDirection;

	//creates a new weather display.
    public WeatherDisplay(Context context) {
        super(context);

        _context = context;

        //Sets the number of columns in the GridLayout
        this.setColumnCount(2);

        //Set TextViews
        TextView descriptionLabel = new TextView(_context);
        descriptionLabel.setText(getResources().getString(R.string.description_label));
        _description = new TextView(_context);
        
        TextView tempfLabel = new TextView(_context);
        tempfLabel.setText(getResources().getString(R.string.tempf_label));
        _tempF = new TextView(_context);

        TextView tempcLabel = new TextView(_context);
        tempcLabel.setText(getResources().getString(R.string.tempc_label));
        _tempC = new TextView(_context);

        TextView humidityLabel = new TextView(_context);
        humidityLabel.setText(getResources().getString(R.string.humidity_label));
        _humidity = new TextView(_context);

        TextView windSpeedLabel = new TextView(_context);
        windSpeedLabel.setText(getResources().getString(R.string.wind_speed_label));
        _windSpeed= new TextView(_context);

        TextView windDirectionLabel = new TextView(_context);
        windDirectionLabel.setText(getResources().getString(R.string.wind_direction_label));
        _windDirection = new TextView(_context);

        //Add elements to view
        this.addView(descriptionLabel);
        this.addView(_description);
        this.addView(tempfLabel);
        this.addView(_tempF);
        this.addView(tempcLabel);
        this.addView(_tempC);
        this.addView(humidityLabel);
        this.addView(_humidity);
        this.addView(windSpeedLabel);
        this.addView(_windSpeed);
        this.addView(windDirectionLabel);
        this.addView(_windDirection);
    }

    //Sets the weather info
    public void setWeatherInfo(String descriptionText, String tempFText, String tempCText, String humidityText, String windSpeedText, String windDirText) {
        //Set text in GridLayout
    	//description text
        _description.setText(descriptionText);
        //temp f text
        _tempF.setText(tempFText);
        //temp c text
        _tempC.setText(tempCText);
        //humidity text
        _humidity.setText(humidityText);
        //wind speed text
        _windSpeed.setText(windSpeedText);
        //wind dir text
        _windDirection.setText(windDirText);
    }
}