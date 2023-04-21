package study.t0419;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/t8Post","/t8p"})
public class Test8_Post  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //서버한테 정보를 요청할때 utf-8로 인코딩해서 달라고 요청하는 것
		response.setContentType("text/html; charset=utf-8"); //다시 웹페이지에 정보를 응답할때, text는 html로, 문자는 utf-8로 해석하라고 시키는 것.
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("성명 : " + name);
		System.out.println("나이 : " + age);
		PrintWriter out = response.getWriter();
		out.print("성명" + name + "<br/>");
		out.print("나이" + age + "<br/>");
//		out.print("<a href='study/0419/test8Post.jsp'>돌아가기</a>");
		out.print("<a href='"+request.getContextPath()+"/study/0419/test8Post.jsp'>돌아가기</a>");
		
		
	}
}
