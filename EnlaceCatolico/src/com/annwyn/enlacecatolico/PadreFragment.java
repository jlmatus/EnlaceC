package com.annwyn.enlacecatolico;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class PadreFragment extends Fragment {
	
	protected static final String EXTRA_RES_ID = "POS";
	
	private List<Integer> mThumbNailIDs;
	private GridView mGridview;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//mThumbNailIDs = getArguments().getIntegerArrayList(TabLayoutActivity.THUMBNAIL_IDS);
		
	}
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		//mGridview.setAdapter(new ImageAdapter(getActivity(), mThumbNailIDs));
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.my_list, container, false);
		//mGridview = (GridView) view.findViewById(R.id.gridview);  
		return view;	
	}
}
	
	
