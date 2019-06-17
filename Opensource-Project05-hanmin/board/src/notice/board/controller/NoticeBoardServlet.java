package notice.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.board.controller.action.NoticeAction;


@WebServlet("/NoticeBoardServlet")
public class NoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������由ы�⑦�� -而ㅻ㎤��
		// /insert /... �대�고�⑦��
		
		//#2]index.jsp ���� ����.(泥�.. 紐⑸���蹂댁�ъ�)	- board_list
		//#15]board_write_form�� �ㅺ� 湲��곌린 ���� ����.
		//#26]board_write 5媛� ��紐⑹�� request�� �댁������.
		//#39]board_view 湲� ��嫄� 蹂닿린 ���� ����.
		//#52]��諛��ㅽ�щ┰�� -�������� ���� . board_check_pass_form
		//#61]���� - board_check_pass
		//#71]����- form ���� ���� 湲�踰��몃�� �ㅺ� ����
		//#82]������猷� �� db�� �곕�� 媛���
		String command = request.getParameter("command");
		System.out.println("command : " +command);
		
		NoticeBoardActionFactory af = NoticeBoardActionFactory.getInstance();

		//#3] ��鍮��� �대���� 留��ㅼ�� �ㅼ��!
		//#16] 湲��곌린 ��鍮��� 留��ㅼ�� �ㅼ��
		//#27] 湲��곌린 db�� ��鍮��ㅻ�� 遺��ъ�ㅼ��
		//#40] 湲� ��嫄대낫湲�
		//#53] 湲� ���� - ��鍮��� 留��ㅺ린
		//#62] ����- 鍮�踰� 泥댄��
		//#72] ���� - 酉고���댁�蹂닿린
		//#83]������猷� db ����
		NoticeAction action = af.getAction(command);
		
		if(action!=null){
			//#6] BoardListACtion �� execute���ш���
			//#19]BoardWriteFormAction�� execute ���� 媛���
			//#30] write , db ���ш���
			//#42] view , ���댁�蹂대�ш���
			//#56] �ㅽ�щ┰�� 李쎌�� 酉고���댁� �ｌ�댁＜�� 媛���
			action.execute(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
