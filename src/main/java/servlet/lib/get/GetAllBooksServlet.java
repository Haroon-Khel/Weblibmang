package servlet.lib.get;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mongo.MongoInventory;

public class GetAllBooksServlet {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		 
		 MongoInventory mongo = new MongoInventory();
		 String allBooks = mongo.getAllBooks().toString();
		 mongo.closeOp();
		 resp.getWriter().write(allBooks);
		 
	 }
	
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		 
	 
	 }

}
