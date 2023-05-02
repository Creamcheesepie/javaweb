package study2.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutOKCommand implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("sMid");//객체로 넘어오기 때문에 String으로 강제 형변환을 해줌.
		session.invalidate();//세션 끊기
		
		String msg="",url="";
		
		msg = mid +"님 로그아웃되었습니다.";
		url=request.getContextPath()+"/Login.re";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", request.getContextPath()+url);
		

	}

}
