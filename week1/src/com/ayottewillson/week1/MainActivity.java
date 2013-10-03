package com.ayottewillson.week1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
//import android.view.Menu;
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
        
    
}
