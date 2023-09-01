package com.codingbox.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.action.Action;
import com.codingbox.action.ActionForward;
import com.codingbox.web.board.dao.BoardDAO;
import com.codingbox.web.board.dao.BoardDTO;


public class BoardWriteOKAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		BoardDTO board = new BoardDTO();
		
		board.setBoardtitle(request.getParameter("boardtitle"));
		board.setUsername(request.getParameter("username"));
		board.setBoardcontent(request.getParameter("boardcontent"));
		
		
		if(bdao.insertBoard(board)) {
			//성공
			forward.setPath("/board/BoardWrite.bo");
		}else {
			forward.setPath("/board/BoardWrite.bo");
		}
		forward.setRedirect(true);
		
		return forward;
	}

}
