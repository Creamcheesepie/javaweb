package study.t0424;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
		Date date = new  Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate= format.format(date);
		
		
		
		System.out.println("idSave : " + idSave);
		Cookie cookieMid = new Cookie("cMid", mid);
		cookieMid.setPath("/"); //웹 어플리케이선의 '전체(요청)경로'에서 사용(포함)하고자 할 떄에는 '/'로 지정한다.
		if(idSave.equals("saveOn")) {
			cookieMid.setMaxAge(60*60*24);
			response.addCookie(cookieMid);
			System.out.println("ON");
		}
		else {		
			cookieMid.setMaxAge(0);
			response.addCookie(cookieMid);
			System.out.println("Off");
//			if(cookies!=null) { 
//				for(int i=0;i<cookies.length;i++) {
//					if(cookies[i].getName().equals("cMid")) {
//						cookies[i].setMaxAge(0);
//						response.addCookie(cookies[i]);
//					}
//				}
//			}
		}
		
		boolean cSw =false; //true면 오늘 카운트 했음, false면 안했음
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("cDate")) { 
					if(cookies[i].getValue().equals(nowDate)) {//오늘 날짜랑 비교해서 같으면 카운트 했음으로 처리;
						cSw=true;
					}
					else {
						Cookie cookieDateCount = new Cookie("cDate", nowDate); //날짜가 다른 경우에도 오늘의 날짜를 쿠키에 새로 저장
						cookieDateCount.setPath("/");
						cookieDateCount.setMaxAge(60*60*24*31);
						response.addCookie(cookieDateCount);						
					}
				}
				else { //날짜 카운트 하는 쿠키 자체가 없는 경우 쿠키 추가 >>로그인 된 경우에?
					Cookie cookieDateCount = new Cookie("cDate", nowDate);
					cookieDateCount.setPath("/");
					cookieDateCount.setMaxAge(60*60*24*31);
					response.addCookie(cookieDateCount);
				}
			}
		}
		
		
		
		if((mid.equals("admin")||mid.equals("hkd1234")) && pwd.equals("1234")) {
			logCheck="ON";
			session.setAttribute("sMid",mid);
			session.setAttribute("sLogCheck", logCheck);
			
			if(cookies!=null) {
			
				for(int i=0;i<cookies.length;i++) {
					if(cookies[i].getName().equals("cLC")) {
						if(!cSw) { //오늘 기록이 있으면 실행 아래 내용 실행 안시키기. >> 기록된 값이랑 비교, 없거나 있어도 오늘날짜랑 동일하지 않을 때, 카운트하고 오늘날짜 기록시키기. 
							String temp1 =cookies[i].getValue();
							int temp2 = Integer.parseInt(temp1);
							temp2+=1;
							cookies[i].setValue(Integer.toString(temp2));
							response.addCookie(cookies[i]); //기록이 있으면 가져와서 추가
						}
					}
					else {
						String logCount = "1";
						Cookie cookieLogCount = new Cookie("cLC", logCount);
						cookieLogCount.setPath("/");
						cookieLogCount.setMaxAge(60*60*24*31);
						response.addCookie(cookieLogCount); //기록이 없으면 새로 추가
					}
				}
			}
			else {
				String logCount = "1";
				Cookie cookieLogCount = new Cookie("cLC", logCount);
				cookieLogCount.setPath("/");
				cookieLogCount.setMaxAge(60*60*24*31);
				response.addCookie(cookieLogCount); //쿠키가 없는 경우에도 새로 추가.
			}
			
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
