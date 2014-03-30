package com.annwyn.enlacecatolico;



import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.annwyn.enlacecatolico.ArticuloListFragment.Callbacks;
import com.annwyn.enlacecatolico.dummy.DummyContent;
import com.annwyn.data.*;


/**
 * A list fragment representing a list of Articulos. This fragment also supports
 * tablet devices by allowing list items to be given an 'activated' state upon
 * selection. This helps indicate which item is currently being viewed in a
 * {@link ArticuloDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class AciListFragment extends ListFragment {

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * activated item position. Only used on tablets.
	 */
	private static final String STATE_ACTIVATED_POSITION = "activated_position";
	

	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	private Callbacks mCallbacks = sDummyCallbacks;
	private ICallbacks miCallbacks  ;

	/**
	 * The current activated item position. Only used on tablets.
	 */
	private int mActivatedPosition = ListView.INVALID_POSITION;

	/**
	 * A callback interface that all activities containing this fragment must
	 * implement. This mechanism allows activities to be notified of item
	 * selections.
	 */
	public interface Callbacks {
		/**
		 * Callback for when an item has been selected.
		 */
		public void onItemSelected(String id);
	}

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(String id) {
		}
	};

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public AciListFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// TODO: replace with a real list adapter.
		
		
		
		 final Activity actividad = this.getActivity();
		 final ProgressDialog dialog = ProgressDialog.show(this.getActivity(), "Connecting...", "Please wait...", false);
		Thread t = new Thread (  new Runnable() {
	  	      @Override
	  	      public void run() {
	  	        // Create a connection
	  	    	  
	  		  	    	
	  	    	try 
	  	    	{
	  		  	    			  	    		
	  	    		setListAdapter(new ArrayAdapter<AciPrensaContent.AciPrensaItem>(getActivity(),
	  	  				com.annwyn.enlacecatolico.R.layout.my_list  ,  
	  	  				com.annwyn.enlacecatolico.R.id.text1  , AciPrensaContent.ITEMS)); 	    		
	  	    		 	    		
	  	    		dialog.dismiss();
	  	    		
	  	    		}	  
	  	      	    	
	  	    	
	  	    	catch (Exception e){
	  	    		dialog.dismiss();
	  	    		
	  	    		
	  	    	}
	  	              
	  	           }
	  	      }
		
				);
	  	    t.start();
	  	  dialog.show();
	  	  
	    }
		
		// simple_list_item_activated_1
		//android.R.layout.simple_list_item_activated_1
		//android.R.id.text1
		
		
	

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Restore the previously serialized activated item position.
		if (savedInstanceState != null
				&& savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
			setActivatedPosition(savedInstanceState
					.getInt(STATE_ACTIVATED_POSITION));
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		miCallbacks = (ICallbacks) activity;
		
	}
	

	@Override
	public void onDetach() {
		super.onDetach();

		// Reset the active callbacks interface to the dummy implementation.
		mCallbacks = sDummyCallbacks;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);

		// Notify the active callbacks interface (the activity, if the
		// fragment is attached to one) that an item has been selected.
		//mCallbacks.onItemSelected(DummyContent.ITEMS.get(position).id);
		
		miCallbacks.onItemSelectedAci(AciPrensaContent.ITEMS.get(position).id);
        
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != ListView.INVALID_POSITION) {
			// Serialize and persist the activated item position.
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}

	/**
	 * Turns on activate-on-click mode. When this mode is on, list items will be
	 * given the 'activated' state when touched.
	 */
	public void setActivateOnItemClick(boolean activateOnItemClick) {
		// When setting CHOICE_MODE_SINGLE, ListView will automatically
		// give items the 'activated' state when touched.
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}

	private void setActivatedPosition(int position) {
		if (position == ListView.INVALID_POSITION) {
			getListView().setItemChecked(mActivatedPosition, false);
		} else {
			getListView().setItemChecked(position, true);
		}

		mActivatedPosition = position;
	}
}
