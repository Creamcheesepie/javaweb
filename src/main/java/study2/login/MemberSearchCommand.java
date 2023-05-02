package study2.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeStudy.controller.MemberDAO;
import homeStudy.controller.MemberVO;

public class MemberSearchCommand implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid= request.getParameter("mid")==null? "":request.getParameter("mid");
		 MemberDAO dao = new MemberDAO();
		 MemberVO vo = new MemberVO();
		 
		 vo =dao.memberMidSearch(mid);
		 
		 request.setAttribute("vo", vo);

	}

}
