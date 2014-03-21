package com.annwyn.enlacecatolico;
import java.util.ArrayList;
import java.util.Arrays;




import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class Menu extends Activity  {
	private static final String PADRE_TABSTRING = "PADRE OSCAR";
	private static final String ACI_TABSTRING = "ACI PRENSA";
	protected static final String THUMBNAIL_IDS = "thumbNailIDs";
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		final ActionBar tabBar = getActionBar();
		tabBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		PadreFragment MyFragment = new PadreFragment();
		tabBar.addTab(tabBar.newTab().setText(PADRE_TABSTRING)
				.setTabListener(new TabListener(MyFragment)));
		

	}
	
	
	public static class TabListener implements ActionBar.TabListener {
		private final Fragment mFragment;

		public TabListener(Fragment fragment) {
			mFragment = fragment;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if (null != mFragment) {
				ft.replace(R.id.fragment_container, mFragment);
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (null != mFragment)
				ft.remove(mFragment);
		}
	}
}
