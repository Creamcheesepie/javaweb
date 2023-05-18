package study2.Api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.BoardReplyVO;
import board.BoardVO;
import conn.GetConn;

public class CrimeDAO {
	//싱글톤으로 선언된 DB 연결 객체(GetConn)을 연결한다.
  GetConn	getConn = GetConn.getInstance();
	private Connection conn = getConn.getConn();
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	private String sql="";
	
	CrimeVO vo = null;

	//자료 저장하기
	public void setCrimeSaveOk(CrimeVO vo) {
		try {
			sql="insert into crime values(default,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getYear());
			pstmt.setString(2, vo.getPolice());
			pstmt.setInt(3, vo.getRobbery());
			pstmt.setInt(4, vo.getMurder());
			pstmt.setInt(5, vo.getTheft());
			pstmt.setInt(6, vo.getViolence());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
			
		}
		
	}

	public String setCrimeDeleteOk(int year) {
		String res ="0";
		try {
			sql="delete from crime where year=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			pstmt.executeUpdate();
			res="1";
		} catch (SQLException e) {
			System.out.println("sql 오류" + e.getMessage());
		} finally {
			getConn.pstmtClose();
			
		}

		return res;
	}

	
	public ArrayList<CrimeVO> getYearCrimeDataAll(int year) {
		ArrayList<CrimeVO> vos = new ArrayList<>();
		try {
			sql = "select * from crime where year = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new CrimeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setYear(rs.getInt("year"));
				vo.setPolice(rs.getString("police"));
				vo.setRobbery(rs.getInt("robbery"));;
				vo.setMurder(rs.getInt("murder"));
				vo.setTheft(rs.getInt("theft"));
				vo.setViolence(rs.getInt("violence"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류" + e.getMessage());
		} finally {
			getConn.rsClose();
			
		}
		
		return vos;
	}

	public ArrayList<CrimeVO> getYearCrimeDataOrderByPolice(int year, String order) {
		ArrayList<CrimeVO> vos = new ArrayList<>();
		try {
			sql = "select * from crime where year = ? order by police "+order;
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new CrimeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setYear(rs.getInt("year"));
				vo.setPolice(rs.getString("police"));
				vo.setRobbery(rs.getInt("robbery"));;
				vo.setMurder(rs.getInt("murder"));
				vo.setTheft(rs.getInt("theft"));
				vo.setViolence(rs.getInt("violence"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류" + e.getMessage());
		} finally {
			getConn.rsClose();
			
		}
		
		return vos;
	}
}
