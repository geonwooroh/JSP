package com.codingbox.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.action.Action;
import com.codingbox.action.ActionForward;
import com.codingbox.web.board.dao.BoardDAO;
import com.codingbox.web.board.dao.ReplyDTO;

public class DeleteReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		int replynum = Integer.parseInt(request.getParameter("replynum"));
		String replycontent = request.getParameter("replycontent");
		
		String boardnum = request.getParameter("boardnum");
		
		if(bdao.deleteReply(replynum, replycontent)){
			System.out.println("222");
			//댓글 수정 성공
			forward.setRedirect(true);
			forward.setPath("/board/BoardView.bo?boardnum="+boardnum);
			
		}else {
			forward.setRedirect(false);
			forward.setPath("/board/DeleteReply.bo");
		}
		
		return forward;
	}

}
