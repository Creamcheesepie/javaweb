package study.database;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@SuppressWarnings("serial")
@WebServlet("/database/LoginOkOneUpdate")
public class LoginOkOneupdate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid")==null? "" : request.getParameter("mid"); 
        String pwd = request.getParameter("pwd")==null? "" : request.getParameter("pwd");
        
        LoginDAOOneupdate dao = new LoginDAOOneupdate();
        
        LoginVO vo = dao.getLoginCheck(mid,pwd); //dao에서 로그인 처리
        
        PrintWriter out = response.getWriter();
        
        if(vo.getName() != null) {
            //회원인증 성공시 처리
            //회원 인증 후 처리 : 자주 사용하는 자료를 세션에 저장하기 (아이디, 이름);
            //DB의 최종접속일과 시스템 날짜를 비교하여 같으면 todaycount = vo.getcount()+1, 다르면 0으로 초기화. 
            //dao.setPointplus실행 
            //접속횟수 5 이상일 때에는 포인트 증가를 더 이상 시키지 않기.
            
            //방문 포인트 처리하기
//            dao.setPointPlus(mid);
            
            //날짜 불러와서 String 타입으로 가공/lastDate도 비교 위해서 가공.
            Date date = new  Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String nowDate= format.format(date);
            String lastDate =vo.getLastDate();
            lastDate = lastDate.substring(0,10);
            
            int point = vo.getPoint();
            int todayCount =vo.getTodayCount();
            
            
            
            
            //접속횟수 카운트와 포인트 상승처리.
            if(lastDate.equals(nowDate)) {
                System.out.println("on?");
                todayCount++;
   
                if(todayCount<6) { //1부터 카운트 되니까 5보다 적게 설정
                    point+=10;
                }
            }
            else {
            	todayCount=1;
            	point +=10;
            }
        
            //세션 처리
            HttpSession session = request.getSession();
            session.setAttribute("sMid", mid);
            session.setAttribute("sName", vo.getName());
            session.setAttribute("sLastDate", vo.getLastDate());
            session.setAttribute("sTodayCount", todayCount);
            session.setAttribute("sPoint", point);
            
            dao.setPointPlus(point, todayCount, mid);
            
            out.print("<script>");
            out.print("alert(‎'"+mid+"님 환영합니다.');");
            out.print("location.href='"+request.getContextPath()+"/study/0428_database/memberMainOneupdate.jsp';");
            out.print("</script>");
        }
        else {
            //회원인증 실패시 처리
            out.print("<script>");
            out.print("alert(‎'로그인 실패.');");
            out.print("location.href='"+request.getContextPath()+"/study/0428_database/loginOneupdate.jsp';");
            out.print("</script>");
        }
    }
}