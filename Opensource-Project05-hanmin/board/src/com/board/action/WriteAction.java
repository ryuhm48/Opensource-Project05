/**
 * 글을 작성 하고 데이터베이스에 넣는 Action
 */
package com.board.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class WriteAction implements CommandAction {
	static int num = 0;

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {
		// 제목과 내용을 입력 받아 변수에 저장
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		
		String name = request.getParameter("name");
		String inform = request.getParameter("inform");
		String administor = null;
		
		
		int kind;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind = 1;
		}
		String id = null;
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
	
		// Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		try {
			HttpSession session = request.getSession();
			// 세션을 읽어 로그인 상태가 아니면 로그인 창으로 이동
			id = (String) session.getAttribute("id");
			administor=id;
			if (id == null) {
				return "loginerror.jsp";
			}
			Class.forName(jdbc_driver);
			String dbUser = "root";
			String dbPass = "";

			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			// String query = "select * COALESCE(max(num),0) from board where num =
			// '"+num+"';";

			if (kind == 1 ||kind == 2||kind == 4) {
				pstmt = conn.prepareStatement(

						"insert into board values(NULL,?,?,?,now(),0,?)");
				pstmt.setString(1, id);
				pstmt.setString(2, subject);
				pstmt.setString(3, content);
				pstmt.setInt(4, kind);
				// 쿼리 실행
				pstmt.executeUpdate();
			} 
			else if (kind==3){//파일추가
				pstmt = conn.prepareStatement(

						"insert into board values(NULL,?,?,?,?,now(),0,?)");
				pstmt.setString(1, id);
				pstmt.setString(2, subject);
				pstmt.setString(3, content);
				pstmt.setString(4, email);
				pstmt.setInt(5, kind);
				// 쿼리 실행
				pstmt.executeUpdate();
			}
			else {
				pstmt = conn.prepareStatement("insert into studydb values(NULL,?,?,?)");
				pstmt.setString(1, name);
				pstmt.setString(2, inform);
				pstmt.setString(3, administor);
				// 쿼리 실행
				pstmt.executeUpdate();
				String query2="select * from studydb where name = '" + name + "' and inform = '" + inform + "'and administor = '"+administor+"';";
				pstmt2 = conn.prepareStatement(query2);
				rs=pstmt2.executeQuery();

				pstmt3 = conn.prepareStatement("insert into userstudydb values(NULL,?,?,?)");
				while(rs.next()) {
					
					pstmt3.setInt(2, rs.getInt("num"));
					
				}
				pstmt3.setString(1,id);
				pstmt3.setInt(3, 2);
				pstmt3.executeUpdate();
				//studydb num userdb id
				
				

				
			}

		} catch (SQLException ex) {

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

		return "write.jsp";

	}

}