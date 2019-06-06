package com.login.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class UserUpdatedo implements CommandAction{
	 public String requestPro(HttpServletRequest request,
    		 
			    HttpServletResponse response) throws Throwable {
			    	
			    	request.setCharacterEncoding("UTF-8");
			    	    	
			    	String pwd = request.getParameter("pwd");
			    	String name = request.getParameter("name");
			    	String gender = request.getParameter("gender");
			    	String email = request.getParameter("email");
			    	String userId = request.getParameter("userId");
			    	
			    	Class.forName("com.mysql.jdbc.Driver");
			    	
			    	//데이터 베이스 연결 관련 변수 선언
			    	Connection conn = null;
			    	PreparedStatement pstmt = null;    	
			    	
			    	try{ 		
			    		 
			    		String jdbcDriver = "jdbc:mysql://localhost:3306/BBS?characterEncoding=UTF-8&serverTimezone=UTC"; 
			    	
						String dbUser = "root";
						String dbPass = "1234";
			    		
						//데이터베이스에 연결
						conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			    		
						//각 ?에 해당하는 변수들을 넣어준다.
			      		pstmt = conn.prepareStatement(
			    				"update user set pwd=?, name=?, gender=?, email=? where userId=?;");
			    				pstmt.setString(1, pwd);
			    				pstmt.setString(2, name);
			    				pstmt.setString(3, gender);
			    				pstmt.setString(4, email);
			    				pstmt.setString(5, userId);
			    		pstmt.executeUpdate();
			    	HttpSession session = request.getSession();
			    	session.setAttribute("userId", userId);
			    	}catch(SQLException ex){
			    	}finally {
			    	
			    	if(pstmt !=null)try {pstmt.close();} catch(SQLException ex) {}
			    	if(conn != null)try {conn.close(); } catch(SQLException ex) {}
			    	}
			  	return "LoginState.jsp";
	 	}
}