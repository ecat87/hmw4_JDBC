package edu.neu.CS5200.hmw4.entity;

import java.sql.Date;

public class Actor {
	private int actorId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	//all setters and getters
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	//all argument constructor
	public Actor(int actorId, String firstName, String lastName,
			Date dateOfBirth) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	//no argument constructor
	public Actor() {
		super();
	}
}
