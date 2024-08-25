package com.zoro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;


public class AddServlet extends HttpServlet{
	
	private static final Logger LOGGER = Logger.getLogger(AddServlet.class.getName());
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		  LOGGER.info("This will be logged to the server log file");
		
		  
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		PrintWriter out = res.getWriter();
		
		out.println("result is :" + k);
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		// Cookies
		
		Cookie cookie = new Cookie("k", k + "");
		res.addCookie(cookie);
		
//		// Session
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
		
		
		res.sendRedirect("sq?k=" + k); // url rewriting
		
		
//		req.setAttribute("k", k);
		
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
	}
	

}


/* 
package com.zoro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        // Retrieve the parameters from the input page
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));
        
        // Perform the addition
        int k = i + j;
        
        // Set the content type to HTML for the response
        res.setContentType("text/html");
        
        // Prepare and send the HTML response
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sum Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 50px; }");
        out.println(".container { background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1); }");
        out.println("h1 { color: #333; }");
        out.println("p { font-size: 18px; color: #555; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Calculation Result</h1>");
        out.println("<p>The result of the addition is: <strong>" + k + "</strong></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

 */
