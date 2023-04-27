package study.database;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class LoginDAOOneupdate {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private LoginVO vo;
    private String sql;
    
    public LoginDAOOneupdate() {
        String url = "jdbc:mysql://localhost:3306/javaweb";
        String user = "root";
        String password = "1234";
                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 검색 실패");
        } catch (SQLException e) {
            System.out.println("데이터 베이스 연동 실패");
        }
    }
    
    // 사용한 객체를 반남(해체)
    public void pstmtClose() {
        if(pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {}
        }
    }
    
    public void rsClose() {
     if(rs != null) {
         try {
            rs.close();
            pstmtClose();
        } catch (SQLException e) {}
     }
    }
 
    
    //로그인 체크
    public LoginVO getLoginCheck(String mid, String pwd) {
        vo = new LoginVO();
        try {
            sql = "select*from login where mid=? and pwd=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mid); //sql 문의 첫번째 ?에 mid 변수의 값 대입 
            pstmt.setString(2, pwd); //sql 문의 두번째 ?에 pwd 변수의 값 대입
            rs = pstmt.executeQuery(); //pstmt 문에 내용 전달하고 그 가져온 결과값을 rs에 저장.
            if(rs.next()){
                vo.setIdx(rs.getInt("idx"));
                vo.setMid(rs.getString("mid"));
                vo.setPwd(rs.getString("pwd"));
                vo.setName(rs.getString("name"));
                vo.setPoint(rs.getInt("point"));
                vo.setLastDate(rs.getString("lastDate"));
                vo.setTodayCount(rs.getInt("todayCount"));
            }
        } catch (SQLException e) {
            System.out.println("sql문 오류 :" + e.getMessage());
        } finally {
            rsClose();
        }
        return vo;
    }
 
    //방문포인트 증가시키기, 최종접속일 처리도 함께하기,방문카운트도 함꼐한다,
    public void setPointPlus(int point, int todayCount, String mid) {
  		try {
  			sql="update login set point = ?, lastDate=now(), todayCount=? where mid=?";
  			pstmt = conn.prepareStatement(sql);
  			pstmt.setInt(1, point);
  			pstmt.setInt(2, todayCount);
  			pstmt.setString(3, mid);
  			pstmt.executeUpdate();
  		} catch (SQLException e) {
  			System.out.println("sql문 오류 :" + e.getMessage());
  		}finally {
  			pstmtClose();
  		}
  	}
    
}