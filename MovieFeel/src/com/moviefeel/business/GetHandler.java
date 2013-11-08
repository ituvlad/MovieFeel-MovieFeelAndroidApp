package com.moviefeel.business;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;

import com.moviefeel.activities.MainActivity;
import com.moviefeel.helper.Constants;
import com.moviefeel.helper.IOHelper;
import com.moviefeel.model.OpinionRating;
import com.moviefeel.services.IApi;

/**
 * This is a handler class for the get requests All requests go through this
 * 
 * @author Vlad
 * 
 */
public class GetHandler {

	/**
	 * Private methods
	 */
	private MovieListGetter movieListGetter;
//	private MovieDetailsGetter movieDetailsGetter;
//	private MovieProcessingResultsGetter movieProcessingResultsGetter;
	private String ipAddress;
	private Activity act;

	public GetHandler(Activity act) {
		this.act = act;
		movieListGetter = new MovieListGetter();
//		movieDetailsGetter = new MovieDetailsGetter(act,title,api,niceFormat);
//		movieProcessingResultsGetter = new MovieProcessingResultsGetter(context,title,api);
		ipAddress = getIpAddress();
		if (ipAddress == null) {
			ipAddress = Constants.DEFAULT_IP_ADDRESS;
		}
	}

	public ArrayList<String> getMovieList() throws InterruptedException,
			ExecutionException {
		ArrayList<String> arr = movieListGetter
				.execute(
						"http://" + ipAddress
								+ "/MovieFeel-0.1/rest/getAllMovieTitles")
				.get();
		return arr;
	}

	public void getInitialMovieDetails(Activity activity, String title,IApi api, String niceFormat)
			throws InterruptedException, ExecutionException {
		new MovieDetailsGetter(activity,title,api,niceFormat)
				.execute(
						"http://"
								+ ipAddress
								+ "/MovieFeel-0.1/rest/getInitialMovieDetailsForTitle?title="
								+ title);
	}

	public void getOpinionRating(Activity context,String title,IApi api)
			throws InterruptedException, ExecutionException {
		new MovieProcessingResultsGetter(context,title,api).execute(
				"http://" + ipAddress
						+ "/MovieFeel-0.1/rest/getMovieRating?id="
						+ title);
	}

	private String getIpAddress() {
		return new IOHelper(act).restoreList(Constants.FILENAME);
	}
}
