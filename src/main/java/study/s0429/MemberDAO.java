package study.s0429;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	private MemberVO vo;
	private String sql;
	
	public MemberDAO() {
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
	
	
	//객체 반납용 메소드
	public void pstmtClose() {
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	public void rsClose() {
		if(rs!=null) {
			try {
				rs.close();
				pstmtClose();
			} catch (SQLException e) {}
		}
	}

	//본격 DAO 작성부
	
	//로그인데이터 요청
	public MemberVO getLoginCheck(String mid, String pwd) {
		vo = new MemberVO();
		try {
			sql="select * from memberStudy where mid=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setName(rs.getString("pwd"));
				vo.setNickName(rs.getString("nickName"));
				vo.setCreateDate(rs.getString("createDate"));
				vo.setLastLoginDate(rs.getString("lastLoginDate"));
				vo.setTotalLoginCount(rs.getInt("totalLoginCount"));
				vo.setPoint(rs.getInt("point"));
				vo.setMemberGrade(rs.getString("memberGrade"));
			}
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	//mid 통한 개별회원 데이터 검색용
	public MemberVO memberMidSearch(String mid) {
		vo = new MemberVO();
		try {
			sql="select * from memberStudy where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setCreateDate(rs.getString("createDate"));
				vo.setLastLoginDate(rs.getString("lastLoginDate"));
				vo.setTotalLoginCount(rs.getInt("totalLoginCount"));
				vo.setPoint(rs.getInt("point"));
				vo.setMemberGrade(rs.getString("memberGrade"));
			}
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	//정보 수정시 기존 데이터 호출용 메소드
	public MemberVO memberInfoChangeBeforeData(String mid) {
		vo = new MemberVO();
		try {
			sql="select * from memberStudy where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
			}
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	//비밀번호 찾기
	public MemberVO memberPWdFind(String mid) {
		vo = new MemberVO();
		try {
			sql="select * from memberStudy where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	

	
	//회원 가입시 새로운 계정 생성
	public int memberSignin(MemberVO vo) {
		int res=0;
		try {
			sql="insert into memberStudy values(default, ?,?,?,?, default, default, default, default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNickName());
			pstmt.executeUpdate();
			res=1;
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	//회원 정보 수정
	public int memberInfoChange(MemberVO vo) {
		int res=0;
		try {
			sql="update memberStudy set pwd=?,name=?,nickName=? where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNickName());
			pstmt.setString(4, vo.getMid());
			pstmt.executeUpdate();
			res=1;
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	//로그인 시 member 정보 업데이트
	public void memberUpdate(String mid, int point) { 
		try {
			sql ="update memberStudy set lastLoginDate=now(), totalLoginCount=totalLoginCount+1, point=? where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
}
