package com.annwyn.enlacecatolico;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;






public class Menu extends Activity  implements ICallbacks {
	
	@Override
	protected void onCreate(Bundle savedInstantce){
		super.onCreate(savedInstantce);
		setContentView(R.layout.menu_principal);
		
		ActionBar actionBar = getActionBar();
		//actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab1 = actionBar.newTab().setText("Padre Oscar");
		ActionBar.Tab tab2 = actionBar.newTab().setText("ACI Prensa");
		
		Fragment PadreListFragment = new PadreListFragment();
		Fragment PadreFragment = new PadreFragment();
		
		tab1.setTabListener(new MyTabsListener(PadreListFragment));
		tab2.setTabListener(new MyTabsListener(PadreFragment));
		
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		
		
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
		Intent detailIntent = new Intent(this, ArticuloDetailActivity.class);
		detailIntent.putExtra(ArticuloDetailFragment.ARG_ITEM_ID, id);
		detailIntent.putExtra(ArticuloDetailFragment.ARG_IS_TABLET,"0" );
		startActivity(detailIntent);
		
	}
	
}