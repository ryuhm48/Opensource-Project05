package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardUpdateAction implements NoticeAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� �댁�⑹�� request�� �ㅼ�댁����.
		//vo�� �댁���� updateBoard()�� �ｌ�댁＜��
			System.out.println("test");
			board vo = new board();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setId(request.getParameter("id"));
			vo.setSubject(request.getParameter("subject"));
			vo.setContent(request.getParameter("content"));
			
			System.out.println("vo : "+vo);
			//#87]db�� �곕�ш���
			NoticeBoardDAO.getInstance().updateBoard(vo);
			
		//������ ��猷���硫� , ��濡��몃�� 嫄곗��� 由ъ�ㅽ�몃�� 蹂댁� 留�怨�
		//諛�濡� 由ъ�ㅽ�� ��鍮��ㅻ�� 遺��щ낫��!
		//#90] boardList.jsp濡�媛���
			new NoticeBoardListAction().execute(request, response);
	}

}
