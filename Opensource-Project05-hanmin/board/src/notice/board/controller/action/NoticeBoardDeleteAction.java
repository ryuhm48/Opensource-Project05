package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardDeleteAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		board vo = new board();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		System.out.println("vo : "+vo.getNum());

		NoticeBoardDAO.getInstance().deleteBoard(vo);
		
	//������ ��猷���硫� , ��濡��몃�� 嫄곗��� 由ъ�ㅽ�몃�� 蹂댁� 留�怨�
	//諛�濡� 由ъ�ㅽ�� ��鍮��ㅻ�� 遺��щ낫��!
	//#90] boardList.jsp濡�媛���
		new NoticeBoardListAction().execute(request, response);
		
	}

}
