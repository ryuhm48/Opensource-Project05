package Problem;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Problem.ProblemDAO;
import Problem.AnswerDAO;
import Problem.AnswerDTO;


public class AnswerListCommand implements ProblemCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int problemNum = Integer.parseInt(request.getParameter("problemNum"));
		String answerCode = request.getParameter("source");
		String ansOutput = request.getParameter("sourceOutput");
		String language = request.getParameter("answerLanguage");
		String writerName = request.getParameter("writerName");
		Boolean problemCorrection = false;
		AnswerDAO ansdao = new AnswerDAO();		
		AnswerDTO answer = new AnswerDTO();
		ProblemDAO prodao = new ProblemDAO();
		ProblemDTO problem = new ProblemDTO();
		problem = prodao.getProblemDTO(problemNum);
		int studyNum = problem.getStudyNum();
		int answerNum = ansdao.getTableSize() + 1;
		String output = problem.getProblemOutput();
		if(output.equals(ansOutput))
			problemCorrection = true;
		answer.setAnswerNum(answerNum);
		answer.setProblemNum1(problemNum);
		answer.setAnswerCode(answerCode);
		answer.setAnswerLanguage(language);
		answer.setWriterName(writerName);
		answer.setProblemCorrection(problemCorrection);
		ansdao.insert(answer);
		ArrayList<AnswerDTO> list = ansdao.answerList(problemNum);
		request.setAttribute("list", list);
	}

}
