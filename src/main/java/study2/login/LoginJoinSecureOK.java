package study2.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.database.LoginDAO;
import study.database.LoginVO;

public class LoginJoinSecureOK implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid= request.getParameter("mid")==null? "":request.getParameter("mid");
		String pwd= request.getParameter("pwd")==null? "":request.getParameter("pwd");
		String name= request.getParameter("name")==null? "":request.getParameter("name");
		
		LoginVO vo =new LoginVO();
		
		
		
		int key = 0x1782ABCD;
		int encPwd;
		encPwd = Integer.parseInt(pwd)^key;
		pwd = String.valueOf(encPwd);
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		
		LoginDAO dao = new LoginDAO();
		//아이디 검색처리
		LoginVO vo2 = dao.getMidCheck(mid);

		String msg="", url="";
		if(vo2.getMid()!=null) {
			//아이디가 중복되었다.
			msg = "아이디가 중복되었습니다.";
			url=request.getContextPath()+"/JoinSecure.re";
		}
		else {
			//아이디가 중복되어있지 않다.
			dao.setJoinOk(vo);
			msg = "회원가입되었습니다.";
			url=request.getContextPath()+"/LoginSecure.re";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);
		
		
	}

}
