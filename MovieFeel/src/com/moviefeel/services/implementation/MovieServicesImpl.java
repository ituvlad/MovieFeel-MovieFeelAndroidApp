package com.moviefeel.services.implementation;

import java.util.ArrayList;

import android.app.Activity;

import com.moviefeel.helper.GetHandler;
import com.moviefeel.model.Movie;
import com.moviefeel.services.IMovieServices;

public class MovieServicesImpl implements IMovieServices{

	@Override
	public String getMovieRating(Movie movie) {
		return "some rating";
	}

	@Override
	public ArrayList<String> getMovieList(Activity act) {
		return new GetHandler(act).getMovieList();
	}

	@Override
	public Movie getInitialMovieDetails(Activity act,String movieTitle) {
		return new GetHandler(act).getInitialMovieDetails(movieTitle);
	}

}
