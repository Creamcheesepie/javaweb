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
		String hostIp = request.getParameter("hostIp")==null?"":request.getParameter("hostIp");
		
		HsBoardVO vo = new HsBoardVO();
		
		vo.setArticle(article);
		vo.setDeletekey(deleteCode);
		vo.setMid(mid);
		vo.setTitle(title);
		vo.setHostIp(hostIp);
		
		HsBoardDAO dao = new HsBoardDAO();
		int res = dao.setBoardInputOk(vo);
		
		if(res==1){
			request.setAttribute("msg", "게시판에 글이 저장되었습니다.");
			request.setAttribute("url", request.getContextPath()+"/hsBoardList.pp");
			
		}
		else {
			request.setAttribute("msg", "게시판에 글이 저장되지 않았습니다. 다시 확인해주세요.");
			request.setAttribute("url", request.getContextPath()+"/hsBoardWrite.pp");
			
		}

	}

}
