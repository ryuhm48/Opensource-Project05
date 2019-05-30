package com.board.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
public class ReplyDeleteAction implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		    int num = Integer.parseInt(request.getParameter("num"));
	        
	        DAO dao = new DAO();
	        boolean result = dao.deleteDB(num);
	        
	        /*response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = null;
	        try {
	        	out = response.getWriter();
	        }
	        catch(Exception e){
	        	
	        }
	 
	         //???????¼ë? ??ê¸??? ????????ê²½ì?? 1?? ???¬í????.
	       if(result) out.println("1");
	        
	        out.close();*/
	}
}
