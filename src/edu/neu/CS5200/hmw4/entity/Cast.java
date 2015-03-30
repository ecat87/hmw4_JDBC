package edu.neu.CS5200.hmw4.entity;

public class Cast {
	private int castId;
	private String characterName;
	private int movieId;
	private int actorId;
	
	
	//all setters and getters
	public int getCastId() {
		return castId;
	}


	public void setCastId(int castId) {
		this.castId = castId;
	}


	public String getCharacterName() {
		return characterName;
	}


	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public int getActorId() {
		return actorId;
	}


	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	
	//all argument constructor
	public Cast(int castId, String characterName, int movieId, int actorId) {
		super();
		this.castId = castId;
		this.characterName = characterName;
		this.movieId = movieId;
		this.actorId = actorId;
	}
	
	//no argument constructor
	public Cast() {
		super();
	}


	
}

