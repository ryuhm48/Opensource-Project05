package com.problem.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class ProblemWriteForm implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {
		// 제목과 내용을 입력 받아 변수에 저장
		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
		request.setAttribute("studyNum", studyNum);
		System.out.println(studyNum);
		return "ProblemWrite.jsp";

	}

}
