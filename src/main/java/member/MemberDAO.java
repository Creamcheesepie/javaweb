package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.GetConn;

public class MemberDAO {
	 GetConn	getConn = GetConn.getInstance();
		private Connection conn = getConn.getConn();
		private PreparedStatement pstmt =null;
		private ResultSet rs = null;
		
		private String sql="";
		
		MemberVO vo = null;
		
		//아이디 체크 후 자료가 있으면 vo에 개인 정보를 모두 담는다.
		public MemberVO getMemberMidCheck(String mid) {
			vo = new MemberVO();
			try {
				sql = "select * from member where mid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo.setIdx(rs.getInt("idx"));
					
					vo.setMid(rs.getString("mid"));
					vo.setPwd(rs.getString("pwd"));
					vo.setNickName(rs.getString("nickName"));
					vo.setName(rs.getString("name"));
					vo.setGender(rs.getString("gender"));
					
					vo.setBirthday(rs.getString("birthday"));
					vo.setTell(rs.getString("tell"));
					vo.setAddress(rs.getString("address") );
					vo.setEmail(rs.getString("email"));
					vo.setHomePage(rs.getString("homePage"));
					
					vo.setJob(rs.getString("job"));
					vo.setHobby(rs.getString("hobby"));
					vo.setPhoto(rs.getString("photo"));
					vo.setContent(rs.getString("content"));
					vo.setUserInfoSw(rs.getString("userInfoSw"));
					
					vo.setUserDel(rs.getString("userDel"));
					vo.setPoint(rs.getInt("point"));
					vo.setLevel(rs.getInt("level"));
					vo.setVisitCnt(rs.getString("visitcnt"));
					vo.setSingInDate(rs.getString("signinDate"));
					
					vo.setLastDate(rs.getString("lastDate"));
					vo.setTodayCnt(rs.getInt("todayCnt"));
					vo.setUid(rs.getString("salt"));
					
				}
				
				
			} catch (SQLException e) {
				System.out.println("sql오류 :" + e.getMessage());
			} finally {
				getConn.rsClose();
			}
		
			
			return vo;
		}
		// 닉네임 검사
		public MemberVO getMemberNickNameCheck(String nickName) {
			vo = new MemberVO();
			try {
				sql = "select * from member where nickName = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nickName);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo.setIdx(rs.getInt("idx"));
					
					vo.setMid(rs.getString("mid"));
					vo.setPwd(rs.getString("pwd"));
					vo.setNickName(rs.getString("nickName"));
					vo.setName(rs.getString("name"));
					vo.setGender(rs.getString("gender"));
					
					vo.setBirthday(rs.getString("birthday"));
					vo.setTell(rs.getString("tell"));
					vo.setAddress(rs.getString("address") );
					vo.setEmail(rs.getString("email"));
					vo.setHomePage(rs.getString("homePage"));
					
					vo.setJob(rs.getString("job"));
					vo.setHobby(rs.getString("hobby"));
					vo.setPhoto(rs.getString("photo"));
					vo.setContent(rs.getString("content"));
					vo.setUserInfoSw(rs.getString("userInfoSw"));
					
					vo.setUserDel(rs.getString("userDel"));
					vo.setPoint(rs.getInt("point"));
					vo.setLevel(rs.getInt("level"));
					vo.setVisitCnt(rs.getString("visitcnt"));
					vo.setSingInDate(rs.getString("signinDate"));
					
					vo.setLastDate(rs.getString("lastDate"));
					vo.setTodayCnt(rs.getInt("todayCnt"));
					vo.setUid(rs.getString("salt"));
					
				}
				
				
			} catch (SQLException e) {
				System.out.println("sql오류 :" + e.getMessage());
			} finally {
				getConn.rsClose();
			}
			
			
			return vo;
		}
		//default 값으로 저장되는 정보를 제외하고 정보를 전부 DB에 입력하는 메소드
	public int setMemberInfoTotal(MemberVO vo) {
		int res=0;
		try {
			sql = "insert into member values (default,"
					+ "?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "default,default,default,default,default,default,default,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNickName());
			pstmt.setString(4, vo.getName());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getBirthday());
			pstmt.setString(7, vo.getTell());
			pstmt.setString(8, vo.getAddress());
			pstmt.setString(9, vo.getEmail());
			pstmt.setString(10, vo.getHomePage());
			pstmt.setString(11, vo.getJob());
			pstmt.setString(12, vo.getHobby());
			pstmt.setString(13, vo.getPhoto());
			pstmt.setString(14, vo.getContent());
			pstmt.setString(15, vo.getUserInfoSw());
			pstmt.setString(16, vo.getUid());
			pstmt.executeUpdate();
			res=1;
		}catch (SQLException e) {
			System.out.println("정보 입력 sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		return res;
	}
	
	//오늘 처음 방문시에 방문카운트를 0으로 초기화
	public void setTodayCntUpdate(String mid) {
	
		try {
			sql = "update member set todaCnt = 0 where mid = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("정보 입력 sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}	
	}
	public void setMemberTotalUpndate(String mid, int nowTodayPoint) {
		try {
			sql = "update member set visitCnt=visitCnt+1,todayCnt=todayCnt+1,point=?,lastDate=now() where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nowTodayPoint);
			pstmt.setString(2, mid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("정보 입력 sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}	
		
	}
	public MemberVO getMembeMidfind(String email) {
		vo = new MemberVO();
		try {
			sql = "select * from member where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			rs.next();
			
			vo.setMid(rs.getString("mid"));
			
		} catch (SQLException e) {
			System.out.println("sql오류 :" + e.getMessage());
		} finally {
			getConn.rsClose();
		}

		return vo;
	}
	
	
	public MemberVO getMemberMidEmailCheck(String mid, String email) {
		vo = new MemberVO();
		try {
			sql = "select * from member where mid=? and email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			rs.next();
			
			vo.setIdx(rs.getInt("idx"));
			vo.setMid(rs.getString("mid"));
			vo.setEmail(rs.getString("email"));
			
		} catch (SQLException e) {
			System.out.println("sql오류 :" + e.getMessage());
		} finally {
			getConn.rsClose();
		}

		return vo;
		
	}
	
	public int MemberPwdReset(MemberVO vo) {
		int res = 0;
		try {
			sql = "update member set pwd=? , salt=? where idx=? and mid=? and email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getUid());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setString(4, vo.getMid());
			pstmt.setString(5, vo.getEmail());
			pstmt.executeUpdate();
			res=1;
		} catch (SQLException e) {
			System.out.println("정보 입력 sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		return res;
	}
	
	//방문포인투룰

}
