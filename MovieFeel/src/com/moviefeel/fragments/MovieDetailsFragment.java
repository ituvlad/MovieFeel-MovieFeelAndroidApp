package com.moviefeel.fragments;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moviefeel.activities.MainActivity;
import com.moviefeel.activities.R;
import com.moviefeel.helper.Constants;
import com.moviefeel.helper.image.ImageLoader;
import com.moviefeel.model.Movie;
import com.moviefeel.services.IApi;

/**
 * Fragment that displays the details for a specific movie that it receives from
 * the main activity This also makes a call to the opinion mining processing
 * 
 * @author Vlad
 * 
 */
public class MovieDetailsFragment extends Fragment {
	public static final String TAG = Constants.TAG_FRAGMENT_MOVIEDETAILS;

	/**
	 * Private attributes
	 */
	private ImageView ivThumbnail;
	private Button btnDoOpinionMining;
	private IApi api;
	private String movieTitle;
	private Movie movie;

	private String movieNiceFormatTitle;
	private Activity act;

	public MovieDetailsFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_movie_details,
				container, false);
		if (movie != null) {
			initUI(rootView);
			setListeners();
		}

		return rootView;
	}

	private void initUI(View v) {
		TextView tvTitle = ((TextView) v.findViewById(R.id.tvMovieTitle));
		TextView tvSynopsis = ((TextView) v.findViewById(R.id.tvSynopsis));
		TextView tvCriticsScore = ((TextView) v
				.findViewById(R.id.tvCriticsScore));
		TextView tvAudienceRatingUp = ((TextView) v
				.findViewById(R.id.tvAudienceRatingUp));
		TextView tvAudienceScore = ((TextView) v
				.findViewById(R.id.tvAudienceScore));
		ivThumbnail = ((ImageView) v.findViewById(R.id.ivThumbnail));
		btnDoOpinionMining = ((Button) v.findViewById(R.id.btnDoOpinionMining));

		String notAvailable = act.getResources().getString(
				R.string.not_available);
		if (movie.getTitle() != null)
			tvTitle.setText(movie.getTitle());
		else 
			tvTitle.setText(notAvailable);
		
		if (movie.getRatings().getCritics_score() != null)
			tvCriticsScore.setText(!movie.getRatings().getCritics_score()
					.equals("null") ? movie.getRatings().getCritics_score()
					: notAvailable);
		else 
			tvCriticsScore.setText(notAvailable);
		
		if (movie.getRatings().getAudience_rating() != null)
			tvAudienceRatingUp.setText(!movie.getRatings().getAudience_rating()
					.equals("null") ? movie.getRatings().getAudience_rating()
					: notAvailable);
		else 
			tvAudienceRatingUp.setText(notAvailable);
		
		if (movie.getRatings().getAudience_score() != null)
			tvAudienceScore.setText(!movie.getRatings().getAudience_score()
					.equals("null") ? movie.getRatings().getAudience_score()
					: notAvailable);
		else 
			tvAudienceScore.setText(notAvailable);
		
		if (movie.getSynopsis() != null)
			tvSynopsis.setText(!movie.getSynopsis().equals("null") ? movie
					.getSynopsis() : notAvailable);
		else 
			tvSynopsis.setText(notAvailable);
		
		try {

			ImageLoader imgLoader = new ImageLoader(act.getApplicationContext());
			int loader = R.drawable.ic_launcher;
			imgLoader.DisplayImage(movie.getPoster().getOriginal(), loader,
					ivThumbnail);

		} catch (Exception e) {

			e.printStackTrace();
			Toast.makeText(act, e.toString(), Toast.LENGTH_LONG).show();
		}
	}

	private void setListeners() {
		btnDoOpinionMining.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					api.getMovieRating(act, movie.getId(), api);
				} catch (Exception e) {
					Toast.makeText(act, e.getMessage(), Toast.LENGTH_SHORT)
							.show();
				}
			}
		});
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
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

	public String getMovieNiceFormatTitle() {
		return movieNiceFormatTitle;
	}

	public void setMovieNiceFormatTitle(String movieNiceFormatTitle) {
		this.movieNiceFormatTitle = movieNiceFormatTitle;
	}

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
