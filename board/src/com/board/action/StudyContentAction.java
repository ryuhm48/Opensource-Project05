/**
 * �Խ��� ������ �����ִ� Action
 */
package com.board.action;
 
import java.sql.*;
import java.util.ArrayList;
 


import javax.servlet.http.HttpServletRequest;
 
import javax.servlet.http.HttpServletResponse;
 
import javax.servlet.http.HttpSession;

import com.board.beans.board;
 
import com.board.controller.CommandAction;
 
public class StudyContentAction implements CommandAction {
	
    public String requestPro(HttpServletRequest request,
 
    HttpServletResponse response) throws Throwable {
 
    	Class.forName("com.mysql.jdbc.Driver");
    	//��ȣ�� �Է¹޾ƿ� ������ ����
    	int num = Integer.parseInt(request.getParameter("num"));
    	Connection conn = null;
    	Statement stmt = null;    	
    	ResultSet rs = null;   
    	
    	//��ȸ�� ������ ���� ���� ����
    	int score = 0;
    	
    	try {
    		//���� Ȯ���� �α��λ��°� �ƴϸ� �α���â ȣ��
    		HttpSession session = request.getSession();
    		String id = (String) session.getAttribute("id");
    		if(id == null){    			
    			return "loginerror.jsp";
    		}
    		
    		String jdbc_driver = "com.mysql.jdbc.Driver";
    		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

    		//String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
    		
    			//	+
    			//				"useUnicode=true&characterEncoding = euc-kr";
    		String dbUser = "root";
    		String dbPass = "";
    		
    		String query = "select * from studydb where num = "+num;
    		
    		conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
    		
    		stmt = conn.createStatement();    		
    		rs = stmt.executeQuery(query);    		
    		
    		//��ȸ�� ����Ʈ�� �޾ƿ�
    		ArrayList<board> articleList = new ArrayList<board>();
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
    		
    		//��ȸ�� ������Ʈ
    		//String query2 =  "UPDATE board SET score='" + score +    						
					//"' WHERE num=" + num;    		
    		//stmt.executeUpdate(query2); 
    		
    	} catch(SQLException ex){
    		
    	} finally{
    		if(rs != null) try{rs.close();} catch(SQLException ex){}
    		if(stmt != null) try{stmt.close();} catch(SQLException ex) {}
    		
    		if(conn != null) try{conn.close();} catch(SQLException ex) {}
    	}
 
        return "personalstudycontent.jsp";
 
    }
 
}