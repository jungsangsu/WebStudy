package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LogoutAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession();

		session.removeAttribute("memName");
		session.removeAttribute("memId");
		session.removeAttribute("memEmail");

		request.setAttribute("display", "/member/logout.jsp");
		return "/main/index.jsp";

	}
}
