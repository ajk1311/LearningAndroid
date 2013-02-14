package com.aj.learningandroid.listenerexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

/**
 * Class demonstrating the listener/callback technique
 * 
 * @author akausejr
 *
 */
public class CreatedActivity extends Activity {

	private OnActivityCreatedListener mListener;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*
         * Create the layout from code here to demonstrate
         * the listener
         */
        LinearLayout ll = new LinearLayout(this);
        ll.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams lp = 
        		new LinearLayout.LayoutParams(
        				LayoutParams.WRAP_CONTENT, 
        				LayoutParams.WRAP_CONTENT
        		);
        CreatedTextView ctv = new CreatedTextView(this);
        ll.addView(ctv, lp);
        setContentView(ll);
        
        /*
         * If the listener is valid, notify the listener
         * that onCreate(Bundle) has been called
         */
        if(mListener != null) {
        	mListener.activityCreated();
        }
    }
    
    /**
     * Method for setting this Activity's OnActivityCreatedListener
     * 
     * @param listener the listener that listens for onCreate(Bundle)
     */
    public void setOnActivityCreatedListener(OnActivityCreatedListener listener) {
    	mListener = listener;
    }
    
    /**
     * Trivial interface to listen for the onCreate(Bundle) for an Activity
     */
    public interface OnActivityCreatedListener {
    	/**
    	 * Called every time an Activity's onCreate(Bundle) method is called
    	 */
    	public void activityCreated();
    }
    
}
