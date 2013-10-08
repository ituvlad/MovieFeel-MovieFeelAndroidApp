package com.moviefeel.helper;
import android.app.Activity;

import com.moviefeel.services.IApi;
import com.moviefeel.services.implementation.ApiMoviefeel;

public class Api_Factory {
	private static IApi api;

	/**
	 * 
	 * @param type
	 *            The type of the API (Kinvey, or some other service we will
	 *            have)
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
