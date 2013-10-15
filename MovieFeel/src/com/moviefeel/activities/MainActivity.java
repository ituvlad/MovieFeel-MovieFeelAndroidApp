package com.moviefeel.activities;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.moviefeel.dialogs.IpAddressDialog;
import com.moviefeel.fragments.MovieDetailsFragment;
import com.moviefeel.helper.Api_Factory;
import com.moviefeel.helper.Constants;
import com.moviefeel.helper.GetHandler;
import com.moviefeel.model.Movie;

public class MainActivity extends BaseActivity {
	/***
	 * https://github.com/ituvlad/MovieFeel-MovieFeelAndroidApp.git
	 */
	private String currentFragmentTag;
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

		ArrayList<String> myDBData = api.getMovieList(this);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_list_item_1,
				myDBData);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		etMovieSearch.setAdapter(adapter);

		btnMovieSearch = (Button) findViewById(R.id.btnMovieSearch);

	}

	private void setListeners() {
		btnMovieSearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String title = etMovieSearch.getText().toString().split("\\(")[0]
						.replace(' ', '+');
				title = title.substring(0, title.length() - 1);

				MovieDetailsFragment contentFrag = new MovieDetailsFragment();
				contentFrag.setAct(MainActivity.this);
				contentFrag.setApi(api);
				contentFrag.setMovieTitle(title);

				currentFragmentTag = MovieDetailsFragment.TAG;
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager
						.beginTransaction();
				fragmentTransaction.add(R.id.fragment_container, contentFrag);
				fragmentTransaction.commit();
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
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_ip_address:
			new IpAddressDialog(MainActivity.this);
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
