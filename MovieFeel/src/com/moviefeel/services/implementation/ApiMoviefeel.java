package com.moviefeel.services.implementation;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;

import com.moviefeel.model.Movie;
import com.moviefeel.services.IApi;
import com.moviefeel.services.IMovieServices;

/**
 * Implementation for the main interface
 * It uses classes that implement the other interfaces in order to provide for the services
 * @author Vlad
 *
 */
public class ApiMoviefeel implements IApi{
	
	private static ApiMoviefeel instance;
	private static boolean isCreated = false;
	private IMovieServices movieServices;
	
	private ApiMoviefeel(){
		movieServices = new MovieServicesImpl();
	}
	
	public static ApiMoviefeel getInstance(){
		if (!isCreated){
			instance = new ApiMoviefeel();
			return instance;
		}
		return instance;
	}
	
	@Override
	public String getMovieRating(Movie movie) {
		if (movieServices != null){
			return movieServices.getMovieRating(movie);
		}
		return "";
	}
	
	@Override
	public ArrayList<String> getMovieList(Activity act) throws InterruptedException, ExecutionException{
		return movieServices.getMovieList(act);
	}
	
	@Override
	public Movie getInitialMovieDetails(Activity act,String movieTitle) throws InterruptedException, ExecutionException{
		return movieServices.getInitialMovieDetails(act,movieTitle);
	}
	
	
	
	

}
