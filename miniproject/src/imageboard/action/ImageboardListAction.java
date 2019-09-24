package imageboard.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;

public class ImageboardListAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
				
		int endNum = pg * 3;
		int startNum = endNum - 2;

		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		
		int totalA = imageboardDAO.getTotalA();
		int totalP = ((totalA + 1) / 5);

		List<ImageboardDTO> list = imageboardDAO.boardList(map);
		
		ImageboardPaging boardPaging = new ImageboardPaging();
		
		//∆‰¿Ã¬° √≥∏Æ
		int total = imageboardDAO.getTotalA();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageSize(3);
		boardPaging.setTotalA(totalA);
		boardPaging.setPageBlock(3);
		boardPaging.makePagingHTML();
		
		
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("boardPaging", boardPaging);
		
		request.setAttribute("display", "/imageboard/imageboardList.jsp");
		
		return "/main/index.jsp";
	}
}
