package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardWriteAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		board vo = new board();
		vo.setId(request.getParameter("id"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
//		vo.setBoardnum(request.getParameter("boardnum"));

		NoticeBoardDAO.getInstance().insertBoard(vo);
		
		
		new NoticeBoardListAction().execute(request, response);
		
		
	}

}
