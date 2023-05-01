package homeStudy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HsLoginCheck implements HsInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		String mid = request.getParameter("mid")==null?"" : request.getParameter("mid"); 
		String pwd = request.getParameter("mid")==null?"" : request.getParameter("pwd"); 
		System.out.println();
		vo = dao.getLoginCheck(mid, pwd);
		String msg="", url="";
		
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate= format.format(date);
        
        if(vo!=null) {
			session.setAttribute("sLoginMid", mid);
			
			String lastLoginDate = vo.getLastLoginDate();
			lastLoginDate = lastLoginDate.substring(0,10);
			session.setAttribute("sTotalLoginCount", vo.getTotalLoginCount()+1);
			
			if(!lastLoginDate.equals(nowDate)) {
				int point = vo.getPoint();

				point+=10;
				dao.memberUpdate(mid, point);
			}
			
			
			msg = vo.getNickName()+"("+mid+")님 로그인되었습니다.";
			url ="/hsMain.hs";
		}
		else {
			msg = "로그인에 실패하였습니다. 아이디나 비밀번호를 확인해 주세요.";
			url=request.getContextPath()+"/hsLogin.hs";
			
		}
        request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);

	}

}
