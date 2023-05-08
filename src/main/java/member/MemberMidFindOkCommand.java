package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberMidFindOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String email = request.getParameter("email")==null?"":request.getParameter("email");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo = dao.getMembeMidfind(email);
		
		if(vo.getMid()!=null) {
			String mid = vo.getMid();
			request.setAttribute("msg", "가입하신 아이디는 >>"+mid+"<<입니다. ");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
		}
		else{
			request.setAttribute("msg", "이메일로 아이디를 찾을 수 없습니다. 다시한번 이메일을 확인해 주세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
			
		}
	}

}
