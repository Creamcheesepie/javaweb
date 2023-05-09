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

@WebServlet("/AjaxTest3")
public class AjaxTest3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo = dao.getMemberMidCheck(mid);
		
		
		/*
		 * String str="";
		 * 
		 * if(vo.getName()==null) { str="찾으시는분이 없구먼유..."; } else { str= vo.getMid()+"/"+
		 * vo.getName()+"/"+ vo.getNickName()+"/"+vo.getGender()+"/"+vo.getPoint(); }
		 */
		
		
		response.getWriter().write(vo.toString());
		
	}
}
