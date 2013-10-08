package com.moviefeel.fragments;

import com.moviefeel.activities.R;
import com.moviefeel.adapters.ImageAdapter;
import com.moviefeel.helper.Constants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class MovieDetailsFragment extends Fragment {
	public static final String TAG = Constants.TAG_FRAGMENT_MOVIEDETAILS;

	private String movieRatingText;
	private TextView tvMovieRating;
	private Button btnSetDummyText;

	public MovieDetailsFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_movie_details,
				container, false);

		initUI(rootView);
		setListeners();

		return rootView;
	}

	private void initUI(View v) {
		tvMovieRating = (TextView) v.findViewById(R.id.tvMovieRating);
		btnSetDummyText = (Button) v.findViewById(R.id.btnSetDummyText);
	}

	private void setListeners() {
		btnSetDummyText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tvMovieRating.setText(movieRatingText);
			}
		});
	}

	public String getMovieRatingText() {
		return movieRatingText;
	}

	public void setMovieRatingText(String movieRatingText) {
		this.movieRatingText = movieRatingText;
		if (tvMovieRating != null)
			tvMovieRating.setText(movieRatingText);
	}
}
