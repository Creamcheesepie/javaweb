package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberInterface command = null;
		String viewPage="/WEB-INF/member;";
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		
		if(com.equals("/MemberJoin")) {
			viewPage +="/memberJoin.jsp";
		}
		else if(com.equals("/MemberLogin")) {
			command = new MemberLoginCommand();
			command.execute(request, response);
			viewPage +="/memberLogin.jsp";
		}
		else if(com.equals("/MemberLoginOk")) {
			command = new MemberLoginOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/MemberIdCheck")) {
			command = new MemberIdCheckCommand();
			command.execute(request, response);
			viewPage +="/memberIdCheck.jsp";
		}
		else if(com.equals("/MemberNickNameCheck")) {
			command = new MemberNickNameCheckCommand();
			command.execute(request, response);
			viewPage +="/memberNickNameCheck.jsp";
		}
		else if(com.equals("/MemberJoinOk")) {
			command = new MemberJoinOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/MemberLogout")) {
			command = new MemberLogoutCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/MemberMidFind")) {
			viewPage +="/MemberMidFind.jsp";
		}
		else if(com.equals("/MemberMidFindOk")) {
			command = new MemberMidFindOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/MemberPwdFind")) {
			viewPage +="/MemberPwdFind.jsp";
		}
		else if(com.equals("/MemberPwdFindOk")) {
			command = new MemberPwdFindOkCommand();
			command.execute(request, response);
			viewPage +="/memberPwdReset.jsp";
		}
		else if(com.equals("/MemberPwdReset")) {
			command = new MemberPwdResetCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/MemberMain")) {
		command = new MemberMainCommand();
		command.execute(request, response);
		viewPage +="/memberMain.jsp";
		}
		else if(com.equals("/MemberList")) {
			command = new MemberListCommand();
			command.execute(request, response);
			viewPage +="/memberList.jsp";
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
