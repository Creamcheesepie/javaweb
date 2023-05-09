package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

public class BoardContentCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0: Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = new BoardDAO();
		
		//게시글 조회수 새로고침으로 연속 올리기 금지
		//글 조회수 하나 증가(조회수 반복 방지처리 세션사용 : "'board'+고유번호" 값을 객체배열(ArrayList)에 추가시킨다.)
		
		HttpSession session = request.getSession();
		
		ArrayList<String> contentIdx = (ArrayList<String>) session.getAttribute("sContentIdx");
		
		if(contentIdx == null) {
			contentIdx = new ArrayList<>();
		}
		
		String tempContentIdx = "board" + idx;
		
		session.setAttribute("sContentIdx", tempContentIdx);
		
		if(!contentIdx.contains(tempContentIdx)) {
			dao.setReadnumUpdate(idx);
			contentIdx.add(tempContentIdx);
		}
		
		session.setAttribute("sContentIdx", contentIdx);
		
		
		//현재 선택된 게시글(idx)의 전체 내용을 가져오기
		BoardVO vo = dao.getBoardContent(idx);
	
		request.setAttribute("vo", vo);
	}

}
