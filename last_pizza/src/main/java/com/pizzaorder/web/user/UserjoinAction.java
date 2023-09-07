package com.pizzaorder.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizzaorder.web.user.action.Action;
import com.pizzaorder.web.user.action.ActionForward;
import com.pizzaorder.web.user.dao.UserDAO;
import com.pizzaorder.web.user.dao.UserDTO;

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
		udto.setName(request.getParameter("name"));
		udto.setTell(request.getParameter("tell"));
		udto.setZipcode(request.getParameter("zipcode"));
		udto.setAddr(request.getParameter("addr"));
		udto.setExtraAddr(request.getParameter("extraAddr"));
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
