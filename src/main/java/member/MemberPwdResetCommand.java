package member;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.SecurityUtil;

public class MemberPwdResetCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		String email = request.getParameter("email")==null?"":request.getParameter("email");
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx")) ;
		String pwd = request.getParameter("pwd")==null?"":request.getParameter("pwd");
		
		SecurityUtil security = new SecurityUtil();
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		UUID uid = UUID.randomUUID();
		String strUid= uid.toString().substring(0,8);
		pwd = strUid+pwd;
		System.out.println(pwd);
		pwd = security.encryptSHA256(pwd);
		
		vo.setIdx(idx);
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setUid(strUid);
		
		int res = dao.MemberPwdReset(vo);
		
		if(res==1) {
			request.setAttribute("msg", "비밀번호 재설정에 성공했습니다. 다시 로그인해주세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
		}
		else {
			request.setAttribute("msg", "비밀번호 재설정에 실패하였습니다. 다시 한번 확인해주세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
		}
		
	}

}
