package com.moviefeel.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.moviefeel.activities.R;
import com.moviefeel.helper.Constants;
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
	
	private Button btnSetDummyText;
	
	private IApi api;
	private String movieTitle;
	private Movie movie;

	public MovieDetailsFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_movie_details,
				container, false);
		
		movie = api.getInitialMovieDetails(movieTitle);
		
		initUI(rootView);
		setListeners();

		return rootView;
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
//		btnSetDummyText = (Button) v.findViewById(R.id.btnSetDummyText);
		
		tvMpaaRating.setText(movie.getMpaa_rating());
		tvCriticsConsensus.setText(movie.getCritics_consensus());
		tvCriticsRating.setText(movie.getRatings().getCritics_rating());
		tvCriticsScore.setText(movie.getRatings().getCritics_score());
		tvAudienceRating.setText(movie.getRatings().getAudience_rating());
		tvAudienceScore.setText(movie.getRatings().getAudience_score());
		tvRuntime.setText(movie.getRuntime());
		tvSynopsis.setText(movie.getSynopsis());
	}

	private void setListeners() {
//		btnSetDummyText.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//			}
//		});
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
