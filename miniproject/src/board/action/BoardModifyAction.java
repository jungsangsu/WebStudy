package board.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardModifyAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("subject", subject);
		map.put("content", content);
		map.put("seq", String.valueOf(seq));

		/* boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setSeq(seq);
		
		int su = boardDAO.update(boardDTO); */
		
		BoardDAO boardDAO = new BoardDAO();
		int su = boardDAO.updateMap(map);
		
		request.setAttribute("su", su);
		request.setAttribute("display", "/board/boardModify.jsp");
		
		
		return "/main/index.jsp";
	}
}
