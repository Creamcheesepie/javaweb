package study.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/database/joinOk")
public class joinOk extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid= request.getParameter("mid")==null? "":request.getParameter("mid");
		String pwd= request.getParameter("pwd")==null? "":request.getParameter("pwd");
		String name= request.getParameter("name")==null? "":request.getParameter("name");
		
		LoginVO vo =new LoginVO();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		
		LoginDAO dao = new LoginDAO();
		//아이디 검색처리
		LoginVO vo2 = dao.getMidCheck(mid);
		
		PrintWriter out = response.getWriter();
		
		if(vo2.getMid()!=null) {
			//아이디가 중복되었다.
			out.print("<script>");
			out.print("alert('아이디가 중복되었습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/join.jsp'");
			out.print("</script>");
		}
		else {
			//아이디가 중복되어있지 않다.
			out.print("<script>");
			out.print("alert('회원가입되었습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/login.jsp'");
			out.print("</script>");
			dao.setJoinOk(vo);
		}
	}
}
