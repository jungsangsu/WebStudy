package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);

		BoardDAO boardDAO = new BoardDAO();
		
		int su = boardDAO.boardWrite(boardDTO);
		
		request.setAttribute("su", su);
		request.setAttribute("display", "/board/boardWrite.jsp");
		
		
		return "/main/index.jsp";
	}

}
