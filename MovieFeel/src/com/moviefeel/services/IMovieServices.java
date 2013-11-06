package com.moviefeel.services;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;

import com.moviefeel.model.Movie;

/**
 * Interface that defines the methods needed for creating movie services
 * @author Vlad
 *
 */
public interface IMovieServices {
	
	public String getMovieRating(Movie movie);
	public ArrayList<String> getMovieList(Activity act) throws InterruptedException, ExecutionException;
	public Movie getInitialMovieDetails(Activity act,String movieTitle) throws InterruptedException, ExecutionException;

}
