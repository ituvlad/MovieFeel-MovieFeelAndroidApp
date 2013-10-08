package com.moviefeel.services.implementation;

import com.moviefeel.model.Movie;
import com.moviefeel.services.IMovieServices;

public class MovieServicesImpl implements IMovieServices{

	@Override
	public String getMovieRating(Movie movie) {
		return "some rating";
	}

}
