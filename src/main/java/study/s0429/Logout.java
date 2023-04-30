package study.s0429;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/s0429/Logout")
public class Logout extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String loginMid = (String)session.getAttribute("sLoginMid");
		session.invalidate();
		
		out.print("<script>");
		out.print("alert('"+loginMid+"님 로그아웃 되었습니다.');");
		out.print("location.href='"+request.getContextPath()+"/study/0429_study/main.jsp'");
		out.print("</script>");
	}
}
