package com.moviefeel.services;

import java.util.ArrayList;

import android.app.Activity;

import com.moviefeel.model.Movie;

public interface IMovieServices {
	
	public String getMovieRating(Movie movie);
	public ArrayList<String> getMovieList(Activity act);
	public Movie getInitialMovieDetails(Activity act,String movieTitle);

}
