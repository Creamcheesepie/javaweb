package homeStudy.pageProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.pp")
public class HsBoardController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HsBoardInterface command = null;
		String viewPage="WEB-INF/homeStudy/ppStudy";
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		if(com.equals("/hsBoardList")) {
			command = new BoardListCommand();
			command.execute(request, response);
			viewPage+="/hsBoardList.jsp";
		}
		else if(com.equals("/hsBoardWrite")) {
			viewPage +="/hsBoardWrite.jsp";
		}
		else if(com.equals("/hsBoardWriteSubmit")) {
			command = new BoardWriteSubmitCommand();
			command.execute(request, response);
			viewPage+="/hsBoardSubmitClear.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
