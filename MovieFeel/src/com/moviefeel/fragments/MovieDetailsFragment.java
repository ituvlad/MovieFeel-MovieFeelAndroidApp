package com.moviefeel.fragments;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moviefeel.activities.R;
import com.moviefeel.helper.Constants;
import com.moviefeel.helper.image.ImageLoader;
import com.moviefeel.model.Movie;
import com.moviefeel.services.IApi;

public class MovieDetailsFragment extends Fragment {
	public static final String TAG = Constants.TAG_FRAGMENT_MOVIEDETAILS;

	private TextView tvMpaaRating;
	private TextView tvCriticsConsensus;
	private TextView tvCriticsRating;
	private TextView tvCriticsScore;
	private TextView tvAudienceRating;
	private TextView tvAudienceScore;
	private TextView tvRuntime;
	private TextView tvSynopsis;

	private ImageView ivThumbnail;

	private Button btnSetDummyText;

	private IApi api;
	private String movieTitle;
	private Movie movie;

	private Activity act;

	public MovieDetailsFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_movie_details,
				container, false);

		movie = api.getInitialMovieDetails(act, movieTitle);

		initUI(rootView);
		setListeners();

		return rootView;
	}

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
	}

	private void initUI(View v) {
		tvMpaaRating = ((TextView) v.findViewById(R.id.tvMpaaRating));
		tvCriticsConsensus = ((TextView) v
				.findViewById(R.id.tvCriticsConsensus));
		tvCriticsRating = ((TextView) v.findViewById(R.id.tvCriticsRating));
		tvCriticsScore = ((TextView) v.findViewById(R.id.tvCriticsScore));
		tvAudienceRating = ((TextView) v.findViewById(R.id.tvAudienceRating));
		tvAudienceScore = ((TextView) v.findViewById(R.id.tvAudienceScore));
		tvRuntime = ((TextView) v.findViewById(R.id.tvRuntime));
		tvSynopsis = ((TextView) v.findViewById(R.id.tvSynopsis));
		ivThumbnail = ((ImageView) v.findViewById(R.id.ivThumbnail));
		// btnSetDummyText = (Button) v.findViewById(R.id.btnSetDummyText);

		tvMpaaRating.setText(movie.getMpaa_rating());
		tvCriticsConsensus.setText(movie.getCritics_consensus());
		tvCriticsRating.setText(movie.getRatings().getCritics_rating());
		tvCriticsScore.setText(movie.getRatings().getCritics_score());
		tvAudienceRating.setText(movie.getRatings().getAudience_rating());
		tvAudienceScore.setText(movie.getRatings().getAudience_score());
		tvRuntime.setText(movie.getRuntime());
		tvSynopsis.setText(movie.getSynopsis());
		try {
			
			ImageLoader imgLoader = new ImageLoader(act.getApplicationContext());
			int loader = R.drawable.ic_launcher;
	        imgLoader.DisplayImage(movie.getPoster().getOriginal(), loader, ivThumbnail);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(act, e.toString() + "",
					Toast.LENGTH_LONG).show();
		}
	}

	public static Bitmap getBitmapFromURL(String src) {
	    try {
	        URL url = new URL(src);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoInput(true);
	        connection.connect();
	        InputStream input = connection.getInputStream();
	        Bitmap myBitmap = BitmapFactory.decodeStream(input);
	        return myBitmap;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public static Drawable drawableFromUrl(String url) throws IOException {
	    Bitmap x;

	    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	    connection.connect();
	    InputStream input = connection.getInputStream();

	    x = BitmapFactory.decodeStream(input);
	    return new BitmapDrawable(x);
	}
	private void setListeners() {
		// btnSetDummyText.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// }
		// });
	}

	public IApi getApi() {
		return api;
	}

	public void setApi(IApi api) {
		this.api = api;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
}
