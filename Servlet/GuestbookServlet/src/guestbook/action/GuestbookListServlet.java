package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

//@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pg = Integer.parseInt(request.getParameter("pg"));

		// 페이징 처리
		int endNum = pg * 2;
		int startNum = endNum - 1;

		ArrayList<GuestbookDTO> list;
		GuestbookDAO memberDAO = GuestbookDAO.getInstance();
		list = memberDAO.Select(startNum, endNum);

		int totalA = memberDAO.getTotalA();
		int totalP = (totalA + 1) / 2;

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");

		out.println("<head>");
		out.println("<style type='text/css'>");
		out.println("pre {overflow: auto; width: 100%; white-space: pre-line; word-break: break-all;}");
		out.println("#currentPaging {color: red; text-decoration: underline;}");
		out.println("#paging {color: black; text-decoration: none;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		if (list != null) {

			for (int i = 1; i <= totalP; i++) {
				if (i == pg) {
					out.println("[<a id=currentPaging href ='/GuestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i
							+ "</a>]");
				} else {
					out.println(
							"[<a id=Paging href ='/GuestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i + "</a>]");
				}

			}
			out.println("</br>");
			out.println("</br>");
			out.println("</br>");

			for (int i = 0; i < list.size(); i++) {
				out.println("<table border=\"1\" cellspacing=\"10\" cellpadding=\"10\">");
				out.println(
						"<tr><td width=\"70\" align=\"Center\">작성자</td><td>" + list.get(i).getName() + "</td></tr>");
				out.println(
						"<tr><td width=\"70\" align=\"Center\">게시일</td><td>" + list.get(i).getDate() + "</td></tr>");
				out.println(
						"<tr><td width=\"70\" align=\"Center\">이메일</td><td>" + list.get(i).getEmail() + "</td></tr>");
				out.println("<tr><td width=\"70\" align=\"Center\">홈페이지</td><td>" + list.get(i).getHomepage()
						+ "</td></tr>");
				out.println(
						"<tr><td width=\"70\" align=\"Center\">제목</td><td>" + list.get(i).getTitle() + "</td></tr>");
				out.println(
						"<tr><td width=\"70\" align=\"Center\">내용</td><td style=\"width: 500px; height:200px\"><pre style="
								+ "\"height:200px; white-space: pre-wrap; overflow: auto; word-break:break-all;  \" ''>"
								+ list.get(i).getContext() + "</pre></td></tr>");
				out.println("</table>");
				out.println("</br>");
			}
		}

		out.println("</body>");
		out.println("</html>");

	}

}
