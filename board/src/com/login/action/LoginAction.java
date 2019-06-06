/**
 * 占싸깍옙占쏙옙 화占썽에占쏙옙 ID占쏙옙 PW 占쌉력쏙옙 占쏙옙占쏙옙풔占� Action
 */
package com.login.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class LoginAction implements CommandAction{

	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
    	String password = request.getParameter("password");    	
    	String jdbc_driver = "com.mysql.jdbc.Driver";
    	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

    	//Class.forName("com.mysql.jdbc.Driver");
    	HttpSession session = request.getSession();
    	Connection conn = null;    	
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try{
    		Class.forName(jdbc_driver);

    		//String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
    		         //+
					 //			"useUnicode=true&characterEncoding = euc-kr";
			String dbUser = "root";
			String dbPass = "";
    		
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);			
			stmt = conn.createStatement();
		
			String query = "select * from userdb where id = '"+id+"' and password = '"+password+"';";					
			rs = stmt.executeQuery(query);
			
			Boolean isLogin = false;
			
			while(rs.next()){
				isLogin = true;
			}			
			if(isLogin){				
				session.setAttribute("id", id);
				session.setAttribute("kind", 1);
			}else if(!isLogin && id != null){
				return "loginerror2.jsp";
			}
    	} catch(SQLException ex){

    	}finally{
    		if(stmt != null) try{stmt.close();} catch(SQLException ex){}
    		if(conn != null) try{conn.close();} catch(SQLException ex){}
    		if(rs != null) try{rs.close();} catch(SQLException ex){}
    		}    	       	
    	return "list.do";
	}
	
}
