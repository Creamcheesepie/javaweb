package study.t0421;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0421/Test1Ok")
public class Test1Ok extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//null값 처리?
		String mid = request.getParameter("mid") == null ? "" : request.getParameter("mid");
		String name = request.getParameter("name") == null ? "" : request.getParameter("name");
		String job = request.getParameter("job") == null? "" : request.getParameter("job"); 
		
		/*
//		String mid= request.getParameter("mid");
		String mid="";
		if(request.getParameter("mid") == null) mid = "";
		String name= request.getParameter("name");
		
//		if(mid.equals("admin")) {
		if(request.getParameter("mid").equals("admin")) {
			System.out.println("환영합니다 관리자님!");
		}
		else {
			System.out.println("환영합니다 방문자님!");
		}
		*/
		System.out.println("mid : " + mid);
		System.out.println("name : " + name);
		System.out.println("job : " + job);
		
		request.setAttribute("mid", mid);
		request.setAttribute("name", name);
		request.setAttribute("job", job);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/0421/test1Res2.jsp");
		dispatcher.forward(request, response);
	
		//직렬화로 가게 되면 내용을 그대로 헤더에 담고 이동하게 된다.
		// 조심해야 할 사항? 주소는 이전의 서블릿 파일이 그대로 되어 있다 > 새로고침하면 서블릿 파일의 페이지가 새로고침된다 
		//만약 이게 데이터베이스 저장 페이지면 이 페이지에서 새로고침을 반복하면 DB에 반복 저장이 되게 된다. >> 중복검사를 안하게 되면 계속 DB에 반복저장이 되는 셈이다.
		//피해가는 방법은? 1. 중간에 거쳐가는 파일을 만들어서 링크를 바꾸어준다. 2. 페이지를 넘겨서 그 페이지에 머무르지 않게 해야한다.
		//>>>그렇다면 뒤로가기로 페이지를 이동하게 되어서 다시 부르게 되는 경우가 생긴다면?
		
	}
}
