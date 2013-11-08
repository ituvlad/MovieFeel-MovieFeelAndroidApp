package com.moviefeel.business;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.moviefeel.activities.MainActivity;
import com.moviefeel.activities.R;
import com.moviefeel.fragments.MovieDetailsFragment;
import com.moviefeel.model.Movie;
import com.moviefeel.model.Poster;
import com.moviefeel.model.Rating;
import com.moviefeel.services.IApi;

/**
 * This class is an async task that makes a request to the server to get details for a specific movie
 * @author Vlad
 *
 */
public class MovieDetailsGetter extends AsyncTask<String, Void, Movie> {

	private ProgressDialog dialog;
	private Activity act;
	private String title;
	private IApi api;
	private String niceFormat;
	
	public MovieDetailsGetter(Activity context,String title,IApi api,String niceFormat) {
		this.act = context;
		this.title = title;
		this.api = api;
		this.niceFormat = niceFormat;
	}

	@Override
	protected void onPreExecute() {
		dialog = new ProgressDialog(act);
		this.dialog.setMessage("Fetching...");
		this.dialog.show();
	}

	protected void onPostExecute(final Boolean success) {
		if (dialog.isShowing()) {
			dialog.dismiss();
		}
		
	}
	
	protected Movie doInBackground(String... urls) {

		try {
			Movie movie = null;
			URL link = new URL(urls[0]);
			URLConnection tc = link.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					tc.getInputStream()));

			
			JSONObject js = new JSONObject(in.readLine());

			Rating rating = null;
			Poster poster = null;
			
			String id = null;
			String title = null;
			String mpaa_rating = null;
			String runtime = null;
			String synopsis = null;
			JSONObject ratingObject = null;
			JSONObject posters = null;

			if (js.has("imdbId"))
				id = js.getString("imdbId");
			if (js.has("title"))
				title = js.getString("title");
			if (js.has("mpaa_rating"))
				mpaa_rating = js.getString("mpaa_rating");
			if (js.has("runtime"))
				runtime = js.getString("runtime");
			if (js.has("synopsis"))
				synopsis = js.getString("synopsis");
			if (js.has("posters"))
				posters = js.getJSONObject("posters");
			 if (js.has("ratings"))
				 ratingObject = js.getJSONObject("ratings");

			rating = getMovieRating(ratingObject);
			poster = getMoviePoster(posters);

			movie = new Movie(rating,poster,id,mpaa_rating,synopsis);
			movie.setTitle(title);
			dialog.dismiss();
			
			openMovieDetailsFragment(movie);
			return movie;

		} catch (Exception e) {
			Toast.makeText(act, "Failed to load initial movie details", Toast.LENGTH_SHORT).show();
			dialog.dismiss();
			return null;
		}
	}
	
	private Poster getMoviePoster(JSONObject posters){
		try {
			String thumbnail = null;
			String detailed = null;
			String original = null;
			String profile = null;
			
			if (posters.has("thumbnail"))
				thumbnail = posters.getString("thumbnail");
			if (posters.has("detailed"))
				detailed = posters.getString("detailed");
			if (posters.has("original"))
				original = posters.getString("original");
			if (posters.has("profile"))
				profile = posters.getString("profile");
			
			return new Poster(thumbnail, detailed, original,
					profile);
		} catch (Exception e) {
			Log.e("Image", "Failed to load initial movie details", e);
			return null;
		}
	}

	private void openMovieDetailsFragment(Movie movie){
		try {
			MovieDetailsFragment contentFrag = new MovieDetailsFragment();
			contentFrag.setAct(act);
			contentFrag.setApi(api);
			contentFrag.setMovieTitle(title);
			contentFrag.setMovieNiceFormatTitle(niceFormat);
			contentFrag.setMovie(movie);
			
			FragmentManager fragmentManager = ((MainActivity)act).getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			fragmentTransaction.replace(R.id.fragment_container,
					contentFrag);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();

			RelativeLayout mainLayout;
			mainLayout = (RelativeLayout) act.findViewById(R.id.mainLayout);
			InputMethodManager imm = (InputMethodManager) act.getSystemService(act.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
		} catch (Exception e) {
			Toast.makeText(
					act,
					act.getResources().getString(
							R.string.cannot_contact_server),
					Toast.LENGTH_SHORT).show();
		}
	}
	private Rating getMovieRating(JSONObject ratingObject) {
		try {
			String critics_score = null;
			String critics_rating = null;
			String audience_score = null;
			String audience_rating = null;
			
			if (ratingObject.has("critics_score"))
				critics_score = ratingObject.getString("critics_score");
			if (ratingObject.has("critics_rating"))
				critics_rating = ratingObject.getString("critics_rating");
			if (ratingObject.has("audience_score"))
				audience_score = ratingObject.getString("audience_score");
			if (ratingObject.has("audience_rating"))
				audience_rating = ratingObject.getString("audience_rating");
			
			return new Rating(critics_score, critics_rating, audience_score,
					audience_rating);
		} catch (Exception e) {
			Log.e("Image", "Failed to load initial movie details", e);
			return null;
		}
	}


}
