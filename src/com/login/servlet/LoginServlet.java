package com.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.login.beans.UserBean;
import com.login.service.UserService;
 
public class LoginServlet extends HttpServlet {
    private UserService service;
    public LoginServlet(){
        service= new UserService();
    }
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(req,resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProc(req,resp);
    }
    
    protected void doProc(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String contextPath = req.getContextPath();
        String reqUri = req.getRequestURI();
//---------------------------------------------------------------------------------------        
//회원정보수정
        if(reqUri.equals(contextPath + "/UserUpdateForm.action"))
            {
                
                String userId = req.getParameter("userId");
                UserBean user = service.getUserBean(userId); //id에 해당하는 회원정보셋트 데이터를 가지고
                req.setAttribute("user", user);
                req.getRequestDispatcher("UserUpdateForm.jsp") //memberUpdateForm.jsp로 포워드
                .forward(req, resp);
            }
//-----------------------------------------------------------------------------------------
 
//           
//            회원정보들을 수정해달라는 요청
//            파라미터 : 회원들의 모든정보
//            가저갈데이터는 X
//            main요청으로 redirect
            else if(reqUri.equals(contextPath + "/UserUpdatedo.action"))
            {
            String userId = req.getParameter("userId");
            String pwd = req.getParameter("pwd");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            service.update(userId, pwd, name, email);
            resp.sendRedirect("UserUpdatedo.action");
            return;
            }
//-----------------------------------------------------------------------------------------
//            메인 페이지에서 전체회원보기 버튼을 누르면 발생요청
//            memberList : 모든 회원정보를 보여달라는 요청
//            파라미터 X , 가져갈 데이터 모든 회원들의 정보
//            이동할 페이지 : memberList.jsp로 포워드
            else if(reqUri.equals(contextPath + "/userList.action"))
            {
                req.setAttribute("userList", service.getUserList());
                req.getRequestDispatcher("userList.jsp")
                .forward(req, resp);
            }

            
        }
        
    }
