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

	private String mpaaRatingText;
	private String criticsConsensusText;
	private String criticsRatingText;
	private String criticsScoreText;
	private String audienceRatingText;
	private String audienceScoreText;
	private String runtimeText;
	private String synopsisText;
	
	
	

	private TextView tvMpaaRating;
	private TextView tvCriticsConsensus;
	private TextView tvCriticsRating;
	private TextView tvCriticsScore;
	private TextView tvAudienceRating;
	private TextView tvAudienceScore;
	private TextView tvRuntime;
	private TextView tvSynopsis;
	
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

		tvMpaaRating.setText(mpaaRatingText);
		tvCriticsConsensus.setText(criticsConsensusText);
		tvCriticsRating.setText(criticsRatingText);
		tvCriticsScore.setText(criticsScoreText);
		tvAudienceRating.setText(audienceRatingText);
		tvAudienceScore.setText(audienceScoreText);
		tvRuntime.setText(runtimeText);
		tvSynopsis.setText(synopsisText);
	}

	private void setListeners() {
//		btnSetDummyText.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//			}
//		});
	}

	public String getMpaaRatingText() {
		return mpaaRatingText;
	}

	public void setMpaaRatingText(String mpaaRatingText) {
		this.mpaaRatingText = mpaaRatingText;

	}

	public String getCriticsConsensusText() {
		return criticsConsensusText;
	}

	public void setCriticsConsensusText(String criticsConsensusText) {
		this.criticsConsensusText = criticsConsensusText;

	}
	public String getCriticsRatingText() {
		return criticsRatingText;
	}

	public void setCriticsRatingText(String criticsRatingText) {
		this.criticsRatingText = criticsRatingText;
	}

	public String getCriticsScoreText() {
		return criticsScoreText;
	}

	public void setCriticsScoreText(String criticsScoreText) {
		this.criticsScoreText = criticsScoreText;
	}

	public String getAudienceRatingText() {
		return audienceRatingText;
	}

	public void setAudienceRatingText(String audienceRatingText) {
		this.audienceRatingText = audienceRatingText;
	}

	public String getAudienceScoreText() {
		return audienceScoreText;
	}

	public void setAudienceScoreText(String audienceScoreText) {
		this.audienceScoreText = audienceScoreText;
	}

	public String getRuntimeText() {
		return runtimeText;
	}

	public void setRuntimeText(String runtimeText) {
		this.runtimeText = runtimeText;
	}

	public String getSynopsisText() {
		return synopsisText;
	}

	public void setSynopsisText(String synopsisText) {
		this.synopsisText = synopsisText;
	}
}
