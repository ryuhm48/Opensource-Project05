package com.board.controller;
 
import java.io.*; 
import java.util.*; 

import javax.servlet.*; 
import javax.servlet.http.*;
 
import com.login.beans.UserBean;
import com.login.service.UserService;
@SuppressWarnings("serial")
public class ControllerAction extends HttpServlet {
 
	private UserService service;
	public ControllerAction() {
		service = new UserService();
	}
    private Map<String, Object> commandMap = new HashMap<String, Object>(); 
 
    public void init(ServletConfig config) throws ServletException {
 
        // Common properties 
        loadProperties("com/board/properties/Command");
 
    }
 
    // properties 연결
    private void loadProperties(String path) {
 
        ResourceBundle rbHome = ResourceBundle.getBundle(path);
 
        Enumeration<String> actionEnumHome = rbHome.getKeys();
 
        while (actionEnumHome.hasMoreElements())
 
        {
 
            String command = actionEnumHome.nextElement();
            ;
 
            String className = rbHome.getString(command);
 
            try {
 
                Class<?> commandClass = Class.forName(className);
 
                Object commandInstance = commandClass.newInstance(); 
                
                commandMap.put(command, commandInstance); 
 
            } catch (ClassNotFoundException e) {
 
                continue; // error
 
                // throw new ServletException(e);
 
            } catch (InstantiationException e) {
 
                e.printStackTrace();
 
            } catch (IllegalAccessException e) {
 
                e.printStackTrace();
 
            }
 
        }
 
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        requestPro(request, response); 
 
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        requestPro(request, response);
 
    }
 

 
    private void requestPro(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        String view = null;
 
        CommandAction com = null;
        
        String contextPath = request.getContentType();
        String reqUri = request.getRequestURI();
 
      //회원정보수정
        if(reqUri.equals(contextPath + "/UserUpdateForm.do"))
            {
                
                String userId = request.getParameter("userId");
                UserBean user = service.getUserBean(userId); //id에 해당하는 회원정보셋트 데이터를 가지고
                request.setAttribute("user", user);
                request.getRequestDispatcher("UserUpdateForm.jsp") //memberUpdateForm.jsp로 포워드
                .forward(request, response);
            }
//-----------------------------------------------------------------------------------------
 
//           
//            회원정보들을 수정해달라는 요청
//            파라미터 : 회원들의 모든정보
//            가저갈데이터는 X
//            main요청으로 redirect
            else if(reqUri.equals(contextPath + "/UserUpdatedo.do"))
            {
            String userId = request.getParameter("userId");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            service.update(userId, pwd, name, email);
            response.sendRedirect("LoginState.jsp");
            return;
            }
//-----------------------------------------------------------------------------------------
//            메인 페이지에서 전체회원보기 버튼을 누르면 발생요청
//            memberList : 모든 회원정보를 보여달라는 요청
//            파라미터 X , 가져갈 데이터 모든 회원들의 정보
//            이동할 페이지 : memberList.jsp로 포워드
            else if(reqUri.equals(contextPath + "/userList.do"))
            {
                request.setAttribute("userList", service.getUserList());
                request.getRequestDispatcher("userList.jsp")
                .forward(request, response);
            }
        
        try {
 
            String command = request.getRequestURI();
 
            if (command.indexOf(request.getContextPath()) == 0) {
 
                command = command.substring(request.getContextPath().length());
 
            }
 
            com = (CommandAction) commandMap.get(command);
 
            if (com == null) {
 
                System.out.println("not found : " + command);
 
                return;
 
            }
 
            view = com.requestPro(request, response);
 
            if (view == null) {
 
                return;
 
            }
 
        } catch (Throwable e) {
 
            throw new ServletException(e);
 
        }
 
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
 
        dispatcher.forward(request, response);
 
    }
 
}