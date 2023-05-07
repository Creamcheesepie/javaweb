package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Security;

import conn.SecurityUtil;

public class MemberJoinOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String mid =request.getParameter("mid")==null?"":request.getParameter("mid");
		String pwd =request.getParameter("pwd")==null?"":request.getParameter("pwd");
		String nickName =request.getParameter("nickName")==null?"":request.getParameter("nickName");
		String name =request.getParameter("name")==null?"":request.getParameter("name");
		String gender =request.getParameter("gender")==null?"":request.getParameter("gender");
		System.out.println(gender);
		
		String birthday =request.getParameter("birthday")==null?"":request.getParameter("birthday");
		String tell =request.getParameter("tell")==null?"":request.getParameter("tell");
		String address =request.getParameter("address")==null?"":request.getParameter("address");
		String email =request.getParameter("email")==null?"":request.getParameter("email");
		String homePage =request.getParameter("homePage")==null?"":request.getParameter("homePage");
		
		String job =request.getParameter("job")==null?"":request.getParameter("job");
		String hobby =request.getParameter("hobby")==null?"":request.getParameter("hobby");
		String photo =request.getParameter("photo")==null?"":request.getParameter("photo");
		String content =request.getParameter("content")==null?"":request.getParameter("content");
		String userInfoSw =request.getParameter("userInfoSw")==null?"":request.getParameter("userInfoSw");
		
		SecurityUtil security = new SecurityUtil();
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		pwd = security.encryptSHA256(pwd);//비밀번호 암호화
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setNickName(nickName);
		vo.setName(name);
		vo.setGender(gender);
		
		vo.setBirthday(birthday);
		vo.setTell(tell);
		vo.setAddress(address);
		vo.setEmail(email);
		vo.setHomePage(homePage);
		
		vo.setJob(job);
		vo.setHobby(hobby);
		vo.setPhoto(photo);
		vo.setContent(content);
		vo.setUserInfoSw(userInfoSw);
		
		int res = dao.setMemberInfoTotal(vo);
		
		if(res==1) {
			
			request.setAttribute("msg", "회원 가입에 성공하셨습니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
		}
		else {
			request.setAttribute("msg", "회원가입에 실패하였습니다. 다시한번 정보를 확인해 주세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberJoin.mem");
		}
		

	}

}
