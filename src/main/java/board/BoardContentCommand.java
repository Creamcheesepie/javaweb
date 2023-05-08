package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardContentCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0: Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = new BoardDAO();
		//게시글 조회수 새로고침으로 연속 올리기 금지
		//글 조회수 하나 증가
		dao.setReadnumUpdate(idx);
		
		BoardVO vo = dao.getBoardContent(idx);
	
		request.setAttribute("vo", vo);
	}

}
