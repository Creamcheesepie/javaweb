package study2.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MemberDeleteCommand implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("sMid");
		PrintWriter out = response.getWriter();
		
		LoginDAO dao = new LoginDAO();
		
		int res = dao.setDeleteOk(mid);
		session.invalidate();
		
		request.setAttribute("msg", "탈퇴처리되었습니다");
		request.setAttribute("url", request.getContextPath()+"/Login.re");

	}

}
