package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;

public class AdminMemberDeleteCommand implements Admin {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = Integer.parseInt( request.getParameter("idx"));
		
		MemberDAO dao = new MemberDAO();
		
		dao.setMemberDelete(idx);
	}

}
