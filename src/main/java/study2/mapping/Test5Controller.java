package study2.mapping;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/mapping/Test5.do")
@WebServlet("*.do")
public class Test5Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String comm = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(comm);
		
		String viewPage="/WEB-INF/study2/mapping";
		
		if(comm.equals("/Test5")) {
			viewPage +="/test5.jsp";
		}
		else if(comm.equals("/Test5_2")) {
			viewPage +="/test5_2.jsp";
		}
		else if(comm.equals("/Test5_3")) {
			viewPage +="/test5_3.jsp";
		}
		else if(comm.equals("/Test5_4")) {
			viewPage +="/test5_4.jsp";
		}
		else if(comm.equals("/Test5_5")) {
			//컨트롤러에서는 넘어오고 넘겨주는 매개변수까지 처리해즘(당장 인터페이스X)
			int su1 = request.getParameter("su1") ==null ? 0: Integer.parseInt(request.getParameter("su1"));
			int su2 = request.getParameter("su2") ==null ? 0: Integer.parseInt(request.getParameter("su2"));
			String op = request.getParameter("op")== null ? "" : request.getParameter("op"); 
			
			Test5Service service = new Test5Service();
			int res = service.testCalc(su1, su2, op);
			
			request.setAttribute("su1", su1);
			request.setAttribute("su2", su2);
			request.setAttribute("op", op);
			request.setAttribute("res", res);
			
			viewPage +="/test5_5.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
