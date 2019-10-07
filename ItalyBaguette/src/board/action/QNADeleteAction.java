package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class QNADeleteAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		BoardDAO boardDAO = BoardDAO.getInstance();
		
		BoardDTO boardDTO = boardDAO.getboard(seq); //ÇØ´ç±Û
		
		boardDAO.boardDelete(boardDTO);

		
		request.setAttribute("display", "/board/QNADelete.jsp");
		
		
		return "/main/index.jsp";
	}
}
