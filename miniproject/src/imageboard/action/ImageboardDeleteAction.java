package imageboard.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;

public class ImageboardDeleteAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String list = request.getParameter("list");
				
		System.out.println(list);
		List<String> iList = Arrays.asList(list.split(","));
		
		for (String string : iList) {
			System.out.println(string);
		}
		

		ImageboardDAO boardDAO = ImageboardDAO.getInstance();
		
		boardDAO.boardDelete(iList);
		
		request.setAttribute("display", "/imageboard/imageboardDelete.jsp");
		
		return "/main/index.jsp";
	}
}
