package member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.SecurityUtil;

public class MemberLoginOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String mid = request.getParameter("mid")==null?"":request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null?"":request.getParameter("pwd");
		String idSave = request.getParameter("idSave")==null?"":request.getParameter("idSave");

		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.getMemberMidCheck(mid);
		
		
		if(vo.getUid() == null || vo.getUserDel().equals("OK")) {
			request.setAttribute("msg", "회원정보가 없습니다. \\n 다시 입력해 주세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
			return;
		}
		String uid=vo.getUid();
		pwd = uid+pwd;
		SecurityUtil security = new SecurityUtil();
		
		pwd = security.encryptSHA256(pwd);
		
		if(!pwd.equals(vo.getPwd())) {
			request.setAttribute("msg", "비밀번호가 틀립니다. \\n 다시 확인해 주세요.");
			request.setAttribute("url", request.getContextPath()+"/MemberLogin.mem");
		}
		else {
			// 로그인 성공시에 처리할내용들.(1. 주요 필드 셋션에 저장, 2오늘 방뭄횟수 처리, 3.총 방문수와 방문포인트 처리 4.쿠키에 아이디 저장 유무 5.등급업)
			//1.
			HttpSession session =  request.getSession();
			
			session.setAttribute("sMid", mid);
			session.setAttribute("sIdx", vo.getIdx());
			session.setAttribute("sNickName", vo.getNickName());
			session.setAttribute("sLevel", vo.getLevel());
			
			//로그인 시 등급업 조건 충족하면 준회원에서 정회원으로 업 알고리즘
			String name = vo.getName();
			System.out.println(name);
			int res= dao.getMemberGuestCnt(mid,name);
			int visitCnt = vo.getVisitCnt();
			
			System.out.println(res);
			System.out.println(visitCnt);
			if(res>4 && visitCnt>10) {
				
				dao.setMemberLevel(2,mid);
				session.setAttribute("sLevel",2);
			}
			
			
			//2.
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strNow = sdf.format(now);
			
			//오늘 처음 방문시에는 오늘 방문 카운트를 0으로 설정한다.
			if(!vo.getLastDate().substring(0,10).equals(strNow)) {
				dao.setTodayCntUpdate(mid);
				vo.setTodayCnt(0);
			}
			
			//방문포인트를최대 50점까지 줄 수 있도록 처리
			int nowTodayPoint = 0;
			if(vo.getTodayCnt()>=5) {
				nowTodayPoint = vo.getPoint();
			}
			else {
				nowTodayPoint = vo.getPoint() + 10;
			}
			dao.setMemberTotalUpndate(mid,nowTodayPoint);
			
			//4.
			
			Cookie cMid = new Cookie("cMid",mid);
			if(idSave.equals("on")) {
				cMid.setMaxAge(60*60*24*7);
			}
			else {
				cMid.setMaxAge(0);
			}
			
			
			
			
			
			resonse.addCookie(cMid);
			request.setAttribute("msg", vo.getNickName() + "님 환영합니다.");
			request.setAttribute("url", request.getContextPath()+"/MemberMain.mem");
		}

	}

}
