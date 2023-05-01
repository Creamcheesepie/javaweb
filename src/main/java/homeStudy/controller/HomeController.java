package homeStudy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.hs")
public class HomeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HsInterface command = null;
		String viewPage = "WEB-INF/homeStudy/practiceController";
		//위 두개는 컨트롤러 작성시 미리 작성해 둘 것.
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		
		if(com.equals("/hsLogin")) {
			viewPage+="/hsLogin.jsp";
		}
		else if(com.equals("/hsLoginCheck")) {
			command = new HsLoginCheck();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/hsLogout")) {
			command = new HsLogout();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/hsMyInfo")) {
			command = new HsGetMyInfo();
			command.execute(request, response);
			viewPage +="/myInfo.jsp";
		}
		else if(com.equals("/hsGoMyInfoChange")) {
			viewPage +="/myInfoChange.jsp";
		}
		else if(com.equals("/hsMyInfoChange")) {
			command = new HsMyInfoChange();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		else if(com.equals("/hsMain")) {
			viewPage+="/main.jsp";
		}
		else if(com.equals("/hsGoSigninPage")) {
			viewPage += "/signIn.jsp";
		}
		else if(com.equals("/hsSignin")) {
			command = new HsSignin();
			command.execute(request, response);
			viewPage ="/include/message.jsp";
		}
		System.out.println();
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
