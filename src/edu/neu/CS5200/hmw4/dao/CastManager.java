package edu.neu.CS5200.hmw4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.CS5200.hmw4.entity.Cast;

public class CastManager {
	DataSource ds;
	
	public CastManager()
	{
	  try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/hmw4");
		System.out.println(ds);
	  } catch (NamingException e) {
		e.printStackTrace();
	  }
	}
	//create a cast by movie title and actor's first&lastname
	public void createCast(Cast newCast, String title, String firstName, String lastName){
		Connection conn = null;
		String sql = "INSERT INTO `Cast`(characterName, movieId, actorId) "
				+ "SELECT ?,movieId,actorId "
				+ "FROM Movie, Actor "
				+ "WHERE title=? AND firstName=? AND lastName=?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newCast.getCharacterName());
			statement.setString(2, title);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
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

	//read all casts
	public List<Cast> readAllCasts(){
		Connection conn = null;
		String sql = "SELECT * FROM Cast";
		List<Cast> casts = new ArrayList<Cast>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				Cast cast = new Cast();
				cast.setCastId(results.getInt("castId"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				casts.add(cast);
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
		return casts;
	}
	
	
	//read all casts by actor's first&lastname
	public List<Cast> readAllCastsForActor(String actorfn, String actorln){
		Connection conn = null;
		String sql = "SELECT * FROM Cast WHERE Cast.actorId = (SELECT actorId FROM Actor WHERE firstname=? AND lastName=?)";
		List<Cast> casts = new ArrayList<Cast>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, actorfn);
			statement.setString(2, actorln);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				Cast cast = new Cast();
				cast.setCastId(results.getInt("castId"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				casts.add(cast);
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
		return casts;
	}

	//read all casts by movie title
	public List<Cast> readAllCommentsForMovie(String title){
		Connection conn = null;
		String sql = "SELECT * FROM Cast WHERE Cast.movieId = (SELECT movieId FROM Movie WHERE title = ?)";
		List<Cast> casts = new ArrayList<Cast>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, title);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				Cast cast = new Cast();
				cast.setCastId(results.getInt("castId"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				casts.add(cast);
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
		return casts;
	}
	

	//read a cast by castId
	public Cast readCastForId(int castId){
		Connection conn = null;
		String sql = "SELECT * FROM Cast WHERE castId = ?";
		Cast cast = new Cast();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, castId);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				cast.setCastId(result.getInt("castId"));
				cast.setCharacterName(result.getString("characterName"));
				cast.setMovieId(result.getInt("movieId"));
				cast.setActorId(result.getInt("actorId"));
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
		return cast;
	}
	
	//update a cast by castId
	public void updateCast(int castId, Cast newCast){
		Connection conn = null;
		String sql = "UPDATE Cast SET characterName = ?, movieId = ?, actorId = ? WHERE castId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newCast.getCharacterName());
			statement.setInt(2, newCast.getMovieId());
			statement.setInt(3, newCast.getActorId());
			statement.setInt(4, castId);
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
	
	//delete a cast by castId
	public void deleteCast(int castId){
		Connection conn = null;
		String sql = "DELETE FROM Cast WHERE castId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, castId);
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
