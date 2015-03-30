<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.neu.CS5200.hmw4.dao.*,edu.neu.CS5200.hmw4.entity.*,java.util.*,java.sql.Date,java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Hello World</h1>
    
    <%
    MovieManager dao = new MovieManager();
   
/*	//insert a newMovie
	Movie newMovie1 = new Movie();
	newMovie1.setTitle("The god father");
	newMovie1.setPosterImage("nice movie");
	newMovie1.setReleaseDate(new Date((new SimpleDateFormat("yyyy-MM-dd").parse("1982-08-09")).getTime()));
	dao.createMovie(newMovie1);
*/		

/*	//read a movie
	Movie movie = dao.readMovie(1);
	System.out.println(movie.getMovieId());
	System.out.println(movie.getTitle());
	System.out.println(movie.getPosterImage());
	System.out.println(movie.getReleaseDate());
*/
/*
	//read all movies
	List<Movie> movies = dao.readAllMovies();
	for(Movie movie : movies){
		System.out.println(movie.getTitle());
		System.out.println(movie.getPosterImage());
	}
*/	
/*		//updatemovie
	Movie updatemovie1 = new Movie();
	updatemovie1.setTitle("One");
	updatemovie1.setPosterImage("true love");
	updatemovie1.setReleaseDate(new Date((new SimpleDateFormat("yyyy-MM-dd").parse("2012-07-07")).getTime()));
	dao.updateMovie(1, updatemovie1);
*/		
	//deletemovie
//	dao.deleteMovie(2);	

	UserManager dao1 = new UserManager();

	/*		//insert a newUser
	User newUser1 = new User();
	newUser1.setUsername("boblovealice");
	newUser1.setPassword("onderland");
	newUser1.setFirstName("Alice");
	newUser1.setLastName("Wonderland");
	newUser1.setEmail("alice@wonderland.com");
	newUser1.setDateOfBirth(new Date((new SimpleDateFormat("yyyy-MM-dd").parse("1982-08-09")).getTime()));			
	dao1.createUser(newUser1);
*/		

/*		//read a user
	User user = dao1.readUser("bobm");
	System.out.println(user.getUserId());
	System.out.println(user.getUsername());
	System.out.println(user.getPassword());
	System.out.println(user.getFirstName());
	System.out.println(user.getLastName());
	System.out.println(user.getEmail());
	System.out.println(user.getDateOfBirth());
*/
/*
	//read all users
	List<User> users = dao1.readAllUsers();
	for(User user : users){
		System.out.println(user.getUsername());
		System.out.println(user.getDateOfBirth());
	}
*/	
/*	
	//updateUser
	User updateUser1 = new User();
	updateUser1.setUsername("alicew");
	updateUser1.setPassword("onderland");
	updateUser1.setFirstName("Alice");
	updateUser1.setLastName("Wonderland");
	updateUser1.setEmail("alice@wonderland.com");
	updateUser1.setDateOfBirth(new Date((new SimpleDateFormat("yyyy-MM-dd").parse("1982-08-09")).getTime()));
	dao1.updateUser("bobm", updateUser1);
*/		
	//deleteUser
//	dao1.deleteUser("alicew");	

	ActorManager dao2 = new ActorManager();
/*		//insert a newActor
	Actor newActor1 = new Actor();
	newActor1.setFirstName("Bob");
	newActor1.setLastName("Gunton");
	newActor1.setDateOfBirth(new Date((new SimpleDateFormat("yyyy-MM-dd").parse("1945-11-15")).getTime()));			
	dao2.createActor(newActor1);
*/		
/*
	//read a actor
	Actor actor = dao2.readActor(2);
	System.out.println(actor.getActorId());
	System.out.println(actor.getFirstName());
	System.out.println(actor.getLastName());
	System.out.println(actor.getDateOfBirth());
*/

	//read all actors
	List<Actor> actors = dao2.readAllActors();
	for(Actor actor : actors){
		System.out.println(actor.getFirstName());
		System.out.println(actor.getLastName());
	}
	
