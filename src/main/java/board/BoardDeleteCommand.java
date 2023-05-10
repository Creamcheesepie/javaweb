package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardDeleteCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0: Integer.parseInt(request.getParameter("idx"));
		int nowPage = request.getParameter("nowPage")==null?0: Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = request.getParameter("pageSize")==null?0: Integer.parseInt(request.getParameter("pageSize"));
		String nickName = request.getParameter("nickName")==null?"":request.getParameter("nickName");
		
		HttpSession session = request.getSession();
		String sNickName = (String) session.getAttribute("sNickName");
		int sLevel = (int) session.getAttribute("sLevel");
		
		BoardDAO dao = new BoardDAO();
		System.out.println(sNickName);
		System.out.println(nickName);
		/*
		 	피피맨
			ppman1234
		 */
		
		
		int res=0;
		if(nickName.equals(sNickName) || sLevel==0) {
			res = dao.setBoardDelete(idx);
			if(res==1) {
				request.setAttribute("msg", "게시글이 삭제되었습니다.");
				request.setAttribute("url", request.getContextPath()+"/BoardList.bo?nowPage="+nowPage+"&pageSize="+pageSize);
			}
			else{
				request.setAttribute("msg", "게시글이 삭제되지 않았습니다.");
				request.setAttribute("url", request.getContextPath()+"/BoardContent.bo?idx="+idx+"&nowPage="+nowPage+"&pageSize="+pageSize);
			}			
		}
		else {
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("url", request.getContextPath()+"/");
			
		}
		

	}

}
