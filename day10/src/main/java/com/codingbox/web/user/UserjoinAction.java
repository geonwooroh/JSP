package com.codingbox.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.web.user.action.Action;
import com.codingbox.web.user.action.ActionForward;
import com.codingbox.web.user.dao.UserDAO;
import com.codingbox.web.user.dao.UserDTO;

public class UserjoinAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, 
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		//DB연결, insert
		System.out.println("test222------------------");
		UserDAO udao = new UserDAO();
		System.out.println("test444------------------");

		//DTO
		UserDTO udto = new UserDTO();
		
		udto.setUserid(request.getParameter("userid"));
		udto.setUserpw(request.getParameter("userpw"));
		udto.setUsername(request.getParameter("username"));
		udto.setUserphone(request.getParameter("userphone"));
		udto.setUseraddr(request.getParameter("useraddr"));
		System.out.println("test333------------------");
		
		forward.setRedirect(true);
		System.out.println("test");
		if(udao.join(udto)) {
			//회원가입 성공
			forward.setPath("/user/loginview.jsp");
		}else {
			//회원가입 실패
			forward.setPath("/index.jsp");
			
		}
		return forward;
	}

}
