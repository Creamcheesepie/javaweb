package guest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestListCommand implements GuestInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO dao = new GuestDAO();
		
		
		
		//일반 페이지 처리
		//1.현재 페이지의 번호를 구한다.
		int pag = request.getParameter("pag")==null? 1 : Integer.parseInt(request.getParameter("pag"));
		
		//2. 한 페이지의 분량을 정한다
		int pageSize =  request.getParameter("pageSize")==null? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		//3.총 레코드 건수를 구한다.
		int totalRecordCount = dao.getTotRecCnt();		
		
		//4.총 페이지 건수를 구한다.
		                                //여기서는 5
		int totalPage = (totalRecordCount%pageSize)==0?(totalRecordCount/pageSize) : (totalRecordCount/pageSize)+1;
		
		//5. 현재 페이지의 시작 인덱스 번호 구하기.
		int startIndexNo = (pag - 1) *pageSize;
		
		//6.현재 화면에 표시할 시작번호를 구한다.
		int curScrStartNo = totalRecordCount - startIndexNo;
		
		//블록페이지 처리 ...블로그이 시작번호을 0부터 처리
		// 1. 블록의 크기를 결정한다.(여기선 3으로 결정 후 처리)
		int blockSize = 3;
		
		//2. 현 페이지에 속한 블록 번호를 구한다.(예:1페이지는 0블록, 2페이지는 0블록... 4~6페이지는 1블록...)
		int curBlock = (pag-1)/blockSize;
		
		//3. 마지막 블록을 구한다.
		int lastBlock = (totalPage-1)/blockSize;
		
		
		
		//지정된 페이지의 자료를 요청한 한 페이지의 분량만큼 가져온다.
		
		ArrayList<GuestVO> vos = dao.getGuestList(startIndexNo, pageSize);
		
		request.setAttribute("vos", vos);
		request.setAttribute("pag", pag);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curScrStartNo", curScrStartNo); 
		//? 번호가 달라질 떄 씀(삭제했을때)
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("lastBlock", lastBlock);
	}
}
