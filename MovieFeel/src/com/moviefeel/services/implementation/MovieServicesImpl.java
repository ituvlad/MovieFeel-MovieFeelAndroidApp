package com.moviefeel.services.implementation;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;

import com.moviefeel.business.GetHandler;
import com.moviefeel.model.Movie;
import com.moviefeel.services.IMovieServices;

/**
 * Class that implements the interface for movie services
 * @author Vlad
 *
 */
public class MovieServicesImpl implements IMovieServices{

	@Override
	public String getMovieRating(Movie movie) {
		return "some rating";
	}

	@Override
	public ArrayList<String> getMovieList(Activity act) throws InterruptedException, ExecutionException {
		return new GetHandler(act).getMovieList();
	}

	@Override
	public Movie getInitialMovieDetails(Activity act,String movieTitle) throws InterruptedException, ExecutionException {
		return new GetHandler(act).getInitialMovieDetails(movieTitle);
	}

}
