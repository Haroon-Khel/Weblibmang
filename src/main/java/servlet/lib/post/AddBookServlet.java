package servlet.lib.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mongo.MongoInventory;

public class AddBookServlet {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

	 }
	
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		 
		 String name = req.getParameter("name");
		 String author = req.getParameter("author");
		 String genre = req.getParameter("genre");
		 MongoInventory mongo = new MongoInventory(name, author, genre);
		 mongo.addBook();
		 mongo.closeOp();
		 resp.getWriter().write("1");
		 
	 }

}

/*
 * Input: ajax request should send by post, URL encoded, book name, author and genre
 * Output: Returns 1 if successful, will add unsuccessful code later. Should probably detach CheckBook() method from AddBook() method, 
*/
