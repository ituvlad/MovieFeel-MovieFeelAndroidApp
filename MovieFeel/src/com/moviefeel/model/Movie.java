package com.moviefeel.model;

import java.util.ArrayList;

public class Movie {
	private String title;
	private Rating rating;
	private String mpaa_rating;
	private String critics_consensus;
	private String runtime;
	private String synopsis;
	
	public Movie(){}
	
	
	public Movie(Rating rating, String mpaa_rating,
			String critics_consensus,String runtime,String synopsis) {
		super();
		this.rating = rating;
		this.mpaa_rating = mpaa_rating;
		this.critics_consensus = critics_consensus;
		this.runtime = runtime;
		this.synopsis = synopsis;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Rating getRatings() {
		return rating;
	}
	public void setRatings(Rating ratings) {
		this.rating = ratings;
	}
	public String getMpaa_rating() {
		return mpaa_rating;
	}
	public void setMpaa_rating(String mpaa_rating) {
		this.mpaa_rating = mpaa_rating;
	}
	public String getCritics_consensus() {
		return critics_consensus;
	}
	public void setCritics_consensus(String critics_consensus) {
		this.critics_consensus = critics_consensus;
	}


	public String getRuntime() {
		return runtime;
	}


	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}


	public String getSynopsis() {
		return synopsis;
	}


	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

}
