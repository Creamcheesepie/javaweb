package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberDeleteAsCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mid = (String) session.getAttribute("sMid");
		
		MemberDAO dao = new MemberDAO();
		
		dao.setDeleteOk(mid);
		
		session.invalidate();
		
		request.setAttribute("msg", "잘가시고, 1달 동안 같은 아이디로 못가입하니까 처신 잘 하그라이?");
		request.setAttribute("url", request.getContextPath()+"/");
	}

}
