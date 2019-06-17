package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardUpdateFormAction implements NoticeAction{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println("update");
		NoticeBoardDAO dao = NoticeBoardDAO.getInstance();
		//#76]-������ �� 湲� 議고����瑜� 1 利�媛����ㅼ��
		//dao.updateReadCount(num); �닿굅��臾몄�� �����대�� 利�媛�����
		//#79]-議고����媛� 1利�媛��� db�댁�⑹�� 媛��몄�ㅼ��
		board vo = dao.selectOneBoard(num);
		
		request.setAttribute("notice_board", vo);
		
		request.getRequestDispatcher("/notice/noticeBoardUpdate.jsp").forward(request, response);
	}

}
