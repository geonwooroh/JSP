package com.codingbox.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.action.Action;
import com.codingbox.action.ActionForward;
import com.codingbox.web.board.dao.BoardDAO;
import com.codingbox.web.board.dao.BoardDTO;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		int totalcnt = bdao.getBoardCnt();
		
		//현재 페이지 넘겨받기
		String temp = request.getParameter("page");
		int page = 0;
		page = temp == null ? 1: Integer.parseInt(temp);
//		if(temp == null) {
//			page =1;
//		}else {
//			page = Integer.parseInt(temp);
//		}
		
		int pageSize = 10;
		int endRow = page * 10;//1 페이지 : 10, 4페이지: 40
		int startRow = endRow - 9; //1페이지 :1, 4페이지 : 31
		
		//[1][2]..[10] :1 ,[11],[12]...[20]:[11]
		int startPage = (page -1)/pageSize*pageSize+1;
		//[1][2]..[10] :1 ,[11],[12]...[20]:[21]
		int endPage = startPage + pageSize -1;
		int totalPage = (totalcnt -1 )/pageSize +1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		request.setAttribute("totalcnt", totalcnt);
		request.setAttribute("boardList", bdao.getBoardList(startRow,endRow));
		forward.setRedirect(false);
		forward.setPath("/board/boardList.jsp");
		
		
		return forward;
	}

}
