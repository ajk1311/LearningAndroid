package com.aj.learningandroid.listexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button mBadListBtn;
	private Button mBetterListBtn;
	private Button mBestListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mBadListBtn = (Button) findViewById(R.id.badlist_btn);
        mBetterListBtn = (Button) findViewById(R.id.betterlist_btn);
        mBestListBtn = (Button) findViewById(R.id.bestlist_btn);
    }

    @Override
    protected void onResume() {
    	super.onResume();
    	mBadListBtn.setOnClickListener(this);
    	mBetterListBtn.setOnClickListener(this);
    	mBestListBtn.setOnClickListener(this);
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	mBadListBtn.setOnClickListener(null);
    	mBetterListBtn.setOnClickListener(null);
    	mBestListBtn.setOnClickListener(null);
    }
    
    /**
     * Called each time a button is clicked
     */
    @Override
    public void onClick(View v) {
    	final int id = v.getId();
    	
    	// Intent to start the DifferentListActivity
    	Intent intent = new Intent(this, DifferentListsActivity.class);
    	
    	// Type of adapter to use in DifferentListActivity, will set
    	// based on the button that was pressed
    	int type = -1;
    	
    	/*
    	 * Switch on the id of the View that was clicked
    	 * and assignt type to the correct type constant
    	 */
    	switch (id) {
		case R.id.badlist_btn:
			type = DifferentListsActivity.TYPE_BAD;
			break;
		case R.id.betterlist_btn:
			type = DifferentListsActivity.TYPE_BETTER;
			break;
		case R.id.bestlist_btn:
			type = DifferentListsActivity.TYPE_BEST;
			break;
		}
    	
    	// put the type extra in the intent and start the activity
    	intent.putExtra(DifferentListsActivity.EXTRA_ADAPTER_TYPE, type);
    	startActivity(intent);
    }
}
