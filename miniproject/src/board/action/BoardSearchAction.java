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

public class BoardSearchAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String keyword = request.getParameter("search");
		int pg = Integer.parseInt(request.getParameter("pg"));
		String option = request.getParameter("searchOption");
		
		System.out.println(keyword+"/"+pg+"/"+option);
		int endNum = pg * 5;
		int startNum = endNum - 4;

		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", String.valueOf(startNum));
		map.put("endNum", String.valueOf(endNum));
		map.put("keyword", keyword);
		map.put("option",option);

		BoardDAO boardDAO = BoardDAO.getInstance();

		int totalA = boardDAO.getSearch(map);
		System.out.println("total : "+totalA);
		int totalP = ((totalA + 1) / 5);
		
		List<BoardDTO> list = boardDAO.boardSearchList(map);

		System.out.println("list Size : "+list.size());
		BoardPaging boardPaging = new BoardPaging();

		// ∆‰¿Ã¬° √≥∏Æ
		int total = boardDAO.getSearch(map);
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(total);
		boardPaging.setPageBlock(3);
		boardPaging.makeSearchPagingHTML(keyword,option);

		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("keyword", keyword);
		request.setAttribute("option", option);
		request.setAttribute("display", "/board/boardList.jsp");

		return "/main/index.jsp";
	}
}