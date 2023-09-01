package com.codingbox.web.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.web.servlet.Do1;
import com.codingbox.web.servlet.Do2;
import com.codingbox.web.servlet.Do3;
import com.codingbox.web.user.action.ActionForward;

@WebServlet("*.us")
public class UserFrontController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, 
		HttpServletResponse resp) throws ServletException, IOException {
	doProcess(req,resp);
}
@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
	doProcess(req,resp);
	}
protected void doProcess(HttpServletRequest request,
		HttpServletResponse response)throws ServletException, IOException {
	String requestURI = request.getRequestURI();
	String responseURI = null;
	ActionForward forward = null;
	
	if(requestURI.equals("/user/UserJoin.us")) {
		System.out.println("프론트 도착");
		forward = new UserjoinAction().excute(request, response);
	}else if(requestURI.equals("/user/UserLogin.us")){
		forward = new ActionForward(false,"/user/loginview.jsp");
	}else if(requestURI.equals("/user/UserLoginOK.us")) {
		System.out.println("front도착");
		forward = new UserLoginOKAction().excute(request, response);
	}
	

	//일괄처리
	if(forward != null) {
		if(forward.isRedirect()) {
			//redirect방식으로 페이지 이동
			response.sendRedirect(forward.getPath());
		}else {
			//forward방식으로 페이지 이동
			RequestDispatcher disp = request.getRequestDispatcher(forward.getPath());
			disp.forward(request, response);
		}
	}
 }
}













