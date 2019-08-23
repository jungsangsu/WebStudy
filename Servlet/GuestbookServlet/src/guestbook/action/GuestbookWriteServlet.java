package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

//@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String title = request.getParameter("title");
		String context = request.getParameter("context");

		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setTitle(title);
		guestbookDTO.setContext(context);

		GuestbookDAO memberDAO = GuestbookDAO.getInstance();
		int su = memberDAO.write(guestbookDTO);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		if (su > 0) {
			out.println("작성하신 글을 저장하였습니다.");
			out.println("<br></br>");
			out.println("<input type = 'button' value='글목록' onclick = location.href='GuestbookListServlet?pg=1'>");

		} else
			out.println("다시작성해주세엿");
		out.println("</body>");
		out.println("</html>");
	}

}
