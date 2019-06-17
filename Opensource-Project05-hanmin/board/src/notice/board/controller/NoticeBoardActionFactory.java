package notice.board.controller;

import notice.board.controller.action.NoticeAction;
import notice.board.controller.action.NoticeBoardDeleteAction;
import notice.board.controller.action.NoticeBoardListAction;
import notice.board.controller.action.NoticeBoardUpdateAction;
import notice.board.controller.action.NoticeBoardUpdateFormAction;
import notice.board.controller.action.NoticeBoardViewAction;
import notice.board.controller.action.NoticeBoardWriteAction;
import notice.board.controller.action.NoticeBoardWriteFormAction;

public class NoticeBoardActionFactory {
	private NoticeBoardActionFactory() {
	}

	private static NoticeBoardActionFactory noticefactory = new NoticeBoardActionFactory();

	public static NoticeBoardActionFactory getInstance() {
		return noticefactory;
	}

	public NoticeAction getAction(String command) {

		System.out.println("NoticeActionFactory : " + command);

		NoticeAction action = null;

		if (command.equals("notice_board_list")) {
			action = new NoticeBoardListAction();
		} else if (command.equals("notice_board_write_form")) {
			action = new NoticeBoardWriteFormAction();
		} else if (command.equals("notice_board_write")) {
			action = new NoticeBoardWriteAction();
		} else if (command.equals("notice_board_view")) {
			action = new NoticeBoardViewAction();
		} else if (command.equals("notice_board_update_form")) {
			action = new NoticeBoardUpdateFormAction();
		} else if (command.equals("notice_board_update")) {
			action = new NoticeBoardUpdateAction();
		} else if (command.equals("notice_board_delete")) {
			action = new NoticeBoardDeleteAction();
		}
		return action;

	}
}
