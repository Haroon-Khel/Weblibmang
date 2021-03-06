package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mongo.MongoUsers;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
	       throws ServletException, IOException {
		 
		System.out.println("get");
		req.getRequestDispatcher("home.html").forward(req, resp);
	}
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  
		 String username = req.getParameter("User");
		 String password = req.getParameter("Password");
		 String account = req.getParameter("acc");
		 MongoUsers mongoUsers = new MongoUsers(username, password, account);
		 boolean isThere = mongoUsers.checkUser();
//		 System.out.printf("%n%s %s %s %s%n", username, password, account, isThere);
		 
		 if (isThere) {
			 resp.getWriter().write("Come on through.");
			 if (account.equals("admin")) {
				 req.getRequestDispatcher("admin.html").forward(req, resp);
			 } else {
				 req.getRequestDispatcher("lib.html").forward(req, resp);
			 }
		 }
		 else {
			 resp.getWriter().write("No such user.");			 
		 }
		 
		 mongoUsers.closeOp();
		  
   }

}
