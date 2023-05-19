package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.membership.StaticMembershipProvider.MemberMessage;

public class MemberMessageInputCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		String nickName= (String) session.getAttribute("sNickName");
		
		String chat = request.getParameter("chat")==null?"":request.getParameter("chat");
		chat = chat.replace("<", "&lt");
		chat = chat.replace(">", "&gt");
		
		MemberDAO dao = new MemberDAO();
		MemberChatVO vo =new MemberChatVO();
		
		vo.setNickName(nickName);
		vo.setChat(chat);
		
		dao.setMemberMessageInputOk(vo);
		
		
		
	}

}
