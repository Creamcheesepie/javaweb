package member;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.SecurityUtil;

public class MemberJoinOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		//회원 사진이 업로드 되었는지 여부?
		String photo = "noimage.jpg";
		
		String mid =request.getParameter("mid")==null?"":request.getParameter("mid");
		String pwd =request.getParameter("pwd")==null?"":request.getParameter("pwd");
		String nickName =request.getParameter("nickName")==null?"":request.getParameter("nickName");
		String name =request.getParameter("name")==null?"":request.getParameter("name");
		String gender =request.getParameter("gender")==null?"":request.getParameter("gender");
		
		String birthday =request.getParameter("birthday")==null?"":request.getParameter("birthday");
		String tel =request.getParameter("tel")==null?"":request.getParameter("tel");
		String address =request.getParameter("address")==null?"":request.getParameter("address");
		String email =request.getParameter("email")==null?"":request.getParameter("email");
		String homePage =request.getParameter("homePage")==null?"":request.getParameter("homePage");
		
		String job =request.getParameter("job")==null?"":request.getParameter("job");
//		String photo =request.getParameter("photo")==null?"":request.getParameter("photo");
		String content =request.getParameter("content")==null?"":request.getParameter("content");
		String userInfoSw =request.getParameter("userInfoSw")==null?"":request.getParameter("userInfoSw");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		System.out.println(address);
		System.out.println(content);
		System.out.println(userInfoSw);
		
		
		if(hobbys.length != 0) {
			for(String strHobby : hobbys) {
				hobby += strHobby + "/";
			}
		}
		hobby = hobby.substring(0, hobby.lastIndexOf("/"));
		
		SecurityUtil security = new SecurityUtil();
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		//백엔드 체크(데이터 베이스에 저장되는 자료들의 null값과 길이체크, 중복여부	
		
		//아이디 닉네임 중복체크
		vo = dao.getMemberMidCheck(mid);
		
		if(vo.getMid() != null) {
			request.setAttribute("msg", "이미 사용중인 아이디입니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberJoin.mem");
			return;
		}
		
		vo = dao.getMemberNickNameCheck(nickName);
		if(vo.getNickName() != null) {
			request.setAttribute("msg", "이미 사용중인 닉네임입니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberJoin.mem");
			return;
		}
		
		//비밀번호 암호화
		UUID uid = UUID.randomUUID();
		String strUid= uid.toString().substring(0,8);
		pwd = strUid+pwd;
		pwd = security.encryptSHA256(pwd);
		
		//모든 체크가 완료되었앋면 회원정보를 vo에 담아서 DB(DAO)에 넘겨준다.
		vo = new MemberVO();
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setNickName(nickName);
		vo.setName(name);
		vo.setGender(gender);
		
		vo.setBirthday(birthday);
		vo.setTell(tel);
		vo.setAddress(address);
		vo.setEmail(email);
		vo.setHomePage(homePage);
		
		vo.setJob(job);
		vo.setHobby(hobby);
		vo.setPhoto(photo);
		vo.setContent(content);
		vo.setUserInfoSw(userInfoSw);
		
		vo.setUid(strUid);
		
		int res = dao.setMemberInfoTotal(vo);
		
		
		if(res==1) {
			request.setAttribute("msg", "회원 가입에 성공하셨습니다. 환영합니다! 로그인하셔서 저희의 환상적인 서비스를 즐겨보세요! ");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
		}
		else {
			request.setAttribute("msg", "회원가입에 실패하였습니다. 다시 한 번 정보를 확인해 주세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberJoin.mem");
		}
		

	}

}
