package Problem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import Problem.ProblemDAO;
import Problem.ProblemDTO;

public class ProblemListCommand implements ProblemCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProblemDAO dao = new ProblemDAO();
		int studyNum = 1;
		ArrayList<ProblemDTO> list = dao.problemList(studyNum);
		request.setAttribute("list", list);
	}

}