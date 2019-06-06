package Problem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Problem.ProblemDAO;
import Problem.ProblemDTO;

public class AnswerSubmitCommand implements ProblemCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int problemNum = Integer.parseInt(request.getParameter("problemNum"));
		ProblemDAO problemdao = new ProblemDAO();
		ProblemDTO problem = problemdao.getProblem(problemNum);
		request.setAttribute("problem", problem);
	}

}
