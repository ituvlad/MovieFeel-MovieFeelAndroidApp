package com.moviefeel.services.implementation;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;

import com.moviefeel.business.GetHandler;
import com.moviefeel.services.IApi;
import com.moviefeel.services.IMovieServices;

/**
 * Class that implements the interface for movie services
 * @author Vlad
 *
 */
public class MovieServicesImpl implements IMovieServices{

	@Override
	public void getMovieRating(Activity context,String title,IApi api) throws InterruptedException, ExecutionException{
		new GetHandler(context).getOpinionRating(context,title,api);
	}

	@Override
	public ArrayList<String> getMovieList(Activity act) throws InterruptedException, ExecutionException {
		return new GetHandler(act).getMovieList();
	}

	@Override
	public void getInitialMovieDetails(Activity activity, String title,IApi api, String niceFormat) throws InterruptedException, ExecutionException {
		new GetHandler(activity).getInitialMovieDetails(activity,title,api,niceFormat);
	}

}
