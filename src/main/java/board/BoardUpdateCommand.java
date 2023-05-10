package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0: Integer.parseInt(request.getParameter("idx"));
		int nowPage = request.getParameter("nowPage")==null?0: Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = request.getParameter("pageSize")==null?0: Integer.parseInt(request.getParameter("pageSize"));
		String nickName = request.getParameter("nickName")==null?"":request.getParameter("nickName");
		
		BoardDAO dao = new BoardDAO();
		
		BoardVO vo = dao.getBoardContent(idx);
		
		request.setAttribute("vo", vo);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("nickName", nickName);

	}

}
