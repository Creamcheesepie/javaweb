package homeStudy.pageProcess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HsBoardDAO {
	private Connection conn=null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql="";
	HsBoardVO vo = null;
	
	public HsBoardDAO() {
		String url="jdbc:mysql://localhost:3306/javaweb";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 오류" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류" + e.getMessage());
		}
	}
	
	public void pstmtClose() {
		if(pstmt != null) {
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
	
	public ArrayList<HsBoardVO> getBoardList(int startIndexNo, int pageSize){
		ArrayList<HsBoardVO> vos = new ArrayList<>();
		try {
			sql = "select * from board order by idx desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndexNo);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new HsBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getString("title"));
				vo.setMid(rs.getString("mid"));
				vos.add(vo);
			}
				
		} catch (SQLException e) {
			System.out.println("sql문 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
	public int getTotalRecordCount() {
		int trc=0;
		
		try {
			sql="select count(idx) as cnt from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			trc=rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println("sql문 오류(총레코드부)" + e.getMessage());
		} finally {
			rsClose();
		}
		return trc;
		
	}
	//게시글 작성
	public int setBoardInputOk(HsBoardVO vo) {
		int res=0;
		try {
			sql="insert into board values (default,?,?,?,?,default,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setInt(2, vo.getDeletekey());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getArticle());
			pstmt.setString(5, vo.getHostIp());
			pstmt.executeUpdate();
			res=1;
		} catch (SQLException e) {
			System.out.println("sql 문 오류" + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		
		return res;
	}
	//게시글 읽어오기

	public HsBoardVO getBoardArticle(int idx) {
		vo = new HsBoardVO();
		try {
			sql = "select * from board where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new HsBoardVO();
				vo.setArticle(rs.getString("article"));
				vo.setTitle(rs.getString("title"));
				vo.setMid(rs.getString("mid"));
			}
				
		} catch (SQLException e) {
			System.out.println("sql문 오류 " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
}	
