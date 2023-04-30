package study.s0429;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/s0429/SigninCheck")
public class SigninCheck extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"" :request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null?"" :request.getParameter("pwd");
		String name = request.getParameter("name")==null?"" :request.getParameter("name");
		String nickName = request.getParameter("nickName")==null?"" :request.getParameter("nickName");
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setNickName(nickName);
		
		int res = dao.memberSignin(vo);
		
		if(res==1) {
			out.print("<script>");
			out.print("alert('"+mid+"님 축하드립니다! 회원가입에 성공하셨습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0429_study/main.jsp'");
			out.print("</script>");
		}
		else {
			out.print("<script>");
			out.print("alert('"+mid+"님 죄송합니다. 오류가 발생하여 재시도 해주시기 바랍니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0429_study/signIn.jsp'");
			out.print("</script>");
			
		}
		
	}
}
