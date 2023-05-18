package schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.BoardReplyVO;
import board.BoardVO;
import conn.GetConn;

public class ScheduleDAO {
	//싱글톤으로 선언된 DB 연결 객체(GetConn)을 연결한다.
  GetConn	getConn = GetConn.getInstance();
	private Connection conn = getConn.getConn();
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	private String sql="";
	
	ScheduleVO vo = null;

	
	//선택된 날짜(년/월)의 개별회원에 대한 스케줄의 모든 정보를 가져오기
	public ArrayList<ScheduleVO> getSchedule(String mid, String ym,int sw) {
		ArrayList<ScheduleVO> vos = new ArrayList<>();
		
		try {
			if(sw==0) { //한 달 지정
				sql="select * from schedule where mid = ? and date_format(sDate,'%Y-%m') = ?  order by sDate, part";
			}
			if(sw==1) { //날짜 지정
				sql="select * from schedule where mid = ? and date_format(sDate,'%Y-%m-%d') = ?  order by sDate, part";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, ym);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ScheduleVO vo =  new ScheduleVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setsDate(rs.getString("sDate"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류 : " + e.getMessage());
		} finally {
			getConn.rsClose();
		}
		
		return vos;
		
	}


	public String setScheduleInputOk(ScheduleVO vo) {
		String res = "0";
		try {
			sql = "insert into schedule values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getsDate());
			pstmt.setString(3, vo.getPart());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
			 res="1";
		} catch (SQLException e) {
			System.out.println("sql오류");
		} finally {
			getConn.pstmtClose();
		}
		
		
		
		return res;
	}


	public String setUpdateSchedule(ScheduleVO vo) {
		String res = "0";
		try {
			sql = "update schedule set part=?, content=? where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPart());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getIdx());
			pstmt.executeUpdate();
			res="1";
		} catch (SQLException e) {
			System.out.println("sql오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		
		return res;
	}

	
	
	
	
}
