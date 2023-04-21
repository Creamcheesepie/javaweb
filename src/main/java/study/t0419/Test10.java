package study.t0419;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t10")
public class Test10 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mid = request.getParameter("mid");
	  String pwd = request.getParameter("pwd");
	  
	  PrintWriter out = response.getWriter();
	  //adim, hkd1234,chpang1 비밀번호 : 1234
	  
	  if(mid.equals("admin") || mid.equals("hkd1234")||mid.equals("chpang1") && pwd.equals("1234")){
	  	System.out.println("로그인 성공!");
	  	out.println("<script>");
	  	out.println("alert('로그인 성공!')");
	  	out.println("location.href='"+request.getContextPath()+"/study/0419/test10Success.jsp';");
	  	out.println("</script>");

	  }
	  else{
	  	System.out.println("로그인 실패, 아이디와 비밀번호를 확인해주세용!");
	  	out.println("<script>");
	  	out.println("alert('로그인 실패!!!');");
	  	out.println("location.href='"+request.getContextPath()+"/study/0419/test10.jsp';");
	  	out.println("</script>");
	  }
		
		
	}
	
	
	
}
