package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardGoodCheckCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0: Integer.parseInt(request.getParameter("idx"));
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("sMid");
		String sector = "board"; //지금 게시판 영역 지정
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getGoodCheck(sector, idx, mid); 
		
		
		if(vo.getMid()==null) {
			dao.setGoodUserUpdate(sector, idx, mid);
			dao.setGoodPlusUpdate(+1, idx);
		}
		else {
			dao.setGoodUserDelete(sector, idx, mid);
			dao.setGoodPlusUpdate(-1, idx);
		}
		
		
		//다시 페이지 불러오기
		vo = dao.getBoardContent(idx);
		
		request.setAttribute("vo", vo);
		
	}

}
