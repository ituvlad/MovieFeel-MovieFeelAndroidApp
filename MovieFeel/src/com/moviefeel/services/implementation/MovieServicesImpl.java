package com.moviefeel.services.implementation;

import java.util.ArrayList;

import com.moviefeel.helper.GetHandler;
import com.moviefeel.model.Movie;
import com.moviefeel.services.IMovieServices;

public class MovieServicesImpl implements IMovieServices{

	@Override
	public String getMovieRating(Movie movie) {
		return "some rating";
	}

	@Override
	public ArrayList<String> getMovieList() {
		return new GetHandler().getMovieList();
	}

	@Override
	public Movie getInitialMovieDetails(String movieTitle) {
		return new GetHandler().getInitialMovieDetails(movieTitle);
	}

}
