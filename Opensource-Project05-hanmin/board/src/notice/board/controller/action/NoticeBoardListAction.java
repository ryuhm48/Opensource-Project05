package notice.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardListAction implements NoticeAction{

	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "notice/noticeBoardList.jsp";
		List<board> list = NoticeBoardDAO.getInstance().selectAllBoards();
		
		request.setAttribute("noticeBoardList", list);
		System.out.println("list"+list);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
