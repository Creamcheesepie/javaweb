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
@WebServlet("/s0429/MyInfo")
public class MyInfo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		String loginMid = (String)session.getAttribute("sLoginMid");
		System.out.println(loginMid);
		vo = dao.memberMidSearch(loginMid);
		
		 request.setAttribute("vo", vo);
		 String viewPage="/study/0429_study/myInfo.jsp";
		 request.getRequestDispatcher(viewPage).forward(request, response);
	}
}
