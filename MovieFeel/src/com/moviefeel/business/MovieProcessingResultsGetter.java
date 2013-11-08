package com.moviefeel.business;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.moviefeel.activities.MainActivity;
import com.moviefeel.activities.R;
import com.moviefeel.fragments.MovieProcessingResultsFragment;
import com.moviefeel.model.OpinionRating;
import com.moviefeel.services.IApi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class MovieProcessingResultsGetter extends
		AsyncTask<String, Void, OpinionRating> {
	
	private ProgressDialog dialog;
	private Activity act;
	private String title;
	private IApi api;

	public MovieProcessingResultsGetter(Activity context,String title,IApi api) {
		dialog = new ProgressDialog(context);
		this.act = context;
		this.title = title;
		this.api = api;
	}

	protected OpinionRating doInBackground(String... urls) {

		try {
			OpinionRating opinionRating = null;
			URL link = new URL(urls[0]);
			URLConnection tc = link.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					tc.getInputStream()));

			JSONObject js = new JSONObject(in.readLine());

			String angerRating = null;
			String disgustRating = null; 
			String fearRating = null;
			String joyRating = null;
			String processedRating = null;
			String surpriseRating = null;

			if (js.has("angerRating"))
				angerRating = js.getString("angerRating");
			if (js.has("disgustRating"))
				disgustRating = js.getString("disgustRating");
			if (js.has("fearRating"))
				fearRating = js.getString("fearRating");
			if (js.has("joyRating"))
				joyRating = js.getString("joyRating");
			if (js.has("processedRating"))
				processedRating = js.getString("processedRating");
			if (js.has("surpriseRating"))
				surpriseRating = js.getString("surpriseRating");

			opinionRating = new OpinionRating(angerRating, disgustRating,
					fearRating, joyRating, processedRating, surpriseRating);
			dialog.dismiss();
			
			openMovieProcessingResultsFragment(opinionRating);
			return opinionRating;

		} catch (Exception e) {
			Log.e("Error", "Failed to load opinions", e);
			dialog.dismiss();
			return null;
		}

	}
	public void openMovieProcessingResultsFragment(OpinionRating opinionRating) {
		if (act instanceof MainActivity) {

			MovieProcessingResultsFragment contentFrag = new MovieProcessingResultsFragment();
			contentFrag.setAct(act);
			contentFrag.setApi(api);
			contentFrag.setMovieTitle(title);
			contentFrag.setOpinionRating(opinionRating);

			FragmentManager fragmentManager = ((MainActivity) act).getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			fragmentTransaction.replace(R.id.fragment_container, contentFrag);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
		}
	}
	protected void onPreExecute() {
		this.dialog.setMessage("Processing...");
		this.dialog.show();
	}

	protected void onPostExecute(final Boolean success) {
		if (dialog.isShowing()) {
			dialog.dismiss();
		}
	}

}
