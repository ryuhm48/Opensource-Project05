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

public class ProblemDAO {
	private String sql = null;
	private String jdbc_driver = "com.mysql.jdbc.Driver";
	private String jdbc_url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
	private static ProblemDAO instance = new ProblemDAO();
	protected ProblemDAO(){}
	public static ProblemDAO getInstance() {
		return instance;
	}
	
	public void insert(ProblemDTO problemDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "insert into Problems(studyNum, problemNum1, problemNum2, problemName, problemLanguage, problemDate, writerName, problemContent) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, problemDTO.getStudyNum());
			pstmt.setInt(2, problemDTO.getProblemNum1());
			pstmt.setInt(3, problemDTO.getProblemNum2());
			pstmt.setString(4, problemDTO.getProblemName());
			pstmt.setString(5, problemDTO.getProblemLanguage());
			pstmt.setDate(6, problemDTO.getProblemDate());
			pstmt.setString(7, problemDTO.getWriterName());
			pstmt.setString(8, problemDTO.getProblemContent());
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
	
	public ArrayList<ProblemDTO> problemList(int studyNum){
		ArrayList<ProblemDTO> list = new ArrayList<ProblemDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select studyNum, problemNum2, problemName, problemLanguage, problemDate, commentNum, writerName, problemContent from Problems where studyNum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studyNum);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				int StudyNum = rs.getInt("studyNum");
				int problemNum2 = rs.getInt("problemNum2");
				String problemName = rs.getString("problemName");
				String problemLanguage = rs.getString("problemLanguage");
				String writerName = rs.getString("writerName");
				Date problemDate = rs.getDate("problemDate");
				String problemContent = rs.getString("problemContent");
				int commentNum = rs.getInt("commentNum");
				ProblemDTO p = new ProblemDTO();
				p.setStudyNum(StudyNum);
				p.setProblemNum2(problemNum2);
				p.setProblemName(problemName);
				p.setProblemLanguage(problemLanguage);
				p.setWriterName(writerName);
				p.setProblemDate(problemDate);
				p.setCommentNum(commentNum);
				p.setProblemContent(problemContent);
				list.add(p);
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
	
	public void write(int studyNum, int problemNum2, String problemName, String problemLanguage, String writerName, String problemContent)
	{
		java.util.Date UDate = new java.util.Date();
		Date problemDate = new Date(UDate.getTime());
		int problemNum1 = getTableSize() + 1;
		ProblemDTO p = new ProblemDTO();
		p.setProblemDate(problemDate);
		p.setStudyNum(studyNum);
		p.setProblemNum1(problemNum1);
		p.setProblemNum2(problemNum2+1);
		p.setProblemLanguage(problemLanguage);
		p.setProblemName(problemName);
		p.setWriterName(writerName);
		p.setProblemContent(problemContent);
		insert(p);
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
			sql = "select count(*) from Problems";
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
	
	public ProblemDTO getProblem(int problemNum) {
		ProblemDTO p = new ProblemDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProblemDTO prodto = new ProblemDTO();
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select * from Problems where ProblemNum1 = ?";
			pstmt.setInt(1, problemNum);
			rs = pstmt.executeQuery();
			String problemInput = null;
			String problemOutput = null;
			if(rs.getString("problemInput")!= null)
				problemInput = rs.getString("problemInput");
			if(rs.getString("problemOutput")!= null)
				problemOutput = rs.getString("problemOutput");
			prodto.setProblemNum1(problemNum);
			prodto.setProblemInput(problemInput);
			prodto.setProblemOutput(problemOutput);
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
		return prodto;
	}
	
}
