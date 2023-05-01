package homeStudy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HsMyInfoChange implements HsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String loginMid = request.getParameter("mid")==null?"" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null?"" : request.getParameter("pwd");
		String name = request.getParameter("name")==null?"" : request.getParameter("name");
		String nickName = request.getParameter("nickName")==null?"" : request.getParameter("nickName");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberInfoChangeBeforeData(loginMid);
		
		if(pwd.equals("")) {
			pwd = vo.getPwd();
		}
		if(name.equals("")) {
			name = vo.getName();
		}
		if(nickName.equals("")) {
			nickName = vo.getNickName();
		}
		
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setNickName(nickName);
		vo.setMid(loginMid);
		
		int res = dao.memberInfoChange(vo);
		String msg="", url="";
		
		if(res==1) {
			msg = "정상적으로 수정 되었습니다.";
			url ="/hsMyInfo.hs";
		}
		else {
			//오류시 메세지 처리용
			msg = "오류가 발생하엿습니다.";
			url ="/hsMyInfo.hs";
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);
		

	}

}
