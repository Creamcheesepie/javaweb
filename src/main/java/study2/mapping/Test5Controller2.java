package study2.mapping;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/mapping/Test5.do")
//@WebServlet("*.do")
public class Test5Controller2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StringBuffer url =  request.getRequestURL();
//		System.out.println(url);
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String comm = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(comm);
		
		String viewPage="/WEB-INF/study2/mapping/test5.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
