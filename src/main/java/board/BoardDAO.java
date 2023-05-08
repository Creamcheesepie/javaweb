package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.GetConn;

public class BoardDAO {
	//싱글톤으로 선언된 DB 연결 객체(GetConn)을 연결한다.
  GetConn	getConn = GetConn.getInstance();
	private Connection conn = getConn.getConn();
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	private String sql="";
	
	BoardVO vo = null;

	public ArrayList<BoardVO> getBoardList(int startIndexNo, int pageSize) {
		ArrayList<BoardVO> vos = new ArrayList<>();
		try {
			
//			sql = "select * from board1 order by idx desc limit ?,?";
//			sql = "select *,timestampdiff(hour, wDate,now()) as hour_diff "
//					+ "from board1 order by idx desc limit ?,?";
			sql = "select *,datediff(now(),wDate) as date_diff,timestampdiff(hour, wDate,now()) as hour_diff "
					+ "from board1 order by idx desc limit ?,?";

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndexNo);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setEmail(rs.getString("email"));
				vo.setHomePage(rs.getString("homePage"));
				vo.setContent(rs.getString("content"));
				vo.setReadNum(rs.getInt("readNum"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setwDate(rs.getString("wDate"));
				vo.setGood(rs.getInt("good"));
				vo.setHour_diff(rs.getInt("hour_diff"));
				vo.setDate_diff(rs.getInt("date_diff"));
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage() );
		} finally {
			getConn.rsClose();
		}
	
		return vos;
	}
	
	//게시글 저장하기
	public int setBoardInput(BoardVO vo) {
		int res = 0;
		try {
			sql = "insert into board1 values(default,?,?,?,?,?,?,default,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getNickName());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getHomePage());
			pstmt.setString(6, vo.getContent());
			pstmt.setString(7, vo.getHostIp());
			pstmt.setString(8, vo.getOpenSw());
			
			pstmt.executeUpdate();
			 res=1;
		} catch (Exception e) {
			System.out.println("sql문 오류 : " +e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		return res;
	}

	public int getTotRecCnt() {
		int totRecCnt=0;
		try {
			sql="select count(idx) as cnt from board1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totRecCnt=rs.getInt("cnt");
			
		} catch (Exception e) {
			getConn.rsClose();
		}
		
		return totRecCnt;
	}

	public BoardVO getBoardContent(int idx) {
		vo = new BoardVO();
		try {
			sql = "select * from board1 where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			
			vo.setIdx(rs.getInt("idx"));
			vo.setMid(rs.getString("mid"));
			vo.setNickName(rs.getString("nickName"));
			vo.setTitle(rs.getString("title"));
			vo.setEmail(rs.getString("email"));
			vo.setHomePage(rs.getString("homePage"));
			vo.setContent(rs.getString("content"));
			vo.setReadNum(rs.getInt("readNum"));
			vo.setHostIp(rs.getString("hostIp"));
			vo.setOpenSw(rs.getString("openSw"));
			vo.setwDate(rs.getString("wDate"));
			vo.setGood(rs.getInt("good"));
			
		} catch (Exception e) {
			getConn.rsClose();
		}
		return vo;
	}
	//조회수 1 증가시키기
	public void setReadnumUpdate(int idx) {
		try {
			sql = "update board1 set readNum = readNum+1 where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		}  catch (Exception e) {
			System.out.println("sql문 오류 : " +e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
	}
	//좋아요 1 증가시키기
	public void setGoodUpdate(int idx ,String mIdx) {
		try {
			sql = "update board1 set good=good+1 ,goodMember=goodMember+? where idx=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, mIdx);
			pstmt.executeUpdate();
			
		}  catch (Exception e) {
			System.out.println("sql문 오류 : " +e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
	}
	
	public BoardVO getMIdxinfo(int idx) {
		vo = new BoardVO();
		try {
			sql = "select goodMember from board1 where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			
			vo.setGoodMember(rs.getString("goodMember"));
			
		}  catch (Exception e) {
			System.out.println("sql문 오류 : " +e.getMessage());
		}
		return vo;
	}
	
	
}