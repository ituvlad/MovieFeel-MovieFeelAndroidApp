package com.moviefeel.helper;
import android.app.Activity;

import com.moviefeel.services.IApi;
import com.moviefeel.services.implementation.ApiMoviefeel;

/**
 * Factory that creates apis given as a parameter 
 * @author Vlad
 *
 */
public class Api_Factory {
	private static IApi api;

	/**
	 * 
	 * @param type
	 *            
	 * @return
	 */
	public static IApi getApi(String type, Activity context) {

		if (type.equals(Constants.API)) {
			api = ApiMoviefeel.getInstance();

		} else {
			api = null;
		}

		return api;

	}

}
