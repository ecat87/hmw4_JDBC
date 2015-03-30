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

import edu.neu.CS5200.hmw4.entity.Movie;

public class MovieManager {
	
		DataSource ds;
	
		public MovieManager()
		{
		  try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/hmw4");
			System.out.println(ds);
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
		}
	
	
	//create a new movie
	public void createMovie(Movie newMovie){
		Connection conn = null;
		String sql = "INSERT INTO Movie VALUES (null,?,?,?)";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newMovie.getTitle());
			statement.setString(2, newMovie.getPosterImage());
			statement.setDate(3, newMovie.getReleaseDate());
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
	//read all movies
	public List<Movie> readAllMovies(){
		Connection conn = null;
		String sql = "SELECT * FROM Movie";
		List<Movie> movies = new ArrayList<Movie>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				int movieId = results.getInt("movieId");
				String title = results.getString("title");
				String posterImage = results.getString("posterImage");
				Date releaseDate = results.getDate("releaseDate");
				Movie movie = new Movie(movieId, title, posterImage, releaseDate);
				movies.add(movie);
				
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
		return movies;
	}
	//read a movie by movieId
	public Movie readMovie(int movieId){
		Connection conn = null;
		String sql = "SELECT * FROM Movie WHERE movieId = ?";
		Movie movie = new Movie();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				movie.setMovieId(result.getInt("movieId"));
				movie.setTitle(result.getString("title"));
				movie.setPosterImage(result.getString("posterImage"));
				movie.setReleaseDate(result.getDate("releaseDate"));
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
		return movie;
	}
	//update a movie by movieId
	public void updateMovie(int movieId, Movie movie){
		Connection conn = null;
		String sql = "UPDATE Movie SET title = ?, posterImage = ?, releaseDate = ? WHERE movieId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3, movie.getReleaseDate());
			statement.setInt(4, movieId);
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
	//delete a movie by movieId
	public void deleteMovie(int movieId){
		Connection conn = null;
		String sql = "DELETE FROM Movie WHERE movieId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, movieId);
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
