package com.aj.learningandroid.listexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Adapter that has a better implementation of getView() than BadAdapter,
 * but we can still do better. This one solves the issue of allocating memory
 * for each View because it takes advantage of ListView's recycling optimization.
 * It is still not the best in performance because we need to traverse the 
 * View hierarchy each time again.
 * 
 * @author akausejr
 *
 */
public class BetterAdapter extends NamesAdapter {

	public BetterAdapter(Context context, String[] names, String[] uniqnames) {
		super(context, names, uniqnames);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = convertView;
		
		/*
		 * If the convertView is valid, reuse it!
		 */
		if(v == null) {
			v = getLayoutInflater().inflate(R.layout.listitem, parent, false);
		}
		
		/*
		 * Still need to find views each time
		 * THIS IS STILL BAD!
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
