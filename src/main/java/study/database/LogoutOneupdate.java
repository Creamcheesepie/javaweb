package study.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/database/LogoutOneupdate")
public class LogoutOneupdate extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("sMid");//객체로 넘어오기 때문에 String으로 강제 형변환을 해줌.
		session.invalidate();//세션 끊기
		
		out.print("<script>");
		out.print("alert('"+mid+"님 로그아웃 되었습니다.');");
		out.print("location.href='"+request.getContextPath()+"/study/0428_database/loginOneupdate.jsp';");
		out.print("</script>");

		
		
	}

}
