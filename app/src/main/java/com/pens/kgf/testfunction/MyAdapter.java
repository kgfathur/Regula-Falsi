package com.pens.kgf.testfunction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Model> {

		private final Context context;
		private final ArrayList<Model> modelsArrayList;

		public MyAdapter(Context context, ArrayList<Model> modelsArrayList) {
			 
			super(context, R.layout.target_item, modelsArrayList);
			
			this.context = context;
			this.modelsArrayList = modelsArrayList;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		    
			// 1. Create inflater 
			LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    
			// 2. Get rowView from inflater
			
			View rowView = null;
			if(!modelsArrayList.get(position).isGroupHeader()){
				rowView = inflater.inflate(R.layout.target_item, parent, false);
			
				// 3. Get icon,title & counter views from the rowView
				TextView txtIterasi = (TextView) rowView.findViewById(R.id.item_iterasi);
				TextView txtBawah = (TextView) rowView.findViewById(R.id.item_bawah);
				TextView txtAtas = (TextView) rowView.findViewById(R.id.item_atas);
				TextView nilaixView = (TextView) rowView.findViewById(R.id.item_nilaix);
				TextView nilaifxView = (TextView) rowView.findViewById(R.id.item_nilaifx);
		    
			    // 4. Set the text for textView 
			    //txtIterasi.setImageResource(modelsArrayList.get(position).getIcon());
			    txtIterasi.setText(modelsArrayList.get(position).getIcon());
			    txtBawah.setText(modelsArrayList.get(position).getTitle());
				txtAtas.setText(modelsArrayList.get(position).getCounter());
				nilaixView.setText(modelsArrayList.get(position).getNilaix());
				nilaifxView.setText(modelsArrayList.get(position).getNilaifx());
			}
			else{
					rowView = inflater.inflate(R.layout.group_header_item, parent, false);
					TextView txtBawah = (TextView) rowView.findViewById(R.id.header);
				    txtBawah.setText(modelsArrayList.get(position).getTitle());

			}
		   
		    // 5. retrn rowView
		    return rowView;
		}
}
