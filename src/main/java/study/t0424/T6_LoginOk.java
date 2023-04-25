package study.t0424;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/t0424/T6_LoginOk")
public class T6_LoginOk extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")== null? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")== null? "" : request.getParameter("pwd");
		String idSave = request.getParameter("idSave")==null?"off" : request.getParameter("idSave");
		System.out.println("idSave:" + idSave);
//		String viewPage="";
		PrintWriter out = response.getWriter();
		//세션을 쓰기 위해서는 타입을 지정해 줄 때에는 더 상위의 타입을 지정해주어야한다.(중요)
		HttpSession session = request.getSession();
		
		if((mid.equals("admin") || mid.equals("hkd1234")) && pwd.equals("1234")){
//			viewPage="/study/0425_storage/t5_member.jsp";
//			request.getRequestDispatcher(viewPage).forward(request, response);
//			request.setAttribute("mid", mid);
			session.setAttribute("sMid", mid);
			
			Cookie cookieMid = new Cookie("cMid",mid);
			
			if(idSave.equals("on")) {
				cookieMid.setMaxAge(60*60*7*24);	//쿠키의 만료시간을 1주일로 설정
			}
			else {
				cookieMid.setMaxAge(0);	//쿠키의 만료시간을 1주일로 설정
			}
			response.addCookie(cookieMid);
			
			out.print("<script>");
			out.print("alert('"+mid+"님 로그인 되었습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0425_storage/t6_Member.jsp';");
			out.print("</script>");
			
		}
		else {
//			viewPage="/study/0425_storage/t5_Login.jsp";
//			request.getRequestDispatcher(viewPage).forward(request, response);
			out.print("<script>");
			out.print("alert('로그인 실패... 아이디나 비밀번호를 확인해 주세요..');");
			out.print("location.href='"+request.getContextPath()+"/study/0425_storage/t6_Login.jsp';");
			out.print("</script>");
		}
		
		
		
	}
}
