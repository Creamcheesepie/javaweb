package study2.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

@WebServlet("/AjaxTest1_2")
public class AjaxTest1_2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo = dao.getMemberMidCheck(mid);
		
		PrintWriter out = response.getWriter();
		
		
		String name="";
		
		if(vo.getName()==null) {
			name="찾으시는분이 없구먼유...";
		}
		else {
			name=vo.getName()+"님이 있었구먼유!";
		}
		
		
		response.getWriter().write(name);
		
	}
}