/*	
	//updateActor
	Actor updateactor1 = new Actor();
	updateactor1.setFirstName("Justin");
	updateactor1.setLastName("BB");
	updateactor1.setDateOfBirth(new Date((new SimpleDateFormat("yyyy-MM-dd").parse("1988-11-09")).getTime()));
	dao2.updateActor(1, updateactor1);
*/		
	//deleteActor
	//dao2.deleteActor(3);	

	CommentManager dao3 = new CommentManager();
/*	
	//insert a comment by movie title and username
	Comment newComment = new Comment();
	newComment.setComment("HAHA! Really funny and touching!");
	newComment.setDate(new Date((new SimpleDateFormat("yyyy-MM-dd").parse("2015-03-19")).getTime()));
	dao3.createComment(newComment, "One", "gregoryp");
*/

/*
	//read all comments
	List<Comment> comments = dao3.readAllComments();
	for(Comment comment : comments){
		System.out.println(comment.getCommentId());
		System.out.println(comment.getComment());
		System.out.println(comment.getDate());
		System.out.println(comment.getMovieId());
		System.out.println(comment.getUserId());
	}
*/
/*
	//read all comments by username
	List<Comment> comments = dao3.readAllCommentsForUsername("alicew");
	for(Comment comment : comments){
		System.out.println(comment.getCommentId());
		System.out.println(comment.getComment());
		System.out.println(comment.getDate());
		System.out.println(comment.getMovieId());
		System.out.println(comment.getUserId());
}
*/
/*		
	//read all comments by movie title
	List<Comment> comments = dao3.readAllCommentsForMovie("One");
	for(Comment comment : comments){
		System.out.println(comment.getCommentId());
		System.out.println(comment.getComment());
		System.out.println(comment.getDate());
		System.out.println(comment.getMovieId());
		System.out.println(comment.getUserId());
	}
*/
/*
	//read a comment by commentId
	Comment comment = dao3.readCommentForId(2);
	System.out.println(comment.getCommentId());
	System.out.println(comment.getComment());
	System.out.println(comment.getDate());
	System.out.println(comment.getMovieId());
	System.out.println(comment.getUserId());
	}
*/

	//updateComment by commentId
	//dao3.updateComment(1, "My girlfriend loves it so much!");

	//deleteComment by commentId
	//dao3.deleteComment(4);
	
			CastManager dao4 = new CastManager();
/*	
		//insert a cast by movie title and actor's first&lastname
		Cast cast = new Cast();
		cast.setCharacterName("father");
		dao4.createCast(cast, "Frozen", "Morgan", "Freeman");
*/

/*
		//read all casts
		List<Cast> casts = dao4.readAllCasts();
		for(Cast cast : casts){
			System.out.println(cast.getCastId());
			System.out.println(cast.getCharacterName());
			System.out.println(cast.getMovieId());
			System.out.println(cast.getActorId());
		}
*/
/*
		//read all comments by actor's first&lastName
		List<Cast> casts = dao4.readAllCastsForActor("Justin", "BB");
		for(Cast cast : casts){
			System.out.println(cast.getCastId());
			System.out.println(cast.getCharacterName());
			System.out.println(cast.getMovieId());
			System.out.println(cast.getActorId());
		}
*/
/*	
		//read all comments by movie title
		List<Cast> casts = dao4.readAllCommentsForMovie("One");
		for(Cast cast : casts){
			System.out.println(cast.getCastId());
			System.out.println(cast.getCharacterName());
			System.out.println(cast.getMovieId());
			System.out.println(cast.getActorId());
		}
*/
/*
		//read a cast by castId
		Cast cast = dao4.readCastForId(2);
		System.out.println(cast.getCastId());
		System.out.println(cast.getCharacterName());
		System.out.println(cast.getMovieId());
		System.out.println(cast.getActorId());
*/
/*	
		//updateCast by castId
		Cast newCast = new Cast();
		newCast.setCharacterName("teacher");
		newCast.setMovieId(3);
		newCast.setActorId(2);
		dao4.updateCast(1, newCast);
*/		
		//deleteCast by castId
//		dao4.deleteCast(4);
    %>
</body>
</html>