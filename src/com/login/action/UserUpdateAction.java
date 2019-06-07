package com.login.action;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.board.controller.CommandAction;
import com.login.beans.UserBean;

public class UserUpdateAction implements CommandAction{

	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		    	
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection conn = null;    	
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	
    	try{
    		HttpSession session = request.getSession();
    		String userId = (String) session.getAttribute("userId");
    		if(userId == null) {
    			return "loginerror.jsp";
    		}
    		String jdbcDriver = "jdbc:mysql://localhost:3306/BBS?characterEncoding=UTF-8&serverTimezone=UTC"; 
    		String dbUser = "root";
    		String dbPass = "1234";
    		String query = null;
    		
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);			
			stmt = conn.createStatement();
	
			rs = stmt.executeQuery(query);

			ArrayList<UserBean> userList = new ArrayList<UserBean>();
			

			while(rs.next()){
				UserBean user = new UserBean();
				user.setUserId(rs.getString("userId"));
				user.setGender(rs.getString("gender"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				userList.add(user);
			}			
			request.setAttribute("userList", userList);
    	} catch(SQLException ex){

    	}finally{
    		if(stmt != null) try{stmt.close();} catch(SQLException ex){}
    		if(conn != null) try{conn.close();} catch(SQLException ex){}
    		if(rs != null) try{rs.close();} catch(SQLException ex){}
    		}    	       	
    	return "UserUpdateForm.jsp";
	}
	
	
}
