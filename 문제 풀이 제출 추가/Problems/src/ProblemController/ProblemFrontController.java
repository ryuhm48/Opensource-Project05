package ProblemController;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import Problem.ProblemCommand;
import Problem.ProblemListCommand;
import Problem.ProblemWriteCommand;
import Problem.ProblemWriteUICommand;
import Problem.AnswerSubmitCommand;

@WebServlet("*.do")
public class ProblemFrontController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		ProblemCommand command = null;
		String nextPage = null;
		
		String c = com.substring(com.lastIndexOf("/"), com.length());
		
		if(c.equals("/list.do")) {
			command = new ProblemListCommand();
			command.execute(request, response);
			nextPage = "ProblemList.jsp";
		}
		
		if(c.equals("/writeui.do")) {
			command = new ProblemWriteUICommand();
			command.execute(request, response);
			nextPage = "ProblemWrite.jsp";
		}
		
		if(c.equals("/write.do")) {
			command = new ProblemWriteCommand();
			command.execute(request,  response);
			nextPage = "list.do";
		}
		
		if(c.equals("/Answer.do")) {
			command = new AnswerSubmitCommand();
			command.execute(request, response);
			nextPage = "Answer.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}
}
