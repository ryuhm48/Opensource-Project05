package com.login.action;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.naming.NamingException;

import com.board.controller.CommandAction;
import com.login.beans.UserBean;

public class LoginAction implements CommandAction{
	
	private Connection conn;
	private static String jdbcDriver = "jdbc:mysql://localhost:3306/BBS?characterEncoding=UTF-8&serverTimezone=UTC"; 
	private static String dbUser = "root";
	private static String dbPass = "1234";
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
    	String pwd = request.getParameter("pwd");    	
    	    	
    	Class.forName("com.mysql.jdbc.Driver");
    	HttpSession session = request.getSession();
    	Connection conn = null;    	
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try{
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
			stmt = conn.createStatement();
	
			String query = "select * from user where userId = '"+userId+"' and pwd = '"+pwd+"';";					

			rs = stmt.executeQuery(query);

			Boolean isLogin = false;

			while(rs.next()){
				isLogin = true;
			}			

			if(isLogin){				
				session.setAttribute("userId", userId);

			}else if(!isLogin && userId != null){
				return "loginerror2.jsp";
			}
    	} catch(SQLException ex){

    	}finally{
    		if(stmt != null) try{stmt.close();} catch(SQLException ex){}
    		if(conn != null) try{conn.close();} catch(SQLException ex){}
    		if(rs != null) try{rs.close();} catch(SQLException ex){}
    		}    	       	
    	return "LoginState.jsp";
	}
}
