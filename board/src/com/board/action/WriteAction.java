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
	static int num=0;
    public String requestPro(HttpServletRequest request,
 
    HttpServletResponse response) throws Throwable {
    	
    	request.setCharacterEncoding("euc-kr");
    	//제목과 내용을 입력 받아 변수에 저장
    	String subject = request.getParameter("subject");
    	String content = request.getParameter("content");
    	String email = request.getParameter("email");
    	String query;
    	String id = null;
    	String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		int num=0;
    //	Class.forName("com.mysql.jdbc.Driver");
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try{
    		HttpSession session = request.getSession();
    		//세션을 읽어 로그인 상태가 아니면 로그인 창으로 이동
        	id = (String) session.getAttribute("id");
    		if( id == null){
    			return "loginerror.jsp";
    		}
    		Class.forName(jdbc_driver);
    		//String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
    		          // +
						//		"useUnicode=true&characterEncoding = euc-kr";
			String dbUser = "root";
			String dbPass = "";
    		
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);				
			//String query = "select * COALESCE(max(num),0) from board where num = '"+num+"';";					
		
			
      		pstmt = conn.prepareStatement(      
      				
    				"insert into board values(NULL,?,?,?,?,now(),0)");
    				pstmt.setString(1, id);
    				pstmt.setString(2, subject);
    				pstmt.setString(3, content);
    				pstmt.setString(4, email);
    				//쿼리 실행
    				pstmt.executeUpdate();
    				
    	} catch(SQLException ex){
			
		}finally{
    		if(pstmt != null) try{pstmt.close();} catch(SQLException ex){}
    		if(conn != null) try{conn.close();} catch(SQLException ex){}
    		}
    	
 
        return "write.jsp";
 
    }
 
}