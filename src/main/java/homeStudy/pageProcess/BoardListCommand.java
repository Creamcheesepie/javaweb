package homeStudy.pageProcess;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListCommand implements HsBoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HsBoardDAO dao = new HsBoardDAO();
		
		//현재 페이지 번호를 구한다.
		int nowPage = request.getParameter("nowPage") == null ? 1 : Integer.parseInt(request.getParameter("nowPage"));
		
		//페이지 분량 정하기 일단 여기엔 20개
		int pageSize = 20;
		
		//총 레코드 건수 구하기(DB에서 값 가져오기
		int trc = dao.getTotalRecordCount();
		
		//총 페이지 수 구하기
		//페이지 수는 표시할 항목의 총 개수/한 페이지에 표시될 개수 + 한페이지에 표시할 양을 가득 채우고 남은 나머지 데이터를 표시할 한 페이지로 구성된다.
		//따라서 총 개수%표시할 양 해서 나머지가 0이면 가득 채우고 남는 데이터가 없다는 뜻이므로 나눈 결과만 입력, 나머지가 존재하면 페이지를 한장 더해서 나머지 데이터를 표시할 공간을 마련한다.
		int totalPage = (trc%pageSize)==0?(trc/pageSize):(trc/pageSize)+1;
		
		//현재 페이지의 시작 인덱스 번호 구하기
		int startIndexNo = (nowPage-1)*pageSize;
		
		//현재 화면에 표시할 번호수 
		int curScrStartNo = trc - startIndexNo;
		
		//지정된 페이지의 자료를 요청한 한 페이지의 분량만큼 가져오기.
		ArrayList<HsBoardVO> vos = dao.getBoardList(startIndexNo, pageSize);
		
		request.setAttribute("vos", vos);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curScrStartNo", curScrStartNo);
		request.setAttribute("pageSize", pageSize);

	}

}
