package com.moviefeel.activities;

import java.util.ArrayList;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.moviefeel.helper.Api_Factory;
import com.moviefeel.helper.ConnectivityHelper;
import com.moviefeel.helper.Constants;
import com.moviefeel.helper.ObjectTransporter;

public class SplashScreenActivity extends BaseActivity {

	private ProgressBar pbLoading;
	private ArrayList<String> myDBData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		api = Api_Factory.getApi(Constants.API, this);
		pbLoading = (ProgressBar) findViewById(R.id.pbLoadingSplash);
		Toast.makeText(SplashScreenActivity.this, "no amu ne apucam",
				Toast.LENGTH_SHORT).show();

//		Intent activity = new Intent(SplashScreenActivity.this,
//				MainActivity.class);
//		activity.putExtra("movieList", new ObjectTransporter(myDBData));
//		startActivity(activity);
//		SplashScreenActivity.this.finish();
		 new LongOperation().execute("");
	}

	private class LongOperation extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {

			if (ConnectivityHelper
					.isDataConnectionActivated(SplashScreenActivity.this)
					|| ConnectivityHelper
							.isWiFiEnabled(SplashScreenActivity.this)) {
				myDBData = api.getMovieList(SplashScreenActivity.this);
				Intent activity = new Intent(SplashScreenActivity.this,
						MainActivity.class);
				activity.putExtra("movieList", new ObjectTransporter(myDBData));
				startActivity(activity);
				SplashScreenActivity.this.finish();
			} else {
				Toast.makeText(
						SplashScreenActivity.this,
						"Please connect to a wireless network or enable the mobile data connection!",
						Toast.LENGTH_SHORT).show();
			}
			Toast.makeText(SplashScreenActivity.this, "dupa masa",
					Toast.LENGTH_SHORT).show();
			return "";
		}

		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(SplashScreenActivity.this, "ppost execute",
					Toast.LENGTH_SHORT).show();
			pbLoading.setVisibility(ProgressBar.INVISIBLE);
			Intent activity = new Intent(SplashScreenActivity.this,
					MainActivity.class);
			activity.putExtra("movieList", new ObjectTransporter(myDBData));
			startActivity(activity);
			SplashScreenActivity.this.finish();
		}

		@Override
		protected void onPreExecute() {
			pbLoading.setVisibility(ProgressBar.VISIBLE);
			Toast.makeText(SplashScreenActivity.this, "pre execute",
					Toast.LENGTH_SHORT).show();
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}

}
