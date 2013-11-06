package com.moviefeel.activities;

import android.support.v4.app.FragmentActivity;

import com.moviefeel.services.IApi;

/**
 * The base activity allow for better structuring the application and easier to follow inheritance
 * @author Vlad
 *
 */
public class BaseActivity extends FragmentActivity{
	
	protected IApi api;

}
