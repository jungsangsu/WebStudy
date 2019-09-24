package imageboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardViewAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		
//		HttpSession session = request.getSession();
//		if(!session.getAttribute("beforeSeq").equals(seq)){
//			boardDAO.boardHit(seq);
//			session.setAttribute("beforeSeq", seq);
//		}
		ImageboardDTO imageboardDTO = imageboardDAO.getImageboard(seq);
		
		request.setAttribute("imageboardDTO", imageboardDTO);
		request.setAttribute("pg", pg);
		request.setAttribute("display","/imageboard/imageboardView.jsp");
		
		
		
		return "/main/index.jsp";
	}
}