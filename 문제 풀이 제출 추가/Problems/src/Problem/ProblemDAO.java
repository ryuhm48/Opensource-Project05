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
		ResultSet rs = null;
		int count = 0;
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select * from problemscount";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("count");
		}catch(Exception e) {
				System.out.println(e);
		}try {
			if(rs != null)
				rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}try {
			sql = "insert into Problems(studyNum, problemNum1, problemNum2, problemName, problemLanguage, problemDate, writerName, problemContent, problemInput, problemInputEx, problemOutput, problemOutputEx) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, problemDTO.getStudyNum());
			pstmt.setInt(3, problemDTO.getProblemNum2());
			pstmt.setString(4, problemDTO.getProblemName());
			pstmt.setString(5, problemDTO.getProblemLanguage());
			pstmt.setDate(6, problemDTO.getProblemDate());
			pstmt.setString(7, problemDTO.getWriterName());
			pstmt.setString(8, problemDTO.getProblemContent());
			pstmt.setString(9, problemDTO.getProblemInput());
			pstmt.setString(10, problemDTO.getProblemInputEx());
			pstmt.setString(11, problemDTO.getProblemOutput());
			pstmt.setString(12, problemDTO.getProblemOutputEx());
			count++;
			pstmt.setInt(2, count);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}try {
			if(pstmt != null)
				pstmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}try {
			sql = "update problemsCount set count = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.executeUpdate();			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2);
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
			sql = "select studyNum, problemNum1, problemNum2, problemName, problemLanguage, problemDate, commentNum, writerName, problemContent from problems where studyNum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studyNum);
			rs = pstmt.executeQuery();
			if(rs.next())
			{do
			{
				int StudyNum = rs.getInt("studyNum");
				int problemNum1 = rs.getInt("problemNum1");
				int problemNum2 = rs.getInt("problemNum2");
				String problemName = rs.getString("problemName");
				String problemLanguage = rs.getString("problemLanguage");
				String writerName = rs.getString("writerName");
				Date problemDate = rs.getDate("problemDate");
				String problemContent = rs.getString("problemContent");
				int commentNum = rs.getInt("commentNum");
				ProblemDTO p = new ProblemDTO();
				p.setStudyNum(StudyNum);
				p.setProblemNum1(problemNum1);
				p.setProblemNum2(problemNum2);
				p.setProblemName(problemName);
				p.setProblemLanguage(problemLanguage);
				p.setWriterName(writerName);
				p.setProblemDate(problemDate);
				p.setCommentNum(commentNum);
				p.setProblemContent(problemContent);
				list.add(p);
			}
			while(rs.next());
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close(); 
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		
		return list;
	}
	
	public void write(int studyNum, int problemNum2, String problemName, String problemLanguage, String writerName, String problemContent, String problemInput, String problemOutput, String problemInputEx, String problemOutputEx)
	{
		java.util.Date UDate = new java.util.Date();
		Date problemDate = new Date(UDate.getTime());
		ProblemDTO p = new ProblemDTO();
		p.setProblemDate(problemDate);
		p.setStudyNum(studyNum);
		p.setProblemNum2(problemNum2+1);
		p.setProblemLanguage(problemLanguage);
		p.setProblemName(problemName);
		p.setWriterName(writerName);
		p.setProblemContent(problemContent);
		p.setProblemInput(problemInput);
		p.setProblemOutput(problemOutput);
		p.setProblemInputEx(problemInputEx);
		p.setProblemOutputEx(problemOutputEx);
		insert(p);
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
			sql = "select * from problems where problemNum1 = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, problemNum);
			rs = pstmt.executeQuery();
			String problemInput = null;
			String problemOutput = null;
			if(rs.next())
			{
				if(rs.getString("problemInput")!= null)
					problemInput = rs.getString("problemInput");
				if(rs.getString("problemOutput")!= null)
					problemOutput = rs.getString("problemOutput");
			}
			prodto.setProblemNum1(problemNum);
			prodto.setProblemInput(problemInput);
			prodto.setProblemOutput(problemOutput);
		}catch(Exception e){
			System.out.println(e);
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
	
	public ProblemDTO getProblemContent(int problemNum) {
		ProblemDTO p = new ProblemDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProblemDTO prodto = new ProblemDTO();
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select * from Problems where problemNum1 = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, problemNum);
			rs = pstmt.executeQuery();
			int studyNum = -1;
			String problemName = null;
			String problemContent = null;
			String problemInputEx = null;
			String problemOutputEx = null;
			if(rs.next())
			{
				if(rs.getString("problemName")!= null)
					problemName = rs.getString("problemName");
				if(rs.getString("problemContent")!= null)
					problemContent = rs.getString("problemContent");
				if(rs.getInt("studyNum") != -1)
					studyNum = rs.getInt("studyNum");
				if(rs.getString("problemInputEx")!= null)
					problemInputEx = rs.getString("problemInputEx");
				if(rs.getString("problemOutputEx")!= null)
					problemOutputEx = rs.getString("problemOutputEx");
				prodto.setStudyNum(studyNum);
				prodto.setProblemNum1(problemNum);
				prodto.setProblemName(problemName);
				prodto.setProblemContent(problemContent);
				prodto.setProblemInputEx(problemInputEx);
				prodto.setProblemOutputEx(problemOutputEx);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close(); 
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		return prodto;
	}
	
	public int getStudyNum(int problemNum)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rd = null;
		int studyNum = 0;
		int size = 0;
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select studyNum from problems where problemNum1 = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, problemNum);
			rs = pstmt.executeQuery();
			if(rs.next())
				studyNum = rs.getInt("studyNum");
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close(); 
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		return studyNum;
	}
	
	public ProblemDTO getProblemDTO(int problemNum) {
		ProblemDTO problem = new ProblemDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "adg!35adg!");
			sql = "select * from Problems where problemNum1 = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, problemNum);
			rs = pstmt.executeQuery();
			int studyNum = 0;
			String problemOutput = null;
			if(rs.next())
			{
				studyNum = rs.getInt("studyNum");
				if(rs.getString("problemOutput")!= null)
					problemOutput = rs.getString("problemOutput");
			}
			problem.setProblemNum1(problemNum);
			problem.setStudyNum(studyNum);
			problem.setProblemOutput(problemOutput);	
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
		return problem;
	}
	
}
