package study.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/database/updateOk")
public class updateOk extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			out.print("<script>");
			out.print("alert('개인정보 수정이 정상적으로 처리되었습니다.');");
			out.print("location.href='"+request.getContextPath()+"/study/0428_database/memberMain.jsp'");
			out.print("</script>");
		}
		else {
			out.print("<script>");
			out.print("alert('개인정보 수정이 정상적으로 처리되지 않았습니다.');");
			out.print("location.href='"+request.getContextPath()+"/database/Update'");
			out.print("</script>");
		}
		
	}
}
