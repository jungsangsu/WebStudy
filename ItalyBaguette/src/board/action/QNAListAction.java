package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class QNAListAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
				
		int endNum = pg * 5;
		int startNum = endNum - 4;

		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		int totalA = boardDAO.getTotalA();
		int totalP = ((totalA + 1) / 5);

		List<BoardDTO> list = boardDAO.boardList(map);
		
		BoardPaging boardPaging = new BoardPaging();
		
		//∆‰¿Ã¬° √≥∏Æ
		int total = boardDAO.getTotalA();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(total);
		boardPaging.setPageBlock(3);
		boardPaging.makePagingHTML();
		
		
		
		
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("boardPaging", boardPaging);
		
		request.setAttribute("display", "/board/QNAList.jsp");
		
		return "/main/index.jsp";
	}
}
