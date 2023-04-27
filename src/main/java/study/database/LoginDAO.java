package study.database;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.websocket.Session;
 
public class LoginDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private LoginVO vo;
    private String sql;
    
    public LoginDAO() {
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
    public void setPointPlus(String mid) {
        try {
            sql="update login set point = point+10 where mid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql문 오류 :" + e.getMessage());
        }finally {
            pstmtClose();
        }
    }
    
    public void setTodayCountUp(String mid) {
        try {
            sql="update login set todayCount=todayCount+1 where mid=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql문 오류 :" + e.getMessage());
        }finally {
            pstmtClose();
        }
    }
    
    public void setTodayCountReset(String mid) {
        try {
            sql="update login set todayCount=0 where mid=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql문 오류 :" + e.getMessage());
        }finally {
            pstmtClose();
        }
    }
    
    public void setLastDate(String mid) {
        try {
            sql="update login set lastDate=now() where mid=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql문 오류 :" + e.getMessage());
        }finally {
            pstmtClose();
        }
    }

		public LoginVO getMidCheck(String mid) {
			LoginVO vo = new LoginVO();
			
			try {
				sql="select*from login where mid=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					vo.setIdx(rs.getInt("idx"));
					vo.setMid(rs.getString("mid"));
					vo.setPwd(rs.getString("pwd"));
					vo.setName(rs.getString("name"));
					vo.setPoint(rs.getInt("point"));
					vo.setLastDate(rs.getString("lastDate"));
					vo.setTodayCount(rs.getInt("todayCount"));
				};
			} catch (SQLException e) {
        System.out.println("sql문 오류 :" + e.getMessage());
	    } finally {
	        rsClose();
	    }
			return vo;
		}

		public void setJoinOk(LoginVO vo) {
			try {
				sql="insert into login values(default,?,?,?,default,default,default)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getPwd());
				pstmt.setString(3, vo.getName());
				pstmt.executeUpdate();
			} catch (SQLException e) {
        System.out.println("sql문 오류 :" + e.getMessage());
    }finally {
        pstmtClose();
    }
	}
		
		
		//전체 회원 조회~~
		public ArrayList<LoginVO> getLoginList() {
			 
			/*
			 * Date date = new Date(); SimpleDateFormat format = new
			 * SimpleDateFormat("yyyy-MM-dd"); String nowDate= format.format(date);
			 */
			
			ArrayList<LoginVO> vos = new ArrayList<>();
			
			try {
				sql = "select * from login order by idx desc";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					vo = new LoginVO();
					vo.setIdx(rs.getInt("idx"));
					vo.setMid(rs.getString("mid"));
					vo.setName(rs.getString("name"));
					vo.setPoint(rs.getInt("point"));
					vo.setLastDate(rs.getString("lastDate"));
					vo.setTodayCount(rs.getInt("todayCount"));
					//날짜비교
					vo.setTodayCount(compareDate(vo.getLastDate(),vo.getTodayCount()));
					
					/*
					 * String lastDate = rs.getString("lastDate"); lastDate =
					 * lastDate.substring(0,10); if(lastDate.equals(nowDate)) {
					 * vo.setTodayCount(rs.getInt("todayCount")); } else { vo.setTodayCount(0); }
					 */
					
					vos.add(vo);
				}
				
			} catch (SQLException e) {
        System.out.println("sql문 오류 :" + e.getMessage());
	    } finally {
	      rsClose();
	    }
			 
			return vos;
		}


		//날짜 비교처리
		private int compareDate(String lastDate, int todayCount) {
			Date date = new  Date();
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      String nowDate= format.format(date);
      lastDate = lastDate.substring(0,10);
      if(!lastDate.equals(nowDate))todayCount=0;
      
			return todayCount;
		}
		//개인정보 수정하기
		public int setUpdateOk(LoginVO vo) {
			int res=0;
			
			try {
				sql ="update login set pwd=? , name=? where mid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getPwd());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getMid());
				pstmt.executeUpdate();
				res=1;
			} catch (SQLException e) {
        System.out.println("sql문 오류 :" + e.getMessage());
    }finally {
        pstmtClose();
    }
			return res;
		}

		public int setDeleteOk(String mid) {
			int res=0;
			try {
				sql= "delete from login where mid=?";
				pstmt =conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				pstmt.executeUpdate();
				res=1;
			} catch (SQLException e) {
        System.out.println("sql문 오류 :" + e.getMessage());
			}finally {
        pstmtClose();
			}
			
			return res;
		}

		
}