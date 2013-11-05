package com.moviefeel.business;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import android.os.AsyncTask;
import android.util.Log;

public class MovieListGetter extends AsyncTask<String, Void, ArrayList<String>> {

	ArrayList<String> results;

	public MovieListGetter() {

		results = new ArrayList<String>();
	}

	protected ArrayList<String> doInBackground(String... urls) {

		try {
			URL link = new URL(urls[0]);
			URLConnection tc = link.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					tc.getInputStream()));

			JSONArray jsArray = new JSONArray(in.readLine());
			for (int i = 0; i < jsArray.length(); i++) {
				//JSONObject js = jsArray.getJSONObject(i);

				String title = jsArray.getString(i);

				results.add(title);

			}

		} catch (Exception e) {
			Log.e("Image", "Failed to load image", e);
		}
		return results;
	}

	protected void onPostExecute(ArrayList<String> arr) {

	}

}
