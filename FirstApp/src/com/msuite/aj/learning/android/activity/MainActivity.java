package com.msuite.aj.learning.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.msuite.aj.learning.android.firstapp.R;

/**
 * Simple app that greets the user after he/she enters 
 * a name into an EditText view
 * 
 * @author akausejr
 */
public class MainActivity extends Activity implements OnClickListener {
	// Private view fields that will manipulate your UI
	private EditText mNameEntry;
	private TextView mNameLabel;
	private Button mBtnGetName;

	/**
	 * Called when the Activity object is actually instantiated
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*
		 * Sets the view for the activity to display
		 * in the application's window
		 */
		setContentView(R.layout.activity_main);
		// at this point, the view should be inflated and ready to go
		
		/*
		 * So, we can now go into the view to find the views
		 * we want to manipulate
		 */
		// Need casts because findViewById() returns a View object
		mNameEntry = (EditText) findViewById(R.id.name_entry);
		mNameLabel = (TextView) findViewById(R.id.name_label);
		mBtnGetName = (Button) findViewById(R.id.btn_get_name);
	}
	
	/**
	 * Called when the activity's view can be seen on the screen
	 */
	@Override
	protected void onResume() {
		super.onResume();
		/*
		 * Set the callback that will be called every
		 * time the button is clicked. In this case, 
		 * this Activity will act as the callback
		 * since it implements the OnClickListener
		 * interface. We'll cover interfaces eventually
		 */
		mBtnGetName.setOnClickListener(this);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		/*
		 * This is not required, but it makes sure
		 * that there are no references to this Activity
		 * held after we leave it so it can be GC'd
		 */
		mBtnGetName.setOnClickListener(null);
	}
	
	/**
	 * This method will be called every time the button
	 * is clicked. 
	 */
	@Override
	public void onClick(View v) {
		// An efficient way to append strings into one
		StringBuilder sb = new StringBuilder();
		
		/*
		 * Get the string defined in our resources to be
		 * our message's prefix
		 */
		final String prefix = getString(R.string.name_label_prefix);
		
		/*
		 * Get the text that was entered into the EditText
		 * NOTE: EditText.getText() returns an Editable object,
		 * not a String. Calling toString() takes care of that
		 */
		final String name = mNameEntry.getText().toString();
		
		// Append the strings we have collected to the builder
		sb.append(prefix);
		sb.append(name);
		
		// Build the final String
		final String message = sb.toString();
		
		// Set the label text to reflect what the user entered
		mNameLabel.setText(message);
	}
}
