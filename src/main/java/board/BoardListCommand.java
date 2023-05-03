package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		//리스트에서 시간 초 단위까지 나오는거 substring으로 수정
		//로그인/아웃 sha 써보기
		//페이징 처리
		int nowPage = request.getParameter("nowPage") ==null?1: Integer.parseInt(request.getParameter("nowPage"));
		
		int pageSize =  request.getParameter("pageSize")==null? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		int totalRecordCount = dao.getTotRecCnt();
		
		int totalPage = (totalRecordCount%pageSize)==0?(totalRecordCount/pageSize) : (totalRecordCount/pageSize)+1;
		
		int startIndexNo = (nowPage - 1) *pageSize;
		
		int curScrStartNo = totalRecordCount - startIndexNo;
		//블록페이지 처리
		int blockSize = 3;
		
		int curBlock = (nowPage-1)/blockSize;
		
		int lastBlock = (totalPage-1)/blockSize;
		
		
		ArrayList<BoardVO> vos = dao.getBoardList(startIndexNo, pageSize);
		
		
		request.setAttribute("vos", vos);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curScrStartNo", curScrStartNo); 
		//? 번호가 달라질 떄 씀(삭제했을때)
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("lastBlock", lastBlock);
	}

}
