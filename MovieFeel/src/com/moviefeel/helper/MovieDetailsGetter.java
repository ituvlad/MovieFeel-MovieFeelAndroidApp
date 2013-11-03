package com.moviefeel.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.moviefeel.activities.MainActivity;
import com.moviefeel.model.Movie;
import com.moviefeel.model.Poster;
import com.moviefeel.model.Rating;

import android.graphics.Point;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class MovieDetailsGetter extends AsyncTask<String, Void, Movie> {

	ArrayList<Movie> results;

	public MovieDetailsGetter() {

		results = new ArrayList<Movie>();
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
			
			String mpaa_rating = null;
			String critics_consensus = null;
			String runtime = null;
			String synopsis = null;
			JSONObject ratingObject = null;
			JSONObject posters = null;

			if (js.has("critics_consensus"))
				critics_consensus = js.getString("critics_consensus");
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

			movie = new Movie(rating,poster,mpaa_rating,critics_consensus,runtime,synopsis);
			
			return movie;

		} catch (Exception e) {
			Log.e("Image", "Failed to load initial movie details", e);
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

	protected void onPostExecute(ArrayList<String> arr) {

	}

}
