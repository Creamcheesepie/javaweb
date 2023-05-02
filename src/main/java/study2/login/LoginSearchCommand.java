package study2.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeStudy.controller.MemberDAO;
import homeStudy.controller.MemberVO;

public class LoginSearchCommand implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String mid= request.getParameter("mid")==null? "":request.getParameter("mid");
		 MemberDAO dao = new MemberDAO();
		 MemberVO vo = new MemberVO();
		 
		 vo =dao.memberMidSearch(mid);
		 String url="",msg="";
		
		 if(vo.getMid() != null) {
				url=request.getContextPath()+"/MemberSearch.re";
				request.setAttribute("msg", "NO");
				request.setAttribute("url", request.getContextPath()+url);
			 request.setAttribute("vo", vo);
		 }
		 else {
			msg = mid +"으로 검색한 이름이 존재하지 않습니다.";
			url=request.getContextPath()+"/MemberMain.re";
			request.setAttribute("msg", msg);
			request.setAttribute("url", request.getContextPath()+url);
		 }

	}

}
