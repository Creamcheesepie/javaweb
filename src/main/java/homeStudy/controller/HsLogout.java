package homeStudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HsLogout implements HsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String loginMid = (String)session.getAttribute("sLoginMid");
		session.invalidate();
		String msg="", url="";
		
		msg = loginMid+"님 로그아웃 되었습니다.";
		url ="/hsMain.hs";
		request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);
	}

}
