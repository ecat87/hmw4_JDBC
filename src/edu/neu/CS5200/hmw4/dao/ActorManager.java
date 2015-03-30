package edu.neu.CS5200.hmw4.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.CS5200.hmw4.entity.Actor;

public class ActorManager {
	DataSource ds;
	
	public ActorManager()
	{
	  try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/hmw4");
		System.out.println(ds);
	  } catch (NamingException e) {
		e.printStackTrace();
	  }
	}
	//create a new actor
	public void createActor(Actor newActor){
		Connection conn = null;
		String sql = "INSERT INTO Actor VALUES (null,?,?,?)";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newActor.getFirstName());
			statement.setString(2, newActor.getLastName());
			statement.setDate(3, newActor.getDateOfBirth());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//read all actors
	public List<Actor> readAllActors(){
		Connection conn = null;
		String sql = "SELECT * FROM Actor";
		List<Actor> actors = new ArrayList<Actor>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				int actorId = results.getInt("actorId");
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				Date dateOfBirth = results.getDate("dateOfBirth");
				Actor actor = new Actor(actorId, firstName, lastName, dateOfBirth);
				actors.add(actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return actors;
	}
	//read an actor by actorId
	public Actor readActor(int actorId){
		Connection conn = null;
		String sql = "SELECT * FROM Actor WHERE actorId = ?";
		Actor actor = new Actor();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, actorId);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				actor.setActorId(result.getInt("actorId"));
				actor.setFirstName(result.getString("firstName"));
				actor.setLastName(result.getString("lastName"));
				actor.setDateOfBirth(result.getDate("dateOfBirth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return actor;
	}
	//update an actor by actorId
	public void updateActor(int actorId, Actor actor){
		Connection conn = null;
		String sql = "UPDATE Actor SET firstName = ?, lastName = ?, dateOfBirth = ? WHERE actorId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, actor.getFirstName());
			statement.setString(2, actor.getLastName());
			statement.setDate(3, actor.getDateOfBirth());
			statement.setInt(4, actorId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//delete an actor
	public void deleteActor(int actorId){
		Connection conn = null;
		String sql = "DELETE FROM Actor WHERE actorId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, actorId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

