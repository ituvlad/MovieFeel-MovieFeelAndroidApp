package com.moviefeel.helper;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.widget.Toast;

import com.moviefeel.business.MovieDetailsGetter;
import com.moviefeel.business.MovieListGetter;
import com.moviefeel.model.Movie;


public class GetHandler {
	
	
	private MovieListGetter movieListGetter;
	private MovieDetailsGetter movieDetailsGetter;
	
	private WeakReference<Activity> reference;
	private String ipAddress;
	private Activity act;
	
	public GetHandler(Activity act){
		this.act = act;
		reference=new WeakReference<Activity>(act);
		movieListGetter = new MovieListGetter();
		movieDetailsGetter = new MovieDetailsGetter();
		ipAddress = getIpAddress();
		if ( ipAddress == null){
			ipAddress = Constants.DEFAULT_IP_ADDRESS;
		}
	}
	
	public ArrayList<String> getMovieList(){
		ArrayList<String> arr = null;
		try {
			arr = movieListGetter.execute("http://"+ipAddress+"/MovieFeel-0.1/rest/getAllMovieTitles").get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		return arr;
	}
	
	public Movie getInitialMovieDetails(String movieTitle){
		Movie movie = null;
		try {
			movie = movieDetailsGetter.execute("http://"+ipAddress+"/MovieFeel-0.1/rest/getInitialMovieDetailsForTitle?title="+movieTitle).get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		return movie;
	}
	
	private String getIpAddress(){
		return  new IOHelper(act).restoreList(Constants.FILENAME);
	}
}
