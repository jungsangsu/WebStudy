package member.action;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		// 데이터
		String autoLogin = request.getParameter("autoLogin"); // 체크되면 ON 안되면 NULL;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);

		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDTO = memberDAO.Select(memberDTO);

		if (memberDTO == null) {
			request.setAttribute("display", "/member/loginFail.jsp");

		} else {

			String name = memberDTO.getName();
			String email = memberDTO.getEmail1()+"@"+memberDTO.getEmail2();
			HttpSession session = request.getSession();

			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", email);
			
			//세션 ID를 멤버에 추가
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
			memberDTO.setSessionkey(session.getId());
			memberDTO.setSessionlimit(sessionLimit);
			memberDAO.applySession(memberDTO);
			
			
			if (autoLogin != null) { // 자동로그인 체크
				Cookie cookie = new Cookie("loginCookie", session.getId());
				// 쿠키를 찾을 경로를 컨텍스트 경로로 변경해 주고...
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 7); // 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
				// 쿠키를 적용해 준다.
				response.addCookie(cookie);
			}

			request.setAttribute("display", "/member/loginOk.jsp");
		}
		return "/main/index.jsp";
	}
}
