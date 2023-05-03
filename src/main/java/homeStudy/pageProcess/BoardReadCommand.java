package homeStudy.pageProcess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReadCommand implements HsBoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx"));
		
		HsBoardVO vo = new HsBoardVO();
		HsBoardDAO dao = new HsBoardDAO();
		
		vo = dao.getBoardArticle(idx);
		
		request.setAttribute("mid", vo.getMid());
		request.setAttribute("title", vo.getTitle());
		request.setAttribute("article", vo.getArticle());
	}

}
