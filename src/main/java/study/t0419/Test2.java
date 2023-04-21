package study.t0419;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Test2 extends HttpServlet{
	
	//servletRequest, response 객체를 
	protected void doGet(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out	= response.getWriter();
		out.println("서블릿에서의 출력입니다.");
		out.println("welcome to Servlet!");
		
		}
	
	
}