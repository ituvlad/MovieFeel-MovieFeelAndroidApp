package com.moviefeel.helper;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;


public class GetHandler {

	SimpleGet myGet;
	WeakReference<Activity> reference;
	
	public GetHandler(Activity act){
		reference=new WeakReference<Activity>(act);
		myGet = new SimpleGet();
	}
	public GetHandler(){
		myGet = new SimpleGet();
	}
	public ArrayList<String> executeGet(){
		//myGet.execute("http://poi.autocom.ro/db.php?f=get&t=tabel1&l=jud,loc,lat,lon,cat&loc=Timisoara");
		ArrayList<String> arr = null;
		try {
			arr=myGet.execute("http://192.168.1.104:8080/MovieFeel-0.1/rest/getAllMovieTitles").get();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		if (arr.get(3)!=null)
//			new SDCardWriter(reference.get()).saveOnSDCard(arr.get(5).toString());
//		else new SDCardWriter(reference.get()).saveOnSDCard("cacat");
		return arr;
	}
	public ArrayList<String> executeGet(String url){
		
		try {
			return myGet.execute(url).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
