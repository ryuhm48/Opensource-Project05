package Problem;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Problem.AnswerDAO;
import Problem.AnswerDTO;
import Problem.ProblemDAO;

public class AnswerListCommand implements ProblemCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int problemNum = 0;
		int studyNum = 0;
		boolean b = false;
		Enumeration params;
		params = request.getParameterNames();
		while (params.hasMoreElements()){
		    if(((String)params.nextElement()).equals("problemNum"))
		    {
			    b = true;
			    problemNum = Integer.parseInt(request.getParameter("problemNum"));
			    break;
		    }
		}
		if(!b)
		{
			params = request.getAttributeNames();
			while (params.hasMoreElements()){
				if(((String)params.nextElement()).equals("problemNum"))
			    {
				    b = true;
				    problemNum = (int)request.getAttribute("problemNum");
				    break;
			    }
			}
		}
		AnswerDAO ansdao = new AnswerDAO();	
		ArrayList<AnswerDTO> list = ansdao.answerList(problemNum);
		ProblemDAO prodao = new ProblemDAO();
		studyNum = prodao.getStudyNum(problemNum);
		request.setAttribute("list", list);
		request.setAttribute("studyNum", studyNum);
	}

}
