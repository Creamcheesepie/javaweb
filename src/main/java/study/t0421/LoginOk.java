package study.t0421;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/t0421/LoginOk")
public class LoginOk extends HttpServlet {
 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 response.setContentType("text/html; charset=utf-8");
	 
	 String mid = request.getParameter("mid") == null? "" : request.getParameter("mid"); 
	 String pwd = request.getParameter("pwd") == null? "" : request.getParameter("pwd"); 
	 String member;
	 
	 //회원인증? admin, hkd1234 : 비밀번호 1234
	 
	 if((mid.equals("admin")|| mid.equals("hkd1234")) && pwd.equals("1234")) {
		 System.out.println("로그인 성공.");
		 member = "OK";
	 }
	 else {
		 System.out.println("로그인 실패."); 
		 member = "NO";
	 }
	 //response.send~~
	 response.sendRedirect(request.getContextPath()+"/study/0421_include/main.jsp?member="+member);
	}
}
