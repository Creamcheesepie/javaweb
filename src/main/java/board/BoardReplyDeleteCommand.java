package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReplyDeleteCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null?0:Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = new BoardDAO();
		
		int res =  dao.setReplyDelete(idx);
		
		//ajax로 넘겨주는 값은 String으로 보내주어야 하나?int시 값이 이상하게 넘어감.
		String strRes = res+"";
		System.out.println(res);
		resonse.getWriter().write(strRes);

	}

}
