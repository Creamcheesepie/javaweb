package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import guest.GuestDAO;
import guest.GuestVO;

public class MemberMainCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mid = (String) session.getAttribute("sMid");
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.getMemberMidCheck(mid);
		
		//레벨을 등급 이름으로 처리
		String strLevel = "";
		if(vo.getLevel()==0)strLevel="관리자";
		else if(vo.getLevel()==1)strLevel="준회원";
		else if(vo.getLevel()==2)strLevel="정회원";
		else if(vo.getLevel()==3)strLevel="우수회원";
		else if(vo.getLevel()==4)strLevel="운영자";
		//아이디, 닉네임, 이름 세가지 중 하나라도 방명록에 글을 쓴 적이 있다면 그걸 전부 세어서 방명록 글 쑨 횟수를 표시하고,
		//이것에 하이퍼링크를 걸어서 클릭시 자신이 쓴 글이 보이도록 하기.
		GuestDAO gdao = new GuestDAO();
		
		
		
		//일반 페이지 처리
		//1.현재 페이지의 번호를 구한다.
		int pag = request.getParameter("pag")==null? 1 : Integer.parseInt(request.getParameter("pag"));
		int pageSize =  request.getParameter("pageSize")==null? 5 : Integer.parseInt(request.getParameter("pageSize"));
		int totalRecordCount = gdao.getTotRecForEachMemberCnt(mid);		
		int totalPage = (totalRecordCount%pageSize)==0?(totalRecordCount/pageSize) : (totalRecordCount/pageSize)+1;
		int startIndexNo = (pag - 1) *pageSize;
		int curScrStartNo = totalRecordCount - startIndexNo;
		int blockSize = 3;
		int curBlock = (pag-1)/blockSize;
		int lastBlock = (totalPage-1)/blockSize;
		
		
		String name= vo.getName();
		//지정된 페이지의 자료를 요청한 한 페이지의 분량만큼 가져온다.
		
		ArrayList<GuestVO> vos = gdao.getMyGuestList(name,startIndexNo, pageSize);
		
		request.setAttribute("vos", vos);
		request.setAttribute("pag", pag);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curScrStartNo", curScrStartNo); 
		//? 번호가 달라질 떄 씀(삭제했을때)
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("lastBlock", lastBlock);
		
		
		request.setAttribute("point", vo.getPoint());
		request.setAttribute("todayCnt", vo.getTodayCnt());
		request.setAttribute("visitCnt", vo.getVisitCnt());
		request.setAttribute("level", strLevel);
		request.setAttribute("photo", vo.getPhoto());
	}

}
