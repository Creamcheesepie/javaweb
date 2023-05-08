package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class BoardGoodCheckCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
int idx = request.getParameter("idx")==null?0: Integer.parseInt(request.getParameter("idx"));

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		HttpSession session = request.getSession();
		String mIdx = String.valueOf(session.getAttribute("sIdx"));
		
		String strIdx = mIdx+"/";
		
		vo = dao.getMIdxinfo(idx);
		
		String goodMember = vo.getGoodMember()==null?"":vo.getGoodMember();
		
		String[] goodMemberArray = goodMember.split("/");
		
		for(int i = 0; i<goodMemberArray.length;i++) {
			if(!mIdx.equals(goodMemberArray[i])) {
				System.out.println("체크");
				dao.setGoodUpdate(idx,strIdx);
			}
		}
		
		//게시글 조회수 새로고침으로 연속 올리기 금지
		//글 좋아요 수 하나 증가
		
		
		
		
		vo = new BoardVO();
		
		vo = dao.getBoardContent(idx);
	
		request.setAttribute("vo", vo);

	}

}
