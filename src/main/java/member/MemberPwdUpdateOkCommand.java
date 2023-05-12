package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.SecurityUtil;

public class MemberPwdUpdateOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mid = (String) session.getAttribute("sMid");
		String oldPwd = request.getParameter("oldPwd")==null?"" :request.getParameter("oldPwd");
		String newPwd = request.getParameter("oldPwd")==null?"" :request.getParameter("newPwd");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo = dao.getMemberMidCheck(mid);
		
		String uid = vo.getUid();
		
		SecurityUtil security = new SecurityUtil();
		
		oldPwd = security.encryptSHA256(uid+oldPwd);
		newPwd = security.encryptSHA256(uid+newPwd);
		
		if(!oldPwd.equals(vo.getPwd())) {
			request.setAttribute("msg", "비밀번호를 확인하세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberPwdUpdate.mem");
			return;
		}
		else if(newPwd.equals(vo.getPwd())) {
			request.setAttribute("msg", "이전 비밀번호와 동일한 비밀번호로 바꾸실 수 없습니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberPwdUpdate.mem");
			return;
		}
		
		int res = dao.setMemberPwdUpdateOk(mid, newPwd);
		
		if(res ==1 ) {
			request.setAttribute("msg", "비밀번호 변경에 성공하였습니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
		}
		else {
			request.setAttribute("msg", "오류가 발생하였습니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberPwdUpdate.mem");
		}
		
	}

}
