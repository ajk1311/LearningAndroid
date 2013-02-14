package com.aj.learningandroid.listexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Adapter that has a bad implementation of getView().
 * It instantiates a new View every time the ListView requests a View.
 * This is not only slow when we have even a slightly complex View hierarchy,
 * but it allocates memory for every View. If our list is large (thousands
 * or even millions of Views), then we will waste a ton of memory.
 * 
 * @author akausejr
 *
 */
public class BadAdapter extends NamesAdapter {

	public BadAdapter(Context context, String[] names, String[] uniqnames) {
		super(context, names, uniqnames);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		/*
		 * Creates a new view every time the ListView requests a view
		 * THIS IS BAD!
		 */
		final View v = getLayoutInflater().inflate(R.layout.listitem, parent, false);
		
		/*
		 * Finds all the views we need every time
		 * THIS IS BAD!
		 */
		final TextView nameView = (TextView) v.findViewById(R.id.name);
		final TextView uniqnameView = (TextView) v.findViewById(R.id.uniqname);
		final ImageView iconView = (ImageView) v.findViewById(R.id.icon);
		
		final String name = mNames[position];
		final String uniqname = mUniqnames[position];
		
		nameView.setText(name);
		uniqnameView.setText(uniqname);
		iconView.setImageResource(R.drawable.block_m);
		
		return v;
	}

}
