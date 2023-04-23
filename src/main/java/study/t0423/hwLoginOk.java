package study.t0423;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0423/hwLoginOk")
public class hwLoginOk  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		
		String mid = request.getParameter("mid") == null? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd") == null? "" : request.getParameter("pwd");
		String member;
		
		if((mid.equals("gregor")||mid.contentEquals("admin")||mid.equals("potato")) && pwd.equals("1234")) {
			System.out.println("로그인 성공");
			member="OK";
		}
		else {
			System.out.println("로그인 실패");
			member="NO";
		}
		
		response.sendRedirect(request.getContextPath()+"/study/0423/Homework.jsp?member="+member);
	}
}
