package study2.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginOKCommand implements LoginInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String mid = request.getParameter("mid")==null? "" : request.getParameter("mid"); 
     String pwd = request.getParameter("pwd")==null? "" : request.getParameter("pwd");
     
     LoginDAO dao = new LoginDAO();
     
     LoginVO vo = dao.getLoginCheck(mid,pwd); //dao에서 로그인 처리
     
     PrintWriter out = response.getWriter();
     
     if(vo.getName() != null) {
         //회원인증 성공시 처리
         //회원 인증 후 처리 : 자주 사용하는 자료를 세션에 저장하기 (아이디, 이름);
         //DB의 최종접속일과 시스템 날짜를 비교하여 같으면 todaycount = vo.getcount()+1, 다르면 0으로 초기화. 
         //dao.setPointplus실행 
         //접속횟수 5 이상일 때에는 포인트 증가를 더 이상 시키지 않기.
         
         //방문 포인트 처리하기
//         dao.setPointPlus(mid);
         
         //날짜 불러와서 String 타입으로 가공/lastDate도 비교 위해서 가공.
         Date date = new  Date();
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         String nowDate= format.format(date);
         String lastDate =vo.getLastDate();
         lastDate = lastDate.substring(0,10);
         System.out.println(lastDate);
         System.out.println(nowDate);
         
         HttpSession session = request.getSession();
         
         //접속횟수 카운트와 포인트 상승처리.
         if(lastDate.equals(nowDate)) {
             System.out.println("on?");
             int todayCount = vo.getTodayCount();
             dao.setTodayCountUp(mid);
             if(todayCount<5) { //0부터 카운트 되니까 5보다 적게 설정
                 dao.setPointPlus(mid);
                 session.setAttribute("sPoint", vo.getPoint()+10); //DB에 값은 갱신했지만, 갱신하기 전에 값을 읽어오기 때문에 여기에서 +10을 해줬다.
             }
             else {
                 session.setAttribute("sPoint", vo.getPoint()); //이제 더 이상 값 추가 안되니까 else로 뺌.
             }
                 
         }
         else {
             dao.setTodayCountReset(mid);
             dao.setTodayCountUp(mid);
             dao.setPointPlus(mid);
         }
         dao.setLastDate(mid);
     
         //세션 처리
         session.setAttribute("sMid", mid);
         session.setAttribute("sName", vo.getName());
         session.setAttribute("sLastDate", vo.getLastDate());
         session.setAttribute("sTodayCount", vo.getTodayCount()+1);//DB에 값은 갱신했지만, 갱신하기 전에 값을 읽어오기 때문에 여기에서 +1을 해줬다.
         
         out.print("<script>");
   			out.print("alert('"+mid+"님 로그인 되었습니다.');");
   			out.print("location.href='"+request.getContextPath()+"/study/0428_database/memberMain.jsp'");
   			out.print("</script>");
     }
     else {
         //회원인증 실패시 처리
     	out.print("<script>");
 			out.print("alert('로그인 실패하였습니다. 아이디와 비밀번호를 확인해 주세요.');");
 			out.print("location.href='"+request.getContextPath()+"/study/0428_database/login.jsp'");
 			out.print("</script>");
     }
	}

}
