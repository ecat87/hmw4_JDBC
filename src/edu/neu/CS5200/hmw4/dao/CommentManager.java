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

import edu.neu.CS5200.hmw4.entity.Comment;

public class CommentManager {
	DataSource ds;
	
	public CommentManager()
	{
	  try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/hmw4");
		System.out.println(ds);
	  } catch (NamingException e) {
		e.printStackTrace();
	  }
	}
	
	//create a comment by movie title and user username
	public void createComment(Comment newComment, String title, String username){
		Connection conn = null;
		String sql = "INSERT INTO Comment(comment, date, movieId, userId) "
				+ "SELECT ?,?,movieId,userId "
				+ "FROM Movie, User "
				+ "WHERE Movie.title=? AND User.username=?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newComment.getComment());
			statement.setDate(2, newComment.getDate());
			statement.setString(3, title);
			statement.setString(4, username);
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
	
	//read all comments
	public List<Comment> readAllComments(){
		Connection conn = null;
		String sql = "SELECT * FROM Comment";
		List<Comment> comments = new ArrayList<Comment>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				Comment comment = new Comment();
				comment.setCommentId(results.getInt("commentId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setMovieId(results.getInt("movieId"));
				comment.setUserId(results.getInt("userId"));
				comments.add(comment);
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
		return comments;
	}
	
	
	//read all comments by username
	//assuming that the username is unique
	public List<Comment> readAllCommentsForUsername(String username){
		Connection conn = null;
		String sql = "SELECT * FROM Comment WHERE Comment.userId = (SELECT userId FROM User WHERE username = ?)";
		List<Comment> comments = new ArrayList<Comment>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				Comment comment = new Comment();
				comment.setCommentId(results.getInt("commentId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setMovieId(results.getInt("movieId"));
				comment.setUserId(results.getInt("userId"));
				comments.add(comment);
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
		return comments;
	}
	
	//read all comments by movie title
	public List<Comment> readAllCommentsForMovie(String title){
		Connection conn = null;
		String sql = "SELECT * FROM Comment WHERE Comment.movieId = (SELECT movieId FROM Movie WHERE title = ?)";
		List<Comment> comments = new ArrayList<Comment>();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, title);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				Comment comment = new Comment();
				comment.setCommentId(results.getInt("commentId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setMovieId(results.getInt("movieId"));
				comment.setUserId(results.getInt("userId"));
				comments.add(comment);
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
		return comments;
	}
	

	//read a comment by commentId
	public Comment readCommentForId(int commentId){
		Connection conn = null;
		String sql = "SELECT * FROM Comment WHERE commentId = ?";
		Comment comment = new Comment();
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, commentId);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				comment.setCommentId(result.getInt("commentId"));
				comment.setComment(result.getString("comment"));
				comment.setDate(result.getDate("date"));
				comment.setMovieId(result.getInt("movieId"));
				comment.setUserId(result.getInt("userId"));
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
		return comment;
	}
	
	//update a comment by commentId
	public void updateComment(int commentId, String newComment){
		Connection conn = null;
		String sql = "UPDATE Comment SET comment = ? WHERE commentId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newComment);
			statement.setInt(2, commentId);
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
	
	//delete a comment by commentId
	public void deleteComment(int commentId){
		Connection conn = null;
		String sql = "DELETE FROM Comment WHERE commentId = ?";
		try {
			conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, commentId);
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

