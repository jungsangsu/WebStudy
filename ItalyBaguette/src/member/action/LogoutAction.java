package member.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class LogoutAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession();
		session.invalidate();

		int colen = 0;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			colen = cookies.length;
		}
		if (colen > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("loginCookie")) { // 쿠키가 있으면
					cookies[i].setPath("/");
					// 쿠키는 없앨 때 유효시간을 0으로 설정하는 것 !!! invalidate같은거 없음.
					cookies[i].setMaxAge(0);
					// 쿠키 설정을 적용한다.
					response.addCookie(cookies[i]);

					// 사용자 테이블에서도 유효기간을 현재시간으로 다시 세팅해줘야함.
					MemberDAO memberDAO = MemberDAO.getInstance();

					// DB 쿠키값을 초기화 [입력 쿠키 ID]
					memberDAO.sessionClear(cookies[i].getValue());
				}
			}
		}

		request.setAttribute("display", "/member/logout.jsp");
		return "/main/index.jsp";

	}
}
