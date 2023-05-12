package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class AdminMemberInforCommand implements Admin {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		int nowPage = request.getParameter("nowPage")==null?1 :Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = request.getParameter("pageSize")==null?1 :Integer.parseInt(request.getParameter("pageSize"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo = dao.getMemberMidCheck(mid);
		
		String strLevel = "";
		if(vo.getLevel()==0)strLevel="관리자";
		else if(vo.getLevel()==1)strLevel="준회원";
		else if(vo.getLevel()==2)strLevel="정회원";
		else if(vo.getLevel()==3)strLevel="우수회원";
		else if(vo.getLevel()==4)strLevel="운영자";

		
		request.setAttribute("vo", vo);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("strLevel",strLevel);		
	}

}
