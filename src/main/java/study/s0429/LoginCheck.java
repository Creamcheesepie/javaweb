package study.s0429;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/s0429/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"" :request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null?"" :request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		MemberVO loginVO = new MemberVO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		loginVO = dao.getLoginCheck(mid,pwd);
		
		Date date = new  Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate= format.format(date);

		if(loginVO!=null) {
			session.setAttribute("sLoginMid", mid);
			
			String lastLoginDate = loginVO.getLastLoginDate();
			lastLoginDate = lastLoginDate.substring(0,10);
			session.setAttribute("sTotalLoginCount", loginVO.getTotalLoginCount()+1);
			
			if(!lastLoginDate.equals(nowDate)) {
				int point = loginVO.getPoint();

				point+=10;
				dao.memberUpdate(mid, point);
			}
			
			out.print("<script>");
			out.print("alert('"+mid+"님 환영합니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0429_study/main.jsp'");
			out.print("</script>");
		}
		else {
			out.print("<script>");
			out.print("alert('로그인에 실패하셨습니다. 아이디와 비밀번호를 확인해주세요.');");
			out.print("location.href='"+request.getContextPath()+"/study/0429_study/login.jsp'");
			out.print("</script>");	
		}
		
		
	}
}
