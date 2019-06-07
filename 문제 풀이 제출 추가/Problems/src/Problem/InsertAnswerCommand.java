package Problem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Problem.ProblemDAO;
import Problem.AnswerDAO;
import Problem.AnswerDTO;


public class InsertAnswerCommand implements ProblemCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String problemNum1 = request.getParameter("problemNum1");
		int problemNum = Integer.parseInt(problemNum1);
		String answerCode = request.getParameter("source");
		String ansOutput = request.getParameter("sourceOutput");
		int language = Integer.parseInt(request.getParameter("answerLanguage"));
		String answerLanguage = null;
		String writerName = request.getParameter("writerName");
		Boolean problemCorrection = false;
		AnswerDAO ansdao = new AnswerDAO();		
		AnswerDTO answer = new AnswerDTO();
		ProblemDAO prodao = new ProblemDAO();
		ProblemDTO problem = new ProblemDTO();
		problem = prodao.getProblemDTO(problemNum);
		switch(language)
		{
		case 1:
			answerLanguage = "Bash (4.4)";
			break;
		case 2:
			answerLanguage = "Bash (4.0)";
			break;
		case 3:
			answerLanguage = "Basic (fbc 1.05.0)";
			break;
		case 4:
			answerLanguage = "C (gcc 7.2.0)";
			break;
		case 5:
			answerLanguage = "C (gcc 6.4.0)";
			break;
		case 6:
			answerLanguage = "C (gcc 6.3.0)";
			break;
		case 7:
			answerLanguage = "C (gcc 5.4.0)";
			break;
		case 8:
			answerLanguage = "C (gcc 4.9.4)";
			break;
		case 9:
			answerLanguage = "C (gcc 4.8.5)";
			break;
		case 10:
			answerLanguage = "C++ (g++ 7.2.0)";
			break;
		case 11:
			answerLanguage = "C++ (g++ 6.4.0)";
			break;
		case 12:
			answerLanguage = "C++ (g++ 6.3.0)";
			break;
		case 13:
			answerLanguage = "C++ (g++ 5.4.0)";
			break;
		case 14:
			answerLanguage = "C++ (g++ 4.9.4)";
			break;
		case 15:
			answerLanguage = "C++ (g++ 4.8.5)";
			break;
		case 16:
			answerLanguage = "C# (mono 5.4.0.167)";
			break;
		case 17:
			answerLanguage = "C# (mono 5.2.0.224)";
			break;
		case 18:
			answerLanguage = "Clojure (1.8.0)";
			break;
		case 19:
			answerLanguage = "Crystal (0.23.1)";
			break;
		case 20:
			answerLanguage = "Elixir (1.5.1)";
			break;
		case 21:
			answerLanguage = "Erlang (OTP 20.0)";
			break;
		case 22:
			answerLanguage = "Go (1.9)";
			break;
		case 23:
			answerLanguage = "Haskell (ghc 8.2.1)";
			break;
		case 24:
			answerLanguage = "Haskell (ghc 8.0.2)";
			break;
		case 25:
			answerLanguage = "Insect (5.0.0)";
			break;
		case 26:
			answerLanguage = "Java (OpenJDK 9 with Eclipse OpenJ9)";
			break;
		case 27:
			answerLanguage = "Java (OpenJDK 8)";
			break;
		case 28:
			answerLanguage = "Java (OpenJDK 7)";
			break;
		case 29:
			answerLanguage = "JavaScript (nodejs 8.5.0)";
			break;
		case 30:
			answerLanguage = "JavaScript (nodejs 7.10.1)";
			break;
		case 31:
			answerLanguage = "OCaml (4.05.0)";
			break;
		case 32:
			answerLanguage = "Octave (4.2.0)";
			break;
		case 33:
			answerLanguage = "Pascal (fpc 3.0.0)";
			break;
		case 34:
			answerLanguage = "Python (3.6.0)";
			break;
		case 35:
			answerLanguage = "Python (3.5.3)";
			break;
		case 36:
			answerLanguage = "Python (2.7.9)";
			break;
		case 37:
			answerLanguage = "Python (2.6.9)";
			break;
		case 38:
			answerLanguage = "Ruby (2.4.0)";
			break;
		case 39:
			answerLanguage = "Ruby (2.3.3)";
			break;
		case 40:
			answerLanguage = "Ruby (2.2.6)";
			break;
		case 41:
			answerLanguage = "Ruby (2.1.9)";
			break;
		case 42:
			answerLanguage = "Rust (1.20.0)";
			break;
		case 43:
			answerLanguage = "Text (plain text)";
			break;
		}
		int studyNum = problem.getStudyNum();
		String output = problem.getProblemOutput();
		if(output.equals(ansOutput))
			problemCorrection = true;
		answer.setProblemNum1(problemNum);
		answer.setAnswerCode(answerCode);
		answer.setAnswerLanguage(answerLanguage);
		answer.setWriterName(writerName);
		answer.setProblemCorrection(problemCorrection);
		ansdao.insert(answer);
		request.setAttribute("problemNum", problemNum);
	}

}
