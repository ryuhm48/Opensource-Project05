/**
 * ����Ʈ�� �����ֱ� ���� Action
 */
package com.board.action;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.beans.board;
import com.board.controller.CommandAction;
 
public class StudyListAction implements CommandAction {
	
    public String requestPro(HttpServletRequest request,
 
    HttpServletResponse response) throws Throwable {
 
    	Class.forName("com.mysql.jdbc.Driver");    	    
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;    	
    	
    	//�˻��ɼǰ� �˻����� �޾� ������ ����
    	String opt = request.getParameter("opt");
    	String condition = request.getParameter("condition");
    	
    	try {
    		HttpSession session = request.getSession();
    		//�α����� �Ǿ����� ������ �����˾��� �α���ȭ������ �̵�    		    		
    		String id = (String) session.getAttribute("id");    		
    		if(id == null){    			
    			return "loginerror.jsp";
    		}
    		
    		String jdbc_driver = "com.mysql.jdbc.Driver";
    		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

//    		String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
    		           // +
    					//		"useUnicode=true&characterEncoding = euc-kr";
    		String dbUser = "root";
    		String dbPass = "";
    		String query = null; 
    		if(opt == null){    			
    			query = "select * from studydb order by num";
    		}else if(opt.equals("0")){    			
    			query = "select * from studydb where name like '%"+condition+"%' order by num";        		
    		}else if(opt.equals("1")){    			
    			query = "select * from studydb where administor like '%"+condition+"%' order by num";        		
    		}else if(opt.equals("2")){    			
    			query = "select * from studydb where inform like '%"+condition+"%' order by num";        		
    		}
    		conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
    		
    		stmt = conn.createStatement();    		
    		rs = stmt.executeQuery(query);    		
	
    		
    		ArrayList<board> studyList = new ArrayList<board>();    		
    		
    		while(rs.next()){
    			board study = new board();
    			study.setNum(rs.getInt("num"));
    			study.setName(rs.getString("name"));
    			study.setInform(rs.getString("inform"));
    			study.setAdministor(rs.getString("administor"));
    			study.setMember(rs.getString("member"));
    			studyList.add(study);
    		}
    		request.setAttribute("studyList",studyList);
    		 
    	} catch(SQLException ex){
    		
    	} finally{
    		if(rs != null) try{rs.close();} catch(SQLException ex){}
    		if(stmt != null) try{stmt.close();} catch(SQLException ex) {}
    		
    		if(conn != null) try{conn.close();} catch(SQLException ex) {}
    	}

        return "personalstudylist.jsp";
 
    }
 
}