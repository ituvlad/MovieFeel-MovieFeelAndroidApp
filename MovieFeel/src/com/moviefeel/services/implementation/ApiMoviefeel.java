package com.moviefeel.services.implementation;

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
	
	
	
	

}
