package com.moviefeel.business;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;

import com.moviefeel.helper.Constants;
import com.moviefeel.helper.IOHelper;
import com.moviefeel.model.Movie;

/**
 * This is a handler class for the get requests
 * All requests go through this
 * @author Vlad
 *
 */
public class GetHandler {

	/**
	 * Private methods
	 */
	private MovieListGetter movieListGetter;
	private MovieDetailsGetter movieDetailsGetter;
	private String ipAddress;
	private Activity act;

	public GetHandler(Activity act) {
		this.act = act;
		movieListGetter = new MovieListGetter();
		movieDetailsGetter = new MovieDetailsGetter();
		ipAddress = getIpAddress();
		if (ipAddress == null) {
			ipAddress = Constants.DEFAULT_IP_ADDRESS;
		}
	}

	public ArrayList<String> getMovieList() throws InterruptedException,
			ExecutionException {
		ArrayList<String> arr = null;
		arr = movieListGetter
				.execute(
						"http://" + ipAddress
								+ "/MovieFeel-0.1/rest/getAllMovieTitles")
				.get();
		return arr;
	}

	public Movie getInitialMovieDetails(String movieTitle)
			throws InterruptedException, ExecutionException {
		Movie movie = null;
		movie = movieDetailsGetter
				.execute(
						"http://"
								+ ipAddress
								+ "/MovieFeel-0.1/rest/getInitialMovieDetailsForTitle?title="
								+ movieTitle).get();
		return movie;
	}

	private String getIpAddress() {
		return new IOHelper(act).restoreList(Constants.FILENAME);
	}
}
