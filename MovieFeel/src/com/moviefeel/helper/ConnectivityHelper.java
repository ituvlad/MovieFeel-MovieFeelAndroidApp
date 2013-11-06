package com.moviefeel.helper;

import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Helper class to read the connectivity state
 * @author Vlad
 *
 */
public class ConnectivityHelper {
	
	
	public static boolean isDataConnectionActivated(Activity context){
		boolean mobileDataEnabled = false; // Assume disabled
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    try {
	        Class cmClass = Class.forName(cm.getClass().getName());
	        Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
	        method.setAccessible(true); // Make the method callable
	        // get the setting for "mobile data"
	        mobileDataEnabled = (Boolean)method.invoke(cm);
	        return mobileDataEnabled;
	    } catch (Exception e) {
	        // Some problem accessible private API
	        // TODO do whatever error handling you want here
	    	return false;
	    }
	}
	
	public static boolean isWiFiEnabled(Activity act){
		ConnectivityManager connManager = (ConnectivityManager) act.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		if (mWifi.isConnected()) {
			return true;
		}
		return false;
	}

}
