package com.moviefeel.model;

/**
 * Model class for the movie dto
 * @author Vlad
 *
 */
public class Movie {
	/**
	 * Private attributes
	 */
	private String id;
	private String title;
	
	private String mpaa_rating;
	private String synopsis;
	
	private Poster poster;
	private Rating rating;
	private OpinionRating opinionRating;
	
	/**
	 * Constructors
	 */
	
	public Movie(){}
	
	
	public Movie(Rating rating,Poster poster,String id, String mpaa_rating,String synopsis) {
		super();
		this.id = id;
		this.rating = rating;
		this.setPoster(poster);
		this.mpaa_rating = mpaa_rating;
		this.synopsis = synopsis;
	}
	
	/**
	 * Getters and setters
	 * @return
	 */
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
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Poster getPoster() {
		return poster;
	}
	public void setPoster(Poster poster) {
		this.poster = poster;
	}
	public OpinionRating getOpinionRating() {
		return opinionRating;
	}
	public void setOpinionRating(OpinionRating opinionRating) {
		this.opinionRating = opinionRating;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

}
