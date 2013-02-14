package com.aj.learningandroid.listexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Adapter that uses the best implementation of getView(). It solves the problem
 * of wasting memory by reusing the convertView again, but this time we use
 * an inner class called a ViewHolder to prevent traversing the View hierarchy
 * each time. With this implementation, we only need to do the expensive
 * operations when creating the Views, not each time a recycled View is requested.
 * 
 * @author akausejr
 *
 */
public class BestAdapter extends NamesAdapter {

	public BestAdapter(Context context, String[] names, String[] uniqnames) {
		super(context, names, uniqnames);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = convertView;
		ViewHolder vh = null;
		
		/*
		 * Reuse the convertView and the ViewHolder.
		 * THIS IS GOOD!
		 */
		if(convertView != null) {
			vh = (ViewHolder) v.getTag();
		} else {
			v = getLayoutInflater().inflate(R.layout.listitem, parent, false);
			vh = new ViewHolder();
			
			vh.name = (TextView) v.findViewById(R.id.name);
			vh.uniqname = (TextView) v.findViewById(R.id.uniqname);
			vh.icon = (ImageView) v.findViewById(R.id.icon);
			
			v.setTag(vh);
		}
		
		vh.name.setText(mNames[position]);
		vh.uniqname.setText(mUniqnames[position]);
		vh.icon.setImageResource(R.drawable.block_m);
		
		return v;
	}

	static class ViewHolder {
		TextView name;
		TextView uniqname;
		ImageView icon;
	}
}
