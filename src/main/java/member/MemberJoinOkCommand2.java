package member;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import conn.SecurityUtil;

public class MemberJoinOkCommand2 implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		//회원 사진이 업로드 되었는지 여부?
		String realPath = request.getServletContext().getRealPath("/images/member/");
		int maxSize = 1024*1024*10;
		String encoding = "UTF-8";
		
		MultipartRequest mPRequest = new MultipartRequest(request, realPath,maxSize,encoding,new DefaultFileRenamePolicy()); 
		
		
		
		String photo = mPRequest.getFilesystemName("photoFile")==null?"noimage.jpg":mPRequest.getFilesystemName("photoFile");
		System.out.println(photo);
		String mid =mPRequest.getParameter("mid")==null?"":mPRequest.getParameter("mid");
		String pwd =mPRequest.getParameter("pwd")==null?"":mPRequest.getParameter("pwd");
		String nickName =mPRequest.getParameter("nickName")==null?"":mPRequest.getParameter("nickName");
		String name =mPRequest.getParameter("name")==null?"":mPRequest.getParameter("name");
		String gender =mPRequest.getParameter("gender")==null?"":mPRequest.getParameter("gender");
		
		String birthday =mPRequest.getParameter("birthday")==null?"":mPRequest.getParameter("birthday");
		String tel =mPRequest.getParameter("tel")==null?"":mPRequest.getParameter("tel");
		String address =mPRequest.getParameter("address")==null?"":mPRequest.getParameter("address");
		String email =mPRequest.getParameter("email")==null?"":mPRequest.getParameter("email");
		String homePage =mPRequest.getParameter("homePage")==null?"":mPRequest.getParameter("homePage");
		
		String job =mPRequest.getParameter("job")==null?"":mPRequest.getParameter("job");
//		String photo =mPRequest.getParameter("photo")==null?"":mPRequest.getParameter("photo");
		String content =mPRequest.getParameter("content")==null?"":mPRequest.getParameter("content");
		String userInfoSw =mPRequest.getParameter("userInfoSw")==null?"":mPRequest.getParameter("userInfoSw");
		String[] hobbys = mPRequest.getParameterValues("hobby");
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
