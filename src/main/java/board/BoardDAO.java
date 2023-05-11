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
//			sql = "select *,datediff(now(),wDate) as date_diff,timestampdiff(hour, wDate,now()) as hour_diff "
//					+ "from board1 order by idx desc limit ?,?";
				sql = "select *, datediff(now(),wDate) as date_diff, timestampdiff(hour, wDate,now()) as hour_diff, "
												+ "(select count(*) from boardReply where boardIdx=b.idx) as replyCount "
												+ "from board1 b order by idx desc limit ?,? ";
			
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
				vo.setreplyCount(rs.getInt("replyCount"));
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
			
			//이전글 다음글 내용 가져오기
			
			
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
	
	
	
	//좋아요 1 증감시키기
	public void setGoodPlusUpdate(int goodUpDown, int idx) {
		try {
			sql = "update board1 set good = good+? where idx=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, goodUpDown);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
			
		}  catch (Exception e) {
			System.out.println("sql문 오류 : " +e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
	}
	

	
	
	//글 idx와 게시판, 좋아요 누른 사람을 저장
	public void setGoodUserUpdate(String sector,int idx,String mid) {
		try {
			sql = "insert into goodCnt values(?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sector);
			pstmt.setInt(2, idx);
			pstmt.setString(3, mid);
			pstmt.executeUpdate();
			
		}  catch (Exception e) {
			System.out.println("sql문 오류 : " +e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
	}

	//좋아요 눌렀는지 여부 확인하기
	public BoardVO getGoodCheck(String sector, int idx, String mid) {
		vo = new BoardVO();
		try {
			sql="select * from goodCnt where sector=? and idx=? and mid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sector);
			pstmt.setInt(2, idx);
			pstmt.setString(3, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
			};
		}  catch (Exception e) {
			System.out.println("sql문 오류 : " +e.getMessage());
		} finally {
			getConn.rsClose();
		}
		
		
		return vo;
	}

	public void setGoodUserDelete(String sector, int idx, String mid) {
		try {
			sql = "delete from goodCnt where sector=? and idx=? and mid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sector);
			pstmt.setInt(2, idx);
			pstmt.setString(3, mid);
			pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		}finally {
			getConn.pstmtClose();
		}
		
	}

	public BoardVO getPreNaxtContentSearch(int idx, String str) {
		vo = new BoardVO();
		
		try {
			if(str.equals("preVO")) sql = "select idx,title from board1 where idx < ? order by idx desc limit 1";			
			else sql="select idx,title from board1 where idx > ? limit 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(str.equals("preVO")) {
					vo.setPreIdx(rs.getInt("idx"));
					vo.setPreTitle(rs.getString("title"));					
				}
				else if(str.equals("nextVO")) {
					vo.setNextIdx(rs.getInt("idx"));
					vo.setNextTitle(rs.getString("title"));										
				}
			}
		}catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		}finally {
			getConn.rsClose();
		}
		
		return vo;
	}
	
	
	//검색기 자료 검색 처리
	public ArrayList<BoardVO> getBoardContentSearch(String search, String searchString) {
		ArrayList<BoardVO> vos = new ArrayList<>();
		
		try { 
			sql = "select * from board1 where "+search+" like ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchString+"%");
			rs=pstmt.executeQuery();
			
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
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			getConn.rsClose();
		}
		
		return vos;
	}

	public int setBoardDelete(int idx) {
		int res = 0;
		try {
			sql = "delete from board1 where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			res=1;
		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		
		return res;
	}

	
	//게시글 수정하기.
	public int setBoardUpdateOk(BoardVO vo) {
		int res=0;
		try {
			sql = "update board1 set title=?,email=?,homePage=?,content=?,hostIp=?,openSw=? where idx=?";
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getHomePage());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getHostIp());
			pstmt.setString(6, vo.getOpenSw());
			pstmt.setInt(7, vo.getIdx());
			
			pstmt.executeUpdate();
			
			res=1;
		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		
		return res;
	}
	
	
	//댓글 입력하디
	public String setReplyInputOk(BoardReplyVO replyVo) {
		String res = "0";
		try {
			sql = "insert into boardReply values(default ,?,?,?, default,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyVo.getBoardIdx());
			pstmt.setString(2, replyVo.getMid());
			pstmt.setString(3, replyVo.getNickName());
			pstmt.setString(4, replyVo.getPostIp());
			pstmt.setString(5, replyVo.getContent());
			pstmt.executeUpdate();
			
			res="1";
		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		
		return res;
	}
	
	//부모들에 해당하는 댓글내역 자겨오기
	public ArrayList<BoardReplyVO> getBoardReply(int idx) {
		ArrayList<BoardReplyVO> replyVos = new ArrayList<>();
		
		try {
			sql = "select * from boardReply where boardIdx=? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardReplyVO replyVo = new BoardReplyVO();
				replyVo.setIdx(rs.getInt("idx"));
				replyVo.setBoardIdx(rs.getInt("boardIdx"));
				replyVo.setMid(rs.getString("mid"));
				replyVo.setNickName(rs.getString("NickName"));
				replyVo.setwDate(rs.getString("wDate"));
				replyVo.setPostIp(rs.getString("postIp"));
				replyVo.setContent(rs.getString("content"));
				replyVos.add(replyVo);
			}
		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			getConn.rsClose();
		}
		return replyVos;
	}

	public int setReplyDelete(int idx) {
		int res = 0;
		try {
			sql = "delete from boardReply where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			res=1;
		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		return res;
	}
	
	
	
	
}
