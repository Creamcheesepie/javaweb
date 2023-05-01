package homeStudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HsGetMyInfo implements HsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		String loginMid = (String)session.getAttribute("sLoginMid");
		vo = dao.memberMidSearch(loginMid);
		System.out.println();
		request.setAttribute("vo", vo);

	}

}
