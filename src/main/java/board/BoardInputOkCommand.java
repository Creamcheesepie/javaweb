package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardInputOkCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String title = request.getParameter("title")==null?"":request.getParameter("title");
		String email = request.getParameter("email")==null?"":request.getParameter("email");
		String homePage = request.getParameter("homePage")==null?"":request.getParameter("homePage");
		String content = request.getParameter("content")==null?"":request.getParameter("content");
		String hostIp = request.getParameter("hostIp")==null?"":request.getParameter("hostIp");
		
		HttpSession session = request.getSession();
		String mid=session.getAttribute("sMid")==null?"":(String)session.getAttribute("sMid");
		String nickName=session.getAttribute("sNickName")==null?"":(String)session.getAttribute("sNickName");
		
		BoardVO vo = new BoardVO();
		vo.setNickName(nickName);
		vo.setEmail(email);
		vo.setHostIp(hostIp);
		vo.setHomePage(homePage);
		vo.setMid(mid);
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int res = dao.setBoardInput(vo);
		
		if(res==1){
			request.setAttribute("msg", "게시판에 글이 저장되었습니다.");
			request.setAttribute("url", request.getContextPath()+"/BoardList.bo");
		}
		else {
			request.setAttribute("msg", "게시판에 글이 저장되지않았습니다.");
			request.setAttribute("url", request.getContextPath()+"/BoardInput.bo");
		}
		
	}
}
