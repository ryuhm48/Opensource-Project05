package Problem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProblemCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
