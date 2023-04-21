package study.t0420;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0420/SuControl")
public class test5SuControl extends HttpServlet{
 @Override
 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 response.setContentType("text/html; charset=utf-8");
	 
	 
	 String[] strSu = request.getParameterValues("su");
	 int[] intSus = new int[strSu.length];
	 for(int i=0 ; i<strSu.length; i++) {
		 intSus[i] = Integer.parseInt(strSu[i]);
	 }
	 
	 Arrays.sort(intSus);
	 
	 for(int i=0; i<intSus.length;i++) {
		 System.out.println(intSus[i]);
	 }
	 
	 request.setAttribute("intSus", intSus);
	 
	RequestDispatcher dispatcher = request.getRequestDispatcher("/study/0420/test5Out.jsp");
	dispatcher.forward(request, response);
	 
 }
}
