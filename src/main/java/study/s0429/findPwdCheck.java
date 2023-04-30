package study.s0429;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s0429/findPwdCheck")
public class findPwdCheck extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null? "" : request.getParameter("mid");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberPWdFind(mid);
		String pwd = vo.getPwd();
		StringBuilder sb = new StringBuilder(pwd);
		PrintWriter out = response.getWriter();
		
		for(int i =0; i<pwd.length();i++) {
			if(i%2==0) {
			sb.setCharAt(i, '*');
			pwd = sb.toString();
			}	
		}
		
		out.print("<script>");
		out.print("alert('"+mid+"님의 비밀번호는 "+pwd+"입니다.');");
		out.print("location.href='"+request.getContextPath()+"/study/0429_study/login.jsp'");
		out.print("</script>");
	}
}
