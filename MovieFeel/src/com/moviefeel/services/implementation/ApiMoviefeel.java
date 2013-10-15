package com.moviefeel.services.implementation;

import java.util.ArrayList;

import android.app.Activity;

import com.moviefeel.model.Movie;
import com.moviefeel.services.IApi;
import com.moviefeel.services.IMovieServices;

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
	public ArrayList<String> getMovieList(Activity act) {
		return movieServices.getMovieList(act);
	}
	@Override
	public Movie getInitialMovieDetails(Activity act,String movieTitle) {
		return movieServices.getInitialMovieDetails(act,movieTitle);
	}
	
	
	
	

}
