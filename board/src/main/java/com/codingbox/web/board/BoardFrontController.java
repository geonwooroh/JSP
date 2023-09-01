package com.codingbox.web.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.codingbox.action.ActionForward;


@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet{
	
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
		
		
		// 작성
		switch (requestURI) {
		case "/board/BoardWrite.bo": 
			forward = new ActionForward(true,"/board/boardwrite.jsp");
			break;
		case "/board/BoardWriteOK.bo":
			forward = new BoardWriteOKAction().execute(request,response);
			break;
		case "/board/BoardList.bo": 
			forward = new BoardListAction().execute(request,response);
			break;
		case "/board/BoardView.bo": 
//			forward = new ActionForward(true,"/board/boardview.jsp");
//			BoardViewAction.java
//			dao,getDetail
//			xml,getdetail
			forward = new BoardViewAction().execute(request,response);
			break;
			//forward = new ActionForward(true,"/board/boardList.jsp");
			//BoardListAction().execute()
			//dao: 조회, getBoardList()
			//xml: 쿼리, getBoardList()
		case "/board/AddReply.bo":
			forward = new AddReplyAction().execute(request, response);
			//dao,addReply
			//xml, addReply
			break;	
		case "/board/UpdateReply.bo":
			forward = new UpdateReplyAction().execute(request, response);
			break;
		case "/board/DeleteReply.bo":
			System.out.println("111");
			forward = new DeleteReplyAction().execute(request, response);
			break;
		}
		
								/////board/BoardWriteOK.bo
								//insert,BoardWriteOKAction.java
								//DAO : insertBoard()
								//board.xml: insertBoard
								//
					
		
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
