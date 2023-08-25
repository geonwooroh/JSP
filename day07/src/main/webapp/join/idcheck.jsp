<%@page import="com.codingbox.web.dto.TblMemberDTO"%>
<%@page import="com.codingbox.web.dao.TblMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
		
		String userid = request.getParameter("userid");
		//
		//TblMemberDAO에서 DB조회 후(check_Id(userid)),checkId->boolean
		//해당 아이디로 가입이 가능하면 OUT.PRINT("OK")
		//그렇지 않다면 out.print("not-ok")
		TblMemberDAO mdao = new TblMemberDAO();
		mdao.check_id(userid);
		if(!mdao.check_id(userid)){
			//회원가입 가능한 상태
			out.print("ok");
		}else{
			//회원가입 불가능한 상태
			out.print("not ok");
		}
		
	
	
%>
