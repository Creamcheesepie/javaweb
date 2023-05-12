package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class AdminMemberListCommand implements Admin {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//int level = (int) session.getAttribute("sLevel");
		
		
		MemberDAO dao = new MemberDAO();
		
		//페이징 처리!(숙제)
		int nowPage = request.getParameter("nowPage") ==null?1: Integer.parseInt(request.getParameter("nowPage"));
		System.out.println(request.getParameter("pageSize"));
		int pageSize =  request.getParameter("pageSize")==null?5: Integer.parseInt(request.getParameter("pageSize"));
		
		int totalRecordCount = dao.getTotRecCnt();
		
		int totalPage = (totalRecordCount%pageSize)==0?(totalRecordCount/pageSize) : (totalRecordCount/pageSize)+1;
		
		int startIndexNo = (nowPage - 1) *pageSize;
		
		int curScrStartNo = totalRecordCount - startIndexNo;
		//블록페이지 처리
		int blockSize = 3;
		
		int curBlock = (nowPage-1)/blockSize;
		
		int lastBlock = (totalPage-1)/blockSize;
		
		
		
		
		
		ArrayList<MemberVO> vos = new ArrayList<>();
		
		vos = dao.getMemberList(startIndexNo, pageSize);
		
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
