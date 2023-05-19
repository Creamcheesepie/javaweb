package study2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import study2.Api.CrimeApiCommand;
import study2.Api.SaveCrimeDataCommand;
import study2.Api.SaveCrimeDeleteCommand;
import study2.Api.SearchCrimeDataCommand;
import study2.Api.SerchCrimeByPoliceOrderCommand;
import study2.PDSTest.DownLoadCommand;
import study2.PDSTest.FileDeleteCommand;
import study2.PDSTest.FileDownLoadCommand;
import study2.PDSTest.FileUpLoad1OkCommand;
import study2.PDSTest.FileUpLoad2OkCommand;
import study2.PDSTest.FileUpLoad3OkCommand;
import study2.PDSTest.FileUpLoad4OkCommand;
import study2.UUID.UuidCommand;
import study2.ajax2.UserDeleteCommand;
import study2.ajax2.UserInputCommand;
import study2.ajax2.UserListCommand;
import study2.ajax2.UserSearchCommand;
import study2.ajax2.UserUpdateCommand;
import study2.calendar.Calendar2Command;
import study2.calendar.CalendarCommand;

@WebServlet("*.st")
public class studyController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudyInterface command = null;
		String viewPage = "/WEB-INF/study2";
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null?99:(int)session.getAttribute("sLevel");
		
		if(level>4) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
		}
		else if(com.equals("/Password")) {
			viewPage += "/password/password.jsp";
		}
		else if(com.equals("/PassOk1")){
			command = new PassOkCommand();
			command.execute(request, response);
			viewPage+="/password/password.jsp";
		}
		else if(com.equals("/PassOk2")){
			command = new PassOk2Command();
			command.execute(request, response);
			viewPage+="/password/password2.jsp";
		}
		else if(com.equals("/Uuid")) {
			viewPage+="/uuid.jsp";
		}
		else if(com.equals("/Uuidform")) {
			command = new UuidCommand();
			command.execute(request, response);
			viewPage+="/uuid.jsp";
		}
		else if(com.equals("/AjaxTest1")) {
			
			viewPage+="/ajax/ajax1Test.jsp";
		}
		else if(com.equals("/UserList")) {
			command = new UserListCommand();
			command.execute(request, response);
			viewPage+="/ajax2/userList.jsp";
		}
		else if(com.equals("/UserInput")) {
			command = new UserInputCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/UserDelete")) {
			command = new UserDeleteCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/UserSearch")) {
			command = new UserSearchCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/UserUpdate")) {
			command = new UserUpdateCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/FileUpLoad1")) {
			viewPage+="/PDSTest/upLoad1.jsp";
		}
		else if(com.equals("/FileUpLoad1Ok")) {
			command = new FileUpLoad1OkCommand();
			command.execute(request, response);
			viewPage="/include/message.jsp";
		}
		else if(com.equals("/FileUpLoad2")) {
			viewPage+="/PDSTest/upLoad2.jsp";
		}
		else if(com.equals("/FileUpLoad2Ok")) {
			command = new FileUpLoad2OkCommand();
			command.execute(request, response);
			viewPage="/include/message.jsp";
		}
		else if(com.equals("/FileUpLoad3")) {
			viewPage+="/PDSTest/upLoad3.jsp";
		}
		else if(com.equals("/FileUpLoad3Ok")) {
			command = new FileUpLoad3OkCommand();
			command.execute(request, response);
			viewPage="/include/message.jsp";
		}
		else if(com.equals("/FileUpLoad4")) {
			viewPage+="/PDSTest/upLoad4.jsp";
		}
		else if(com.equals("/FileUpLoad4Ok")) {
			command = new FileUpLoad4OkCommand();
			command.execute(request, response);
			viewPage="/include/message.jsp";
		}
		else if(com.equals("/DownLoad")) {
			command = new DownLoadCommand();
			command.execute(request, response);
			viewPage +="/PDSTest/downLoad.jsp";
		}
		else if(com.equals("/FileDownLoad")) {
			command = new FileDownLoadCommand();
			command.execute(request, response);
			viewPage +="/PDSTest/downLoad.jsp";
		}
		else if(com.equals("/FileDelete")) {
			command = new FileDeleteCommand();
			command.execute(request, response);
			viewPage +="/PDSTest/downLoad.jsp";
		}
		else if(com.equals("/ModalTest2")) {
			command = new ModalTest2Command();
			command.execute(request, response);
			viewPage +="/modaltest2.jsp";
		}
		else if(com.equals("/Calendar")) {
			command = new	CalendarCommand();
			command.execute(request, response);
			viewPage +="/calendar/calendar.jsp";
		}
		else if(com.equals("/Calendar2")) {
			command = new	Calendar2Command();
			command.execute(request, response);
			viewPage +="/calendar/calendar2.jsp";
		}
		else if(com.equals("/ApiTest")) {
			viewPage +="/api/apiTest.jsp";
		}
		else if(com.equals("/CrimeApi")) {
			command = new	CrimeApiCommand();
			command.execute(request, response);
			viewPage +="/api/crime/crimeApi.jsp";
		}
		else if(com.equals("/SaveCrimeData")) {
			command = new	SaveCrimeDataCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/SaveCrimeDelete")) {
			command = new	SaveCrimeDeleteCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/SearchCrimeData")) {
			command = new	SearchCrimeDataCommand();
			command.execute(request, response);
			viewPage +="/api/crime/crimeApi.jsp";
		}
		else if(com.equals("/SerchCrimeByPoliceOrder")) {
			command = new	SerchCrimeByPoliceOrderCommand();
			command.execute(request, response);
			viewPage +="/api/crime/crimeApi.jsp";
		}
		else if(com.equals("/PhotoView1")) {
			viewPage +="/photo/photoView1.jsp";
		}
		else if(com.equals("/PhotoView2")) {
			viewPage +="/photo/photoView2.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}
}
