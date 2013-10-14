package com.moviefeel.helper;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.moviefeel.model.Movie;

import android.app.Activity;


public class GetHandler {

	private MovieListGetter movieListGetter;
	private MovieDetailsGetter movieDetailsGetter;
	
	private WeakReference<Activity> reference;
	
	public GetHandler(Activity act){
		reference=new WeakReference<Activity>(act);
		movieListGetter = new MovieListGetter();
		movieDetailsGetter = new MovieDetailsGetter();
	}
	public GetHandler(){
		movieListGetter = new MovieListGetter();
		movieDetailsGetter = new MovieDetailsGetter();
	}
	
	public ArrayList<String> getMovieList(){
		ArrayList<String> arr = null;
		try {
			arr = movieListGetter.execute("http://192.168.1.100:8080/MovieFeel-0.1/rest/getAllMovieTitles").get();
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
			movie = movieDetailsGetter.execute("http://192.168.1.100:8080/MovieFeel-0.1/rest/getInitialMovieDetailsForTitle?title="+movieTitle).get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		return movie;
	}
	
//	public ArrayList<String> executeGet(String url){
//		
//		try {
//			return myGet.execute(url).get();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
}
