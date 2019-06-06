package Problem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProblemWriteCommand implements ProblemCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
		int problemNum2 = Integer.parseInt(request.getParameter("problemNum2"));
		String problemName = request.getParameter("problemName");
		String problemLanguage = request.getParameter("problemLanguage");
		String writerName = request.getParameter("writerName");
		String problemContent = request.getParameter("problemContent");
		ProblemDAO dao = new ProblemDAO();
		
		dao.write(studyNum, problemNum2, problemName, problemLanguage, writerName, problemContent);
	}

}
