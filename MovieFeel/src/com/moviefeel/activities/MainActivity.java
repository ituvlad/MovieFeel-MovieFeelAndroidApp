package com.moviefeel.activities;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.moviefeel.business.MovieDetailsGetter;
import com.moviefeel.dialogs.IpAddressDialog;
import com.moviefeel.fragments.MovieDetailsFragment;
import com.moviefeel.fragments.MovieProcessingResultsFragment;
import com.moviefeel.helper.Api_Factory;
import com.moviefeel.helper.ConnectivityHelper;
import com.moviefeel.helper.Constants;

/**
 * Main activity of the application
 * It's job is to allow searching for movie details and display those details in a fragment
 * It also contact the server to get a list of movie with which to populate the drop down list
 * @author Vlad
 *
 */
public class MainActivity extends BaseActivity {
	private AutoCompleteTextView etMovieSearch;
	private Button btnMovieSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		api = Api_Factory.getApi(Constants.API, this);
		initUI();
		setListeners();
	}

	private void initUI() {
		etMovieSearch = (AutoCompleteTextView) findViewById(R.id.etMovieSearch);
		populateDropDownCombo();
		btnMovieSearch = (Button) findViewById(R.id.btnMovieSearch);

	}

	public void populateDropDownCombo() {
		try {
			if (ConnectivityHelper.isDataConnectionActivated(this)
					|| ConnectivityHelper.isWiFiEnabled(this)) {
				ArrayList<String> myDBData = api.getMovieList(this);
				if (myDBData != null && myDBData.size() > 0) {
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(
							MainActivity.this,
							android.R.layout.simple_list_item_1, myDBData);
					adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
					etMovieSearch.setAdapter(adapter);
				}
				else{
					Toast.makeText(this,
							getResources().getString(R.string.cannot_contact_server),
							Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(
						this,
						getResources().getString(
								R.string.enable_data_connection),
						Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			Toast.makeText(this,
					e.getMessage(),
					Toast.LENGTH_SHORT).show();
		}
	}

	private void setListeners() {
		btnMovieSearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String title = etMovieSearch.getText().toString()
						.split("\\(")[0].replace(' ', '+');
				title = title.substring(0, title.length() - 1);
				try {
					api.getInitialMovieDetails(MainActivity.this, title, api, etMovieSearch.getText().toString());
				} catch (Exception e) {
					Toast.makeText(MainActivity.this,
							e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_ip_address:
			new IpAddressDialog(MainActivity.this);
			break;
		case R.id.menu_refresh_list:
			populateDropDownCombo();
			break;

		}

		return super.onMenuItemSelected(featureId, item);
	}

}
