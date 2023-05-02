package study2.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import study.database.LoginDAO;
import study.database.LoginVO;

public class MemberUpdateOkCommand implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		String mid = (String)session.getAttribute("sMid");
		
		String pwd= request.getParameter("pwd")==null?"": request.getParameter("pwd");
		String name= request.getParameter("name")==null?"": request.getParameter("name");
		
		LoginVO vo = new LoginVO();
		PrintWriter out = response.getWriter();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		
		LoginDAO dao = new LoginDAO();
		
		int res = dao.setUpdateOk(vo);
		
		if(res==1) {
			session.setAttribute("sName", name);
			session.setAttribute("sPwd", pwd);
			request.setAttribute("msg", "개인정보 수정이 정상적으로 처리되었습니다." );
			request.setAttribute("url", request.getContextPath()+"/MemberMain.re");
		}
		else {
			request.setAttribute("msg", "개인정보 수정실패하였습니다." );
			request.setAttribute("url", request.getContextPath()+"/MemberMain.re");
			
		}
		

	}

}
