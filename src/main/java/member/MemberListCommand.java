package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		
		//페이징 처리!(숙제)
		
		
		
		ArrayList<MemberVO> vos = new ArrayList<>();
		
		vos = dao.getMemberList();
		
		request.setAttribute("vos", vos);
	}

}
