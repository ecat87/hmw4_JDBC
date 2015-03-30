package edu.neu.CS5200.hmw4.entity;

import java.sql.Date;

public class Comment {
	private int commentId;
	private String comment;
	private Date date;
	private int movieId;
	private int userId;
	
	//all setters and getters
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//all argument constructor
	public Comment(int commentId, String comment, Date date, int movieId,
			int userId) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.date = date;
		this.movieId = movieId;
		this.userId = userId;
	}
	
	//no argument constructor
	public Comment() {
		super();
	}
}
