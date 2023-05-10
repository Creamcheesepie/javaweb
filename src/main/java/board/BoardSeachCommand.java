package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardSeachCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String search = request.getParameter("search")==null?"":request.getParameter("search");
		String searchString = request.getParameter("searchString")==null?"":request.getParameter("searchString");
		int nowPage = request.getParameter("nowPage")==null?1:Integer.parseInt(request.getParameter("nowPage"));
		int pageSize = request.getParameter("pageSize")==null?5:Integer.parseInt(request.getParameter("pageSize"));
		
		BoardDAO dao = new BoardDAO();
		
		
		ArrayList<BoardVO> vos = dao.getBoardContentSearch(search,searchString);
		
		String searchTitle = "";
		if(search.equals("title")) searchTitle = "글제목";
		else if(search.equals("nickName")) searchTitle = "작성자 닉네임";
		else if(search.equals("content")) searchTitle = "본문";
		
		
		
		request.setAttribute("vos", vos);
		request.setAttribute("search", search);
		request.setAttribute("searchTitle", searchTitle);
		request.setAttribute("searchString", searchString);
		request.setAttribute("searchCnt", vos.size());
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
	}

}
