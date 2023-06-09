package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.GetConn;
import member.MemberVO;

public class AdminDAO {
	 GetConn	getConn = GetConn.getInstance();
		private Connection conn = getConn.getConn();
		private PreparedStatement pstmt =null;
		private ResultSet rs = null;
		
		private String sql="";
		
		MemberVO vo = null;

		public String setMemberLevelChange(int idx, int level) {
			String res = "0";
			try {
				sql = "update member set level=? where idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, level);
				pstmt.setInt(2, idx);
				pstmt.executeUpdate();
				
				res="1";
			} catch (SQLException e) {
				System.out.println("정보 입력 sql문 오류" + e.getMessage());
			} finally {
				getConn.pstmtClose();
			}
			return res;
		}
		
		//idx로 멤버 등급 업데이트
		public void setMemberLevelOnIdx(int i,String idx) {
			try {
				sql = "update member set level=? where idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				pstmt.setString(2, idx);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("정보 입력 sql문 오류" + e.getMessage());
			} finally {
				getConn.pstmtClose();
			}
		}
		
		
	
	
	//방문포인투룰

}
