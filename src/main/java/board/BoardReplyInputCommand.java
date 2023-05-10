package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReplyInputCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int boardIdx = request.getParameter("boardIdx")==null?0:Integer.parseInt(request.getParameter("boardIdx"));
		String mid  = request.getParameter("mid")==null?"": request.getParameter("mid");
		String nickName  = request.getParameter("nickName")==null?"": request.getParameter("nickName");
		String content  = request.getParameter("content")==null?"": request.getParameter("content");
		String postIp  = request.getParameter("postIp")==null?"": request.getParameter("postIp");
		
		BoardReplyVO replyVo =new BoardReplyVO();
		
		replyVo.setBoardIdx(boardIdx);
		replyVo.setMid(mid);
		replyVo.setNickName(nickName);
		replyVo.setContent(content);
		replyVo.setPostIp(postIp);
		
		BoardDAO dao = new BoardDAO();
		
		String res = dao.setReplyInputOk(replyVo);
		
		resonse.getWriter().write(res);
		
		

	}

}
