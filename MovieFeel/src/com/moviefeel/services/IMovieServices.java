package com.moviefeel.services;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;


/**
 * Interface that defines the methods needed for creating movie services
 * @author Vlad
 *
 */
public interface IMovieServices {
	
	public void getMovieRating(Activity context,String title,IApi api) throws InterruptedException, ExecutionException;
	public ArrayList<String> getMovieList(Activity act) throws InterruptedException, ExecutionException;
	public void getInitialMovieDetails(Activity activity, String title,IApi api, String niceFormat) throws InterruptedException, ExecutionException;

}
