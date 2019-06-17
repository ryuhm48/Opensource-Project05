package notice.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.beans.board;

public class NoticeBoardDAO {

	private NoticeBoardDAO() {

	}

	private static NoticeBoardDAO instance = new NoticeBoardDAO();

	public static NoticeBoardDAO getInstance() {
		return instance;
	}
	public List<board> newestNotice(){
		List<board> list = new ArrayList<board>();
		
		String sql = "select * from (select * from BOARD where boardnum='2' order by num desc )";
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		board vo = null;
		
		
		try{
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new board();
				vo.setNum(rs.getInt("num"));
				vo.setSubject(rs.getString("subject"));
				vo.setBoarddate(rs.getString("boarddate"));
				vo.setContent(rs.getString("content"));
				list.add(vo);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return list;
	}

	public List<board> selectAllBoards(){
		List<board> list = new ArrayList<board>();
		String sql="select num, id, subject, content, email, boarddate, score from BOARD where boardnum='2' order by num desc";
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		board vo = null;
		try{
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				vo=new board();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setBoardnum(rs.getInt("boardnum"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setScore(rs.getString("score"));
				vo.setBoarddate(rs.getString("boarddate"));
				list.add(vo);
			}
			System.out.println("noticeBoard list : "+list);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		
		
		return list;
	}

	public void insertBoard(board vo) {
		String sql="insert into board(num, subject, content, id, boardnum) values("
				+ "board_SEq.nextval,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt = null;
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";
		try{
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());	//臾몄�μ����
			pstmt.setString(3, vo.getId());	
			pstmt.setInt(4, vo.getBoardnum());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

	public void updateScore(String num) {
		String sql="update board set score = score+1 where num=?";
		Connection conn=null;
		PreparedStatement pstmt = null;
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";
		
		try{
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			
		}

	}

	public board selectOneBoard(String num) {
		String sql="select * from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		board vo = null;
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";
		try{
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			rs =  pstmt.executeQuery();
			
			if(rs.next()){  
				vo=new board();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setScore(rs.getString("score"));
				vo.setBoarddate(rs.getString("boarddate"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		//#46] BoardViewAction�쇰� ����媛���
		return vo;

	}

	public void updateBoard(board vo) {
		String sql = "update board set id=?, subject=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";

		try {
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getNum()); // 臾몄�� ���깅����~
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		//#89] 由ы��!
	}


	public void deleteBoard(board vo) {
		String sql="delete from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";
		try{
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
			//�듭�ㅽ���� 荑쇰━�� ��瑜쇰�ㅼ�� �����몄��� 蹂댁�ъ�
			// ���곗�댄�몃�� 蹂�寃쎌�� 議곌��대�쇰�����⑤��
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
}
