package study.t0426;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/t0426/Test1Ok")
public class Test1Ok extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("이곳은 doGet입니다");
		
		String title= request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		
		String viewPage="/study/0426/test1Res.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("이곳은 doPost입니다");
		
		String title=request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		doGet(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("이곳은 service입니다.");
		doPost(request, response);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("이곳은 init입니다");
	}
	
	@Override
	public void destroy() {
		System.out.println("이곳은 디스트로이 입니다.");
		
		
	}
	
}
