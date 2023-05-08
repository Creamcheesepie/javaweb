package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberIdCheckCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"" :request.getParameter("mid");
		
		MemberDAO dao = new MemberDAO();
		HttpSession session = request.getSession();
		MemberVO vo = dao.getMemberMidCheck(mid);
		
		if(vo.getMid() ==  null){
			request.setAttribute("res", 1);
			session.setAttribute("sMidOk", "ok");
		}
		else {
			request.setAttribute("res", 0);
			session.setAttribute("sMidOk", "no");
		}
		request.setAttribute("mid", mid);
	}

}
