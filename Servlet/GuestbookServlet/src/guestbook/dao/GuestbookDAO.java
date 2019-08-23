package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private static GuestbookDAO instance;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "tkdtn";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static GuestbookDAO getInstance() {
		if (instance == null) {
			synchronized (GuestbookDAO.class) {
				instance = new GuestbookDAO();
			}
		}
		return instance;
	}

	public GuestbookDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int write(GuestbookDTO guestbookDTO) {
		int su = 0;
		getConnection();// 立加
		// 累己磊,捞皋老,权其捞瘤,力格,郴侩
		String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);// 积己
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getTitle());
			pstmt.setString(5, guestbookDTO.getContext());

			su = pstmt.executeUpdate();// 角青-俺荐 府畔

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

	public ArrayList<GuestbookDTO> Select(int startNum, int endNum) {

		int su = 0;
		getConnection();// 立加

		ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		String sql = ("select * from(select rownum rn," + " tt.*from(select name," + " email, homepage, "
				+ "subject, content, " + "to_char(logtime, 'YYYY-MM-DD') as logtime "
				+ "from guestbook order by seq desc) tt) where rn>=? and rn<=?");

		try {
			pstmt = conn.prepareStatement(sql);// 积己
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);

			rs = pstmt.executeQuery();
			String id;
			while (rs.next()) {
				GuestbookDTO tempDTO = new GuestbookDTO();
				tempDTO.setName(rs.getString("name"));
				tempDTO.setEmail(rs.getString("email"));
				tempDTO.setHomepage(rs.getString("homepage"));
				tempDTO.setTitle(rs.getString("subject"));
				tempDTO.setContext(rs.getString("content"));
				tempDTO.setDate(rs.getString("logtime"));
				list.add(tempDTO);
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
			list = null;

		} finally {
			try {
				if (rs != null)
					rs.close();
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
	
	public int getTotalA()
	{
	      int totalA = 0;
	      String sql = "select count(*) from guestbook";
	      getConnection();

	      try {
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
}
