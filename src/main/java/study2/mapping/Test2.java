package study2.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mapping/Test2")
public class Test2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="/WEB-INF/study2/mapping/test2.jsp";
		
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
}
