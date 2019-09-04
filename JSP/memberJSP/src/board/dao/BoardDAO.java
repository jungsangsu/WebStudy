package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;

	private Connection conn;
	private DataSource ds;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); //데이터 소스에 넣어!! 무엇을? xml에 저장된 내용들을
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}


	public int write(BoardDTO boardDTO) {
		int su = 0;

		String sql = "insert into board(seq,id,name,email,subject,content,ref,logtime)"
				+ " values(seq_board.nextval,?,?,?,?,?,seq_board.CURRVAL,sysdate)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getSubject());
			pstmt.setString(5, boardDTO.getContent());

			su = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}

	public ArrayList<BoardDTO> select(int startNum, int endNum) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql = ("select * from(select rownum rn," + " tt.*from(select seq,id,name,email,subject,content,ref,lev,step,pseq,reply,"
				+ "to_char(logtime, 'YYYY-MM-DD') as logtime,hit"
				+ " from board order by seq asc) tt) where rn>=? and rn<=?");


		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO temp = new BoardDTO();
				temp.setSeq(rs.getInt("seq"));
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setEmail(rs.getString("email"));
				temp.setSubject(rs.getString("subject"));
				temp.setContent(rs.getString("content"));
				temp.setRef(rs.getInt("ref"));
				temp.setLev(rs.getInt("lev"));
				temp.setStep(rs.getInt("step"));
				temp.setReply(rs.getInt("reply"));
				temp.setHit(rs.getInt("hit"));
				temp.setLogtime(rs.getString("logtime"));

				list.add(temp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) from board";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next();
			totalA = rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalA;
	}
	
	public BoardDTO getboard(int seq)
	{
		BoardDTO temp = null;
		
		String sql = "select * from board where seq = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				temp = new BoardDTO();
				temp.setSeq(rs.getInt("seq"));
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setEmail(rs.getString("email"));
				temp.setSubject(rs.getString("subject"));
				temp.setContent(rs.getString("content"));
				temp.setRef(rs.getInt("ref"));
				temp.setLev(rs.getInt("lev"));
				temp.setStep(rs.getInt("step"));
				temp.setReply(rs.getInt("reply"));
				temp.setHit(rs.getInt("hit"));
				temp.setLogtime(rs.getString("logtime"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return temp;
	}

	public int updateMap(Map<String,String> map)
	{
		int su = 0;
		
		String sql = "update board set subject =?, content=?, logtime = sysdate where seq=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("subject"));
			pstmt.setString(2, map.get("content"));
			pstmt.setInt(3, Integer.parseInt(map.get("seq")));
			
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return su;
		
		
	}
	
	
	public int update(BoardDTO boardDTO)
	{
		int su = 0;
		
		String sql = "update board set subject =?, content=? where seq=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getSubject());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, boardDTO.getSeq());
			
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return su;
	}
	
	public int boardHit(int seq)
	{
		int su = 0;
		
		String sql = "update board set hit=hit+1 where seq=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
}
