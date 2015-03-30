package edu.neu.CS5200.hmw4.entity;

import java.sql.Date;

public class Movie {
	private int movieId;
	private String title;
	private String posterImage;
	private Date releaseDate;
	
	//all setters and getters
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPosterImage() {
		return posterImage;
	}
	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	//all argument constructor
	public Movie(int movieId, String title, String posterImage, Date releaseDate) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.posterImage = posterImage;
		this.releaseDate = releaseDate;
	}
	
	//no argument constructor
	public Movie() {
		super();
	}
}


