package com.zoro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		
		int k = 0;
		
		// Cookies
		Cookie	cookies[] =  req.getCookies();
		
		for(Cookie c : cookies) {
			if(c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}
		
		
		
//		// Session
//		HttpSession session = req.getSession();
//		
//		int k = (int)session.getAttribute("k");
		
//		int k = (int) req.getAttribute("k");
		
//		int k = Integer.parseInt(req.getParameter("k"));
		
		k = k * k;
		
		PrintWriter out = res.getWriter();
		out.println("Result is : " + k);
		
		System.out.println("hi");
		
	}

}
