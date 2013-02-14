package com.aj.learningandroid.listexample;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

/**
 * Abstract Adapter class that holds the names and uniqnames
 * of everyone in this class. Adapters that extend this class
 * must implement only getView(). This way our examples can 
 * focus on the getView() method so we can see the difference
 * between implementations without too much clutter.
 * 
 * @author akausejr
 *
 */
public abstract class NamesAdapter extends BaseAdapter {
	protected final String[] mNames;
	protected final String[] mUniqnames;
	private final LayoutInflater mLayoutInflater;
	
	public NamesAdapter(Context context, String[] names, String[] uniqnames) {
		mNames = names;
		mUniqnames = uniqnames;
		mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		if(mNames.length != mUniqnames.length) {
			throw new IllegalStateException("Name list lengths do not match!");
		}
		
		return mNames.length;
	}

	@Override
	public Object getItem(int position) {
		return new Pair<String, String>(mNames[position], mUniqnames[position]);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public LayoutInflater getLayoutInflater() {
		return mLayoutInflater;
	}
}
