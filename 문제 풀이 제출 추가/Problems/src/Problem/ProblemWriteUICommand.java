package Problem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import Problem.ProblemDAO;
import Problem.ProblemDTO;

public class ProblemWriteUICommand implements ProblemCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
		request.setAttribute("studyNum", studyNum);
	}

}