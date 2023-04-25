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

@WebServlet("/t0424/H_LoginCheck")
public class H_LoginCheck extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null? "" :request.getParameter("mid"); 
		String pwd = request.getParameter("pwd")==null? "" :request.getParameter("pwd"); 
		PrintWriter out = response.getWriter();
		String logCheck = "";
		String idSave = request.getParameter("idSave")==null? "saveOff" : request.getParameter("idSave");
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		System.out.println("idSave : " + idSave);
		if(idSave.equals("saveOn")) {
			Cookie cookieMid = new Cookie("cMid", mid);
			cookieMid.setMaxAge(60*60*24);
			response.addCookie(cookieMid);
		}
		else {		
			if(cookies!=null) { 
				for(int i=0;i<cookies.length;i++) {
					if(cookies[i].getName().equals("cMid")) {
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
					}
				}
			}
		}
		
		if((mid.equals("admin")||mid.equals("hkd1234")) && pwd.equals("1234")) {
			logCheck="ON";
			session.setAttribute("sMid",mid);
			session.setAttribute("sLogCheck", logCheck);
			
			out.print("<script>");
			out.print("alert('"+mid+"님 로그인 하셨습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0425_storage/h_Main.jsp';");
			out.print("</script>");
		}
		else {
			logCheck="OFF";
			session.setAttribute("sLogCheck", logCheck);
			
			out.print("<script>");
			out.print("location.href='"+request.getContextPath()+"/study/0425_storage/h_Main.jsp';");
			out.print("</script>");
		}
	}
}
