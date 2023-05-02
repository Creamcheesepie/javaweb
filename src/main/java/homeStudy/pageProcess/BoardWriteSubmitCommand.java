package homeStudy.pageProcess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteSubmitCommand implements HsBoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		String title = request.getParameter("title")==null?"":request.getParameter("title");
		int deleteCode = request.getParameter("deleteCode")==null?0000:Integer.parseInt(request.getParameter("deleteCode"));
		String article = request.getParameter("article")==null?"":request.getParameter("article");
		
		HsBoardVO vo = new HsBoardVO();
		
		vo.setArticle(article);
		vo.setDeletekey(deleteCode);
		vo.setMid(mid);
		vo.setTitle(title);
		
		HsBoardDAO dao = new HsBoardDAO();
		int res = dao.setBoardInputOk(vo);
		

	}

}
