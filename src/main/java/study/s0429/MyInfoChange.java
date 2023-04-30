package study.s0429;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s0429/MyInfoChange")
public class MyInfoChange extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginMid = request.getParameter("mid")==null?"" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null?"" : request.getParameter("pwd");
		String name = request.getParameter("name")==null?"" : request.getParameter("name");
		String nickName = request.getParameter("nickName")==null?"" : request.getParameter("nickName");
		
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberInfoChangeBeforeData(loginMid);
		
		if(pwd.equals("")) {
			pwd = vo.getPwd();
		}
		else if(name.equals("")) {
			name = vo.getName();
		}
		if(nickName.equals("")) {
			nickName = vo.getNickName();
		}
		
		vo.setPwd(pwd);
		vo.setName(nickName);
		vo.setNickName(nickName);
		vo.setMid(loginMid);
		
		int res = dao.memberInfoChange(vo);
		
		if(res==1) {
			out.print("<script>");
			out.print("alert('"+loginMid+"님 정보를 수정했습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0429_study/main.jsp'");
			out.print("</script>");
		}
		else {
			out.print("<script>");
			out.print("alert('"+loginMid+"님 죄송합니다. 오류가 발생하여 재시도 해주시기 바랍니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0429_study/signIn.jsp'");
			out.print("</script>");
			
		}
	}
}
