package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardReplyAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pg = request.getParameter("pg"); //원글 페이지
		int  pseq = Integer.parseInt(request.getParameter("pseq")); //원글번호
		
		HttpSession session = request.getSession();		
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);
		boardDTO.setPseq(pseq);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardReply(boardDTO);
		
		request.setAttribute("display", "/board/boardReply.jsp");
		request.setAttribute("pg", pg);
		
		return "/main/index.jsp";
	}

}
