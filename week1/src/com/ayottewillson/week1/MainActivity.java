package com.ayottewillson.week1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

	// setup Variables
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	EditText nameField;
	EditText phonesField;
	TextView result;
	TextView pricePerPhone;
	int totalPhones;
	int totalPrice;
	boolean runSpecial;
	String runSpecialYes = "\r\nSince your such a great customer and when you bundled your data plans, you've saved more money!";
	String runSpecialNo = "\r\nWe'd like to thank you for being a customer!! If you were to bunble more data plans, you could save more money!";



	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        	
        // initiate new linear layout
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        // initiate layout params
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        // setup text view and add a title
        TextView tv = new TextView(this);
        tv.setText("Phone to Data Plan Calculator");
        ll.addView(tv);
        
        // text fields
        phonesField = new EditText(this);
        phonesField.setHint("Enter Number of Phones");
        
        nameField = new EditText(this);
        nameField.setHint("Enter Your Name");
        
        runSpecial = false;

        // Calculate Button
        Button b = new Button(this);
        b.setText("Calculate Data Price");
        b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Dismiss the keyboard so we can see our text
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(phonesField.getWindowToken(), 0);

				// Setup variables to be used in this function
				int numPlans = getResources().getInteger(R.integer.numPlans);
				int dataPrice = getResources().getInteger(R.integer.dataPrice);
				int numPhones = Integer.parseInt(phonesField.getText().toString());				

				// Calculate the total number of data plans from the number of phones entered
				totalPhones = numPlans*numPhones;

				// Display a greeting
				result.setText("Hello "+ nameField.getText().toString() + "!\r\nOur data plans cost $"+dataPrice+" per plan.\r\n");
				
				// check if or name and phone number is entered
			if (nameField != null && phonesField != null) 
			{		
				for (int i=1, j=numPhones+1; i<j; i++)
				{
					int perPhone = numPlans * dataPrice;
					pricePerPhone.append("\r\nPhone #"+ i + "= $" + perPhone + "\r\n");
				}
					
				totalPrice = totalPhones*dataPrice;
				result.append("The number of Gigabytes needed per phones data plan is " + totalPhones + "GB.\r\n" + "The total for " + numPhones + " phones is $" + totalPrice + " a month.\r\n");
						
			}
				// If no name is entered, display message.
				else 
				{
					result.append("You need to enter your information. Please try again.");
				}

			if (numPhones > 3)
				{
						runSpecial = true;
				}
					
				if (runSpecial)
				{
					result.append(runSpecialYes);
				}
				else if (!runSpecial)
				{
					result.append(runSpecialNo);
				}

			}
		});
        
     // Clear Button
        Button c = new Button(this);
        c.setText("Clear");
        c.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Empty result textView and pricePerPhone textView
				result.setText("");
				pricePerPhone.setText("");
				// Empty out my fields for reuse
				nameField.setText("");
				phonesField.setText("");	
				// Reset boolean
				runSpecial = false;
			}
		});
        
     // Create the Layout for our app and setup the parameters
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        form.setLayoutParams(lp);
        
        // Add text field and buttons to new layout
        form.addView(nameField);
        form.addView(phonesField);
        form.addView(b);
        form.addView(c);
        
        // Add new form layout to original view
        ll.addView(form);
        
        // Create textViews for resulting text string and add it to the view
        // Result TextView to hold calculations
        result = new TextView(this);
        ll.addView(result);
        // pricePerPhone TextView to hold price of data plans per phone
        pricePerPhone = new TextView(this);
        ll.addView(pricePerPhone);

        setContentView(ll);
        
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
