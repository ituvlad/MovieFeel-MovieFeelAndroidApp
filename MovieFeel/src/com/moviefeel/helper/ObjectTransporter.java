package com.moviefeel.helper;

import java.io.Serializable;
import java.util.ArrayList;

public class ObjectTransporter implements Serializable {

	private ArrayList<String> movies;

	public ObjectTransporter(ArrayList<String> data) {
		this.movies = data;
	}

	public ArrayList<String> getMovies() {
		return this.movies;
	}

}
