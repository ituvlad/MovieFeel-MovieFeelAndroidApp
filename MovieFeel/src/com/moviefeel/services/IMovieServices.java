package com.moviefeel.services;

import java.util.ArrayList;

import com.moviefeel.model.Movie;

public interface IMovieServices {
	
	public String getMovieRating(Movie movie);
	public ArrayList<String> getMovieList();
	public Movie getInitialMovieDetails(String movieTitle);

}
