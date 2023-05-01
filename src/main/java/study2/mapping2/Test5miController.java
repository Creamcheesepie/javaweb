package study2.mapping2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study2.mapping.Test5Service;

//@WebServlet("/mapping/Test5.mi")
@WebServlet("*.mi")
public class Test5miController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test5miInterface command = null; //시작할 때 쓰는 객체
		String viewPage="/WEB-INF/study2/mapping2";
		
		String uri = request.getRequestURI();
		String comm = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(comm);
		
		
		if(comm.equals("/Test5")) {
			viewPage +="/test5.jsp";
		}
		else if(comm.equals("/Test5_2")) {
			viewPage +="/test5_2.jsp";
		}
		else if(comm.equals("/Test5_3")) {
			command = new Test5miGugudanCommand();
			command.execute(request, response);
			viewPage +="/test5_3.jsp";
		}
		else if(comm.equals("/Test5_4")) {
			command = new Test5miMsgCommand();
			command.execute(request, response);
			viewPage +="/test5_4.jsp";
		}
		else if(comm.equals("/Test5_5")) {
			command = new Test5miCommand();
			command.execute(request, response);
			viewPage +="/test5_5.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
