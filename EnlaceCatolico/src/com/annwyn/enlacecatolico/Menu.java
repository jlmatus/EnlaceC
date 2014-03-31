package com.annwyn.enlacecatolico;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;






public class Menu extends Activity  implements ICallbacks {
	private boolean mTwoPane;
	@Override
	protected void onCreate(Bundle savedInstantce){
		super.onCreate(savedInstantce);
		setContentView(R.layout.menu_principal);
		
		if (findViewById(R.id.padre_detail_container) != null) {
			mTwoPane = true;
			
			
		}
		
		ActionBar actionBar = getActionBar();
		//actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab1 = actionBar.newTab().setText("Padre Oscar");
		ActionBar.Tab tab2 = actionBar.newTab().setText("ACI Prensa");
		
		Fragment PadreListFragment = new PadreListFragment();
		Fragment AciFragment = new AciListFragment();
		
		
		
		tab1.setTabListener(new MyTabsListener(PadreListFragment));
		tab2.setTabListener(new MyTabsListener(AciFragment));
		
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		
		//tab1.select();
		//tab2.select();
		//tab1.select();
		
		
		
		//Fragment fragment = new PadreDetailFragment();		
     	//FragmentTransaction transaction = getFragmentManager().beginTransaction();
		//transaction.replace(R.id.padre_list , AciFragment);
		//transaction.replace(R.id.padre_list , PadreListFragment).commit();
		
		
		//FragmentTransaction transaction = getFragmentManager().beginTransaction();
		//transaction.replace(R.id.padre_list , PadreListFragment).commit();
		
		
	}
	
	
	class MyTabsListener implements ActionBar.TabListener {
		public Fragment fragment;
		
		public MyTabsListener (Fragment fragment){
			this.fragment=fragment;
		}
		

		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
			if (null != arg0) {
				 
				arg1.replace(R.id.padre_list , fragment);
				if (mTwoPane) 
					//if (!fragment.getClass().toString().equals("PadreListFragment"))
					{
						
					onItemSelectedPadre("0");
						
					}
				 
				 
			//final del if de arg null	
			}
			
		}

		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			arg1.remove(fragment);		
				
			
		}
		
	}


	@Override
	public void onItemSelectedPadre(String id) {
	 	
		
		if (mTwoPane) {
			
			Bundle arguments = new Bundle();
			arguments.putString(PadreDetailFragment.ARG_ITEM_ID, id);
			Fragment fragment = new PadreDetailFragment();
			fragment.setArguments(arguments);
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.replace(R.id.padre_detail_container , fragment).commit();
			
		} else {	
		Intent detailIntent = new Intent(this, ArticuloDetailActivity.class);
		detailIntent.putExtra(PadreDetailFragment.ARG_ITEM_ID, id);
		detailIntent.putExtra(PadreDetailFragment.ARG_IS_TABLET,"0" );
		startActivity(detailIntent);
			}
		
		}


	@Override
	public void onItemSelectedAci(String id) {
if (mTwoPane) {
			
			Bundle arguments = new Bundle();
			arguments.putString(AciDetailFragment.ARG_ITEM_ID, id);
			Fragment fragment = new AciDetailFragment();
			fragment.setArguments(arguments);
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.replace(R.id.padre_detail_container , fragment).commit();
			
		} else {	
		Intent detailIntent = new Intent(this, AciDetailActivity.class);
		detailIntent.putExtra(AciDetailFragment.ARG_ITEM_ID, id);
		detailIntent.putExtra(AciDetailFragment.ARG_IS_TABLET,"0" );
		startActivity(detailIntent);
			}
		
	}
	
	
}