package study.t0419;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t6")
public class Test6 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//html코드로 출력하기 위헤서는 위의 내용이 html코드임을 알려주어야 한다.
		//위치도 중요한가?
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("안녕하세용! 저는 한글이에용!출력되고 싶어용!<br/>");
		out.println("Haha english can easliy output!<br/>");
		
	}
}
