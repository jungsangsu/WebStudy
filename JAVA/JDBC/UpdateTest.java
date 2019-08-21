package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	private Connection conn;
	private PreparedStatement pstmt;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "tkdtn";
	
	public UpdateTest() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getConnection() 
	{
		try {
			conn = DriverManager.getConnection(url
					, user, password);
			System.out.println("접속성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticle()
	{
		try {
			
			Scanner input = new Scanner(System.in);
			System.out.println("input name : ");
			String name = input.nextLine();
	
			this.getConnection();
			
			
			String sql = "Update dbtest set age = age+1 where name = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int su = pstmt.executeUpdate(); // 항상 몇개를 실행(CRUD)한지 갯수를 return
			
			System.out.println(su+"row update");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void main(String[] args) {
		UpdateTest it = new UpdateTest();
		it.updateArticle();
	}
	
}
