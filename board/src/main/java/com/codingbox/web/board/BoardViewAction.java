package com.codingbox.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.action.ActionForward;
import com.codingbox.web.board.dao.BoardDAO;

public class BoardViewAction extends HttpServlet{


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		System.out.println(request.getParameter("boardnum"));
		
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		
		
		//게시글 조회수 update
		bdao.updateReadCount(boardnum);
		
		//댓글 조회
		//dao,xml : getReplys
		request.setAttribute("replylist",bdao.getReplys(boardnum));
		request.setAttribute("board",bdao.getDetail(boardnum));
		forward.setRedirect(false);
		forward.setPath("/board/boardview.jsp");
		
		return forward;
	}
}
