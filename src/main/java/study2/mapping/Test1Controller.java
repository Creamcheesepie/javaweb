package study2.mapping;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mapping/Test1")
public class Test1Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("이곳은 서블릿의 /mapping/Test1 입니다."); //디렉토리 패턴
		
		//                 /WEB-INF/study2/mapping/test1.jsp
		String viewPage = "/WEB-INF/study2/mapping/test1.jsp";
		requset.getRequestDispatcher(viewPage).forward(requset, response);
	}
}
