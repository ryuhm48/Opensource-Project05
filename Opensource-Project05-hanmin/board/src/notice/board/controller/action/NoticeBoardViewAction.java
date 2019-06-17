package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import notice.board.dao.NoticeBoardDAO;

public class NoticeBoardViewAction implements NoticeAction{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");

		
		
		NoticeBoardDAO.getInstance().updateScore(num);
		//#44] 踰��몄�� �대�뱁���� 湲� ��嫄� 媛�吏��� 媛���
		 board vo = NoticeBoardDAO.getInstance().selectOneBoard(num);
		//#47] 湲� ��嫄� 媛�怨�����.	=>boardView.jsp濡�媛���
		request.setAttribute("notice_board", vo);
		request.getRequestDispatcher("notice/noticeBoardView.jsp").forward(request, response);
		

	}

}
