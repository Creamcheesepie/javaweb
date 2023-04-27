package study.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/database/LoginOk2")
public class LoginOk2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null? "" : request.getParameter("mid"); 
		String pwd = request.getParameter("pwd")==null? "" : request.getParameter("pwd");
		
		LoginDAO dao = new LoginDAO();
		
		LoginVO vo = dao.getLoginCheck(mid,pwd); //dao에서 로그인 처리
		
		PrintWriter out = response.getWriter();
		
		if(vo.getName() != null) {
			//회원인증 성공시 처리
			//회원 인증 후 처리 : 자주 사용하는 자료를 세션에 저장하기 (아이디, 이름);
			//DB의 최종접속일과 시스템 날짜를 비교하여 같으면 todaycount = vo.getcount()+1, 다르면 0으로 초기화. 
			//dao.setPointplus실행 
			//접속횟수 5 이상일 때에는 포인트 증가를 더 이상 시키지 않기.
			
			//방문 포인트 처리하기
			dao.setPointPlus(mid);
			
			//세션 처리
			HttpSession session = request.getSession();
			session.setAttribute("sMid", mid);
			session.setAttribute("sName", vo.getName());
			session.setAttribute("sPoint", vo.getPoint()+10); //DB에 값은 갱신했지만, 갱신하기 전에 값을 읽어오기 때문에 여기에서 +10을 해줬다.
			session.setAttribute("sLastDate", vo.getLastDate());
			session.setAttribute("sTodayCount", vo.getTodayCount()+1);
			
			out.print("<script>");
			out.print("alert('"+mid+"님 환영합니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/memberMain.jsp';");
			out.print("</script>");
		}
		else {
			//회원인증 실패시 처리
			out.print("<script>");
			out.print("alert('로그인 실패.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/login.jsp';");
			out.print("</script>");
		}
		
		
	}
}
