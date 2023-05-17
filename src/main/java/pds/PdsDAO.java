package pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.GetConn;

public class PdsDAO {
	//싱글톤으로 선언된 DB 연결 객체(GetConn)을 연결한다.
  GetConn	getConn = GetConn.getInstance();
	private Connection conn = getConn.getConn();
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	private String sql="";
	
	PDSVO vo = null;

	//파트별 전체자료 가져오기
	public ArrayList<PDSVO> getPdsList(String part,int startIndexNo,int pageSize) {
		ArrayList<PDSVO> vos = new ArrayList<>();
		try {
			if(part.equals("전체")) {
				sql="select *, datediff(now(),fDate) as date_diff, timestampdiff(hour,fDate,now()) as hour_diff "
						+ "from pds order by idx desc limit ? ,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startIndexNo);
				pstmt.setInt(2, pageSize);
			}
			else {
				sql="select * , datediff(now(),fDate) as date_diff, timestampdiff(hour,fDate,now()) as hour_diff "
						+ "from pds where part=? order by idx desc limit ? ,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, part);
				pstmt.setInt(2, startIndexNo);	
				pstmt.setInt(3, pageSize);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new PDSVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setfName(rs.getString("fName"));
				vo.setfSName(rs.getString("fSName"));
				vo.setfSize(rs.getInt("fSize"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setPwd(rs.getString("pwd"));
				vo.setfDate(rs.getString("fDate"));
				vo.setDownNum(rs.getInt("downNum"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				
				vo.setDate_diff(rs.getInt("date_diff"));
				vo.setHour_diff(rs.getInt("hour_diff"));
				vos.add(vo);
			}
					
			
		} catch (SQLException e) {
			System.out.println("sql 오류 : " + e.getMessage());
		} finally {
			getConn.rsClose();
		}
		
		
		return vos;
	}

	public int setPdsInputOk(PDSVO vo) {
		int res = 0;
		
		try {
			sql="insert into pds values(default,?,?,?,?,?,?,?,?,default,default,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getNickName());
			pstmt.setString(3, vo.getfName());
			pstmt.setString(4, vo.getfSName());
			pstmt.setInt(5, vo.getfSize());
			
			pstmt.setString(6, vo.getTitle());
			pstmt.setString(7, vo.getPart());
			pstmt.setString(8, vo.getPwd());
			pstmt.setString(9, vo.getOpenSw());
			pstmt.setString(10, vo.getContent());
			pstmt.setString(11, vo.getHostIp());
			pstmt.executeUpdate();
					
			res=1;
		} catch (SQLException e) {
			System.out.println("sql 오류 : " + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		
		
		
		return res;
	}

	public void setPdsDownNumCheck(int idx) {
		try {
		sql = " update pds set downNum = downNum+1 where idx=?";	
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("sql 오류 : " + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
	}
	
	
	//idx로 검색해서 개별자료 검색처리
	public PDSVO getIdxSearch(int idx) {
		vo = new PDSVO();
		
		try {
			sql = "select * from pds where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(idx);
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setfName(rs.getString("fName"));
				vo.setfSName(rs.getString("fSName"));
				vo.setfSize(rs.getInt("fSize"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setPwd(rs.getString("pwd"));
				vo.setfDate(rs.getString("fDate"));
				vo.setDownNum(rs.getInt("downNum"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
			}
			
		} catch (SQLException e) {
			System.out.println("sql 오류 : " + e.getMessage());
		} finally {
			getConn.rsClose();
		}
		
		
		return vo;
	}
	
	
	//파일시스템의 파일을 삭제처리한 후 DB에서 자료실의 정보를 삭제처리한다.
	public String setPdsDelete(int idx) {
		String res="0";
		try {
			sql="delete from pds where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			res="1";
		} catch (SQLException e) {
			System.out.println("sql 오류 : " + e.getMessage());
		} finally {
			getConn.pstmtClose();
		}
		
		return res;
	}

	public int getTotalRecordCount(String part) {
		int trc = 0;
		try {
			if(part.equals("전체")) {
				sql="select count(idx) as cnt from pds";
				pstmt = conn.prepareStatement(sql);
			}
			else {
				sql="select count(idx) as cnt from pds where part=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, part);
			}
			
			rs = pstmt.executeQuery();
			rs.next();
			trc=rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println("sql 오류 : " + e.getMessage());
		} finally {
			getConn.rsClose();
		}
		return trc;
	}

	
	
	
}
