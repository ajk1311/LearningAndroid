package com.aj.learningandroid.listexample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

/**
 * ListActivity that will use a different adapter depending on the
 * extras put in the Intent that starts this Activity. Must provide
 * an int extra with the name EXTRA_ADAPTER_TYPE.
 * 
 * @author akausejr
 *
 */
public class DifferentListsActivity extends ListActivity {
	public static final int TYPE_BAD = 0;
	public static final int TYPE_BETTER = 1;
	public static final int TYPE_BEST = 2;
	
	public static final String EXTRA_ADAPTER_TYPE = 
			"com.aj.learningandroid.listexample.DefferentListActivity.ADAPTER_TYPE";
	
	private String[] mNameArray;
	private String[] mUniqnameArray;
	private NamesAdapter mListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mNameArray = getResources().getStringArray(R.array.names);
		mUniqnameArray = getResources().getStringArray(R.array.uniqnames);
		
		Intent intent = getIntent();
		if(!intent.hasExtra(EXTRA_ADAPTER_TYPE)) {
			throw new IllegalStateException("Must specify adapter type for DifferentListsActivity");
		}
		
		final int type = intent.getIntExtra(EXTRA_ADAPTER_TYPE, TYPE_BEST);
		switch (type) {
		case TYPE_BAD:
			mListAdapter = new BadAdapter(this, mNameArray, mUniqnameArray);
			break;
		case TYPE_BETTER:
			mListAdapter = new BetterAdapter(this, mNameArray, mUniqnameArray);
		case TYPE_BEST:
			mListAdapter = new BestAdapter(this, mNameArray, mUniqnameArray);
			break;
		default:
			throw new IllegalStateException("Invalid adapter type");
		}
		
		setListAdapter(mListAdapter);
	}

}
