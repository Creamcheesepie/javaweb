package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberNickNameCheckCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String nickName = request.getParameter("nickName")==null?"" :request.getParameter("nickName");
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.getMemberNickNameCheck(nickName);
		
		HttpSession session = request.getSession();
		
		if(vo.getNickName() ==  null){
			request.setAttribute("res", 1);
			session.setAttribute("sNickNameOk", "ok");
		}
		else {
			request.setAttribute("res", 0);
			session.setAttribute("sNickNameOk", "no");
			
		}
		request.setAttribute("nickName", nickName);
	}

}
