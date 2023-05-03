package study2.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.re")
public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginInterface command =null;
		String viewPage="/WEB-INF/study2/login";
		
		String uri= request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(com);
		
		if(com.equals("/Login")){
			viewPage +="/login.jsp";
		}
		else if(com.equals("/Join")) {
			viewPage +="/join.jsp";
		}
		else if(com.equals("/LoginSecure")){
			viewPage +="/loginSecure.jsp";
		}
		else if(com.equals("/JoinSecure")) {
			viewPage +="/joinSecure.jsp";
		}
		else if(com.equals("/joinOk")) {
			command = new LoginJoinOK();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/joinSecureOk")) {
			command = new LoginJoinSecureOK();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/LoginSecureOk")) {
			command = new LoginSecureOKCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/LoginOk")) {
			command = new LoginOKCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/MemberMain")) {
			viewPage +="/memberMain.jsp";
		}
		else if(com.equals("/Logout")) {
			command = new LogoutOKCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/List")) {
			command = new ListCommand();
			command.execute(request, response);
			viewPage +="/memberList.jsp";
		}
		else if(com.equals("/LoginSearch")) {
			command = new LoginSearchCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/MemberSearch")) {
			command = new MemberSearchCommand();
			command.execute(request, response);
			viewPage ="/memberSearch.jsp";
		}
		else if(com.equals("/MemberDlete")) {
			command = new MemberDeleteCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/Update")) {
			command = new MemberUpdateCommand();
			command.execute(request, response);
			viewPage ="/update.jsp";
		}
		else if(com.equals("/updateOk")) {
			command = new MemberUpdateOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
