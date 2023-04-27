package study.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/database/DeleteOk")
public class DeleteOk extends HttpServlet{
 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 	{
	HttpSession session = request.getSession();
	String mid = (String)session.getAttribute("sMid");
	PrintWriter out = response.getWriter();

	LoginDAO dao = new LoginDAO();
	
	int res = dao.setDeleteOk(mid);
	 
	if(res==1) {
		out.print("<script>");
		out.print("alert('회원탈퇴가 정상적으로 처리되었습니다.');");
		out.print("location.href='"+request.getContextPath()+"/database/Logout';");
		out.print("</script>");
	}
	else {
		out.print("<script>");
		out.print("alert('회원 탈퇴가 정상적으로 처리되지 않았습니다.');");
		out.print("location.href='"+request.getContextPath()+"/study/0428_database/memberMain.jsp';");
		out.print("</script>");
	}
 }
}
