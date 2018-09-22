package servlet.lib.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mongo.MongoLibUsers;

public class CreateUserServlet {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

	 }
	
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		 
		 String firstname = req.getParameter("firstname");
		 String lastname = req.getParameter("lastname");
		 String dob = req.getParameter("dob");
		 String contact =  req.getParameter("contact");
		 
		 MongoLibUsers mongo = new MongoLibUsers(firstname, lastname, dob, contact);
		 
		 if (mongo.checkUser()) {
			 //User exists, return a 0
			 resp.getWriter().write("0");
			 
		 }
		 else {
			 //User does not exist, add him
			 resp.getWriter().write("1");
			 mongo.addLibUser();
			  
		 }
		 mongo.closeOp();
				 
	 }

}

/* 
 * Input: ajax request should send by post, URL encoded, firstname, lastname, dob, contact
 * Output: returns 1 if successful, 0 if user already exists
*/
