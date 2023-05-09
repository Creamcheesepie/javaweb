package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberPwdFindOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		String email = request.getParameter("email")==null?"":request.getParameter("email");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo = dao.getMemberMidEmailCheck(mid,email);
		
		
		
		if(vo.getMid()!=null) {
			request.setAttribute("idx", vo.getIdx());
			request.setAttribute("mid", vo.getMid());
			request.setAttribute("email", vo.getEmail());
			request.setAttribute("msg", "아이디와 이메일에 일치하는 계정이 있습니다.");
			request.setAttribute("findOk", "ok");
		}
		else {
			request.setAttribute("msg", "아이디와 이메일에 일치하는 계정이 없습니다. 다시 확인해 주세요.");
			request.setAttribute("findOk", "no");	
		}
	}

}
