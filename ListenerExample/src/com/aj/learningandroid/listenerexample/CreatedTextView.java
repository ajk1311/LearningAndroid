package com.aj.learningandroid.listenerexample;

import android.content.Context;
import android.widget.TextView;

import com.aj.learningandroid.listenerexample.CreatedActivity.OnActivityCreatedListener;

/**
 * Simple View extending TextView that displays the text
 * "Activity Created" when the CreatedActivity it's listening 
 * to is created.
 * 
 * @author akausejr
 *
 */
public class CreatedTextView extends TextView implements OnActivityCreatedListener {

	public CreatedTextView(Context context) {
		super(context);
		
		/*
		 * If the creating context is an instance of CreatedActivity, we can
		 * set it's listener to this object. 
		 * 
		 * NOTE: remember that Activity extends Context!
		 */
		if(context instanceof CreatedActivity) {
			((CreatedActivity) context).setOnActivityCreatedListener(this);
		}
	}

	/**
	 * Since this class implements the interface OnActivityCreatedListener,
	 * it is an instance of that object. 
	 * 
	 * If this OnActivityCreatedListener is set to an CreatedActivity, this method
	 * will be called when the CreatedActivity's onCreate() method is done.
	 */
	@Override
	public void activityCreated() {
		setText("Activity Created!");
	}
}
