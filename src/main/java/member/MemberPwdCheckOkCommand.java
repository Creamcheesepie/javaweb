package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.SecurityUtil;

public class MemberPwdCheckOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mid = (String) session.getAttribute("sMid");
		String pwd = request.getParameter("pwd")==null?"":request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.getMemberMidCheck(mid);
		
		SecurityUtil security = new SecurityUtil();
		pwd = security.encryptSHA256(vo.getUid()+pwd);
		
		if(!pwd.equals(vo.getPwd())) {
			request.setAttribute("msg", "입력하신 비밀번호가 틀립니다 비밀번호를 입력하세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberPwdCheckForm.mem");
		}
		else {
			request.setAttribute("msg", "입력하신 비밀번호가 맞습니다. 회원정보를 수정할 수 있습니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberInfoUpdate.mem");
		}
		

	}

}
