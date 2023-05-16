package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberInfoUpdateCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mid = (String) session.getAttribute("sMid");
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.getMemberMidCheck(mid);
		
		// jsp form에 출력을 위한 분리작업처리
		//이메일 분리
		String[] email = vo.getEmail().split("@");
		request.setAttribute("email1", email[0]);
		request.setAttribute("email2", email[1]);
		
		//전화번호 분리
		String[] tel = vo.getTell().split("-");
		request.setAttribute("tel1", tel[0]);
		if(tel[1].equals(" ")) tel[1]="";
		if(tel[2].equals(" ")) tel[2]="";
		request.setAttribute("tel2", tel[1]);
		request.setAttribute("tel3", tel[2]);
		
		//주소 분리 ("/")
		String[] address = vo.getAddress().split("/");
		
		if(address[0].equals(" ")) address[0]="";
		if(address[1].equals(" ")) address[1]="";
		if(address[2].equals(" ")) address[2]="";
		if(address[3].equals(" ")) address[3]="";
		request.setAttribute("postcode", address[0]);
		request.setAttribute("roadAddress", address[1]);
		request.setAttribute("detailAddress", address[2]);
		request.setAttribute("extraAddress", address[3]);
		
		//생일 년-월-일
		request.setAttribute("birthday", vo.getBirthday().substring(0, 10));
		
		//취미는 통째로 넘기고 jstl로 처리
		request.setAttribute("hobby", vo.getHobby());
		
		request.setAttribute("vo",vo);
		
		

	}

}
