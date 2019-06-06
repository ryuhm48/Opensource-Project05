package Problem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Date;

public class AnswerDAO {
	private String sql = null;
	private String jdbc_driver = "com.mysql.jdbc.Driver";
	private String jdbc_url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
	private static AnswerDAO instance = new AnswerDAO();
	protected AnswerDAO(){}
	public static AnswerDAO getInstance() {
		return instance;
	}
	
	public void insert(AnswerDTO ansDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "insert into Problems(problemNum1, answerCode, answerLanguage, writerName, problemCorrection, answerNum) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ansDTO.getProblemNum1());
			pstmt.setString(2, ansDTO.getAnswerCode());
			pstmt.setString(3, ansDTO.getAnswerLanguage());
			pstmt.setString(4, ansDTO.getWriterName());
			pstmt.setBoolean(5, ansDTO.getProblemCorrection());
			pstmt.setInt(6,ansDTO.getAnswerNum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}
	
	public ArrayList<AnswerDTO> answerList(int problemNum1){
		ArrayList<AnswerDTO> list = new ArrayList<AnswerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select problemNum1, answerLanguage, writerName, answerCode, problemCorrection, answerNum from problems where problemNum1 = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, problemNum1);
			rs = pstmt.executeQuery();
			if(rs.next())
			{do
			{
				String answerLanguage = rs.getString("answerLanguage");
				String writerName = rs.getString("writerName");
				String answerCode = rs.getString("answerCode");
				Boolean problemCorrection = rs.getBoolean("problemCorrection");
				int answerNum = rs.getInt("answerNum");
				AnswerDTO a = new AnswerDTO();
				a.setAnswerLanguage(answerLanguage);
				a.setProblemNum1(problemNum1);
				a.setWriterName(writerName);
				a.setAnswerCode(answerCode);
				a.setProblemCorrection(problemCorrection);
				a.setAnswerNum(answerNum);
				list.add(a);
			}
			while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close(); 
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int getTableSize() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rd = null;
		int size = 0;
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select count(*) from Answers";
			
			rs = pstmt.executeQuery(sql);
			rd = rs.getMetaData();
			size = rd.getColumnCount();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close(); 
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return size;
	}
	
}
