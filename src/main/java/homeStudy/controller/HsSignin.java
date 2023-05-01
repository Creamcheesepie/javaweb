package homeStudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HsSignin implements HsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid")==null?"" :request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null?"" :request.getParameter("pwd");
		String name = request.getParameter("name")==null?"" :request.getParameter("name");
		String nickName = request.getParameter("nickName")==null?"" :request.getParameter("nickName");
		
		MemberVO nvo = new MemberVO();
		MemberVO ovo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		ovo = dao.memberMidSearch(mid);
		String msg="", url="";
		
		if(ovo.getMid()==null) {
			nvo.setMid(mid);
			nvo.setPwd(pwd);
			nvo.setName(name);
			nvo.setNickName(nickName);
			
			int res = dao.memberSignin(nvo);
			
			//이후 메세지 객체에서 인/아웃 처리
			if(res==1) {
				msg = "회원가입 되었습니다.";
				url ="/hsLogin.hs";
			}
			else {
				msg = "회원가입 실패하였습니다.";
				url ="/hsGoSignInPage.hs";
				
			}
		}
		else {
			msg = "중복된 아이디가 있습니다.";
			url ="/hsGoSigninPage.hs";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);

	}

}
