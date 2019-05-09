/**
 * �Խ��� ���� �����ϴ� Action
 */
package com.board.action;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;
 
public class ModifyAction implements CommandAction {
 
    public String requestPro(HttpServletRequest request,
 
    HttpServletResponse response) throws Throwable {
    	
    	//Class.forName("com.mysql.jdbc.Driver");
    	String jdbc_driver = "com.mysql.jdbc.Driver";
    	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

    	//String url = "jdbc:mysql://127.0.0.1/jspdb";
    	String dbUser = "root";
    	String dbPass = "";
    	Connection conn = null;
    	Statement stmt = null;    	    	
    		try{
    			Class.forName(jdbc_driver);
    			HttpSession session = request.getSession();
            	
        		if(session.getAttribute("id") == null){
        			return "loginerror.jsp";
        		}
    			
    			request.setCharacterEncoding("euc-kr");
    			String num = request.getParameter("num");    			
    			String subject = request.getParameter("subject");
    			String content = request.getParameter("content");
    			
    			conn = DriverManager.getConnection(jdbc_url,dbUser,dbPass);    			    			    			
    					
    			stmt = conn.createStatement();
   			    			    		
    			String sql = "UPDATE board SET subject='" + subject + "' ,content='"+ content +    						
    						"' WHERE num=" + num;				
    			stmt.executeUpdate(sql);    			

    			stmt.close();
    			conn.close();    			
    		 
     } catch(SQLException e) {
    	System.out.println( e.toString() );
    } finally{    	
    	if(stmt != null) try{stmt.close();} catch(SQLException ex){}			
		if(conn != null) try{conn.close();} catch(SQLException ex){}
		}
    	
    	
        return "content.do";
 
    }
 
}