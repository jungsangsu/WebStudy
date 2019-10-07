package main.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MainAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int colen = 0;
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			colen = cookies.length;
		}
		if (colen > 0) {
			/* System.out.println("쿠키 크기 : " + cookies.length); */
			HttpSession session = request.getSession();
			/* System.out.println("세션 : " + session.getId()); */

			for (int i = 0; i < cookies.length; i++) {
				/*
				 * System.out.println("쿠키 이름: " + cookies[i].getName() );
				 * System.out.println("쿠키 값 : " + cookies[i].getValue());
				 */
				
				if (cookies[i].getName().equals("loginCookie")) { //쿠키가 있으면 쿠키의 값을 세션에 넣어줌
					
					MemberDAO memberDAO = MemberDAO.getInstance();
					
					//멤버를 가지고오고[세션아이디로 memberDTO]
					MemberDTO memberDTO = memberDAO.sessionToDTO(cookies[i].getValue());
					/* System.out.println(memberDTO.getId()); */					
					//쿠키가 유요한지 확인
					
					if(memberDTO!=null) {
						session.setAttribute("memName", memberDTO.getName());
						session.setAttribute("memId", memberDTO.getId());
					}
					
				}
			}
		}
		request.setAttribute("display", "../template/body.jsp");
		return "/main/index.jsp";
	}

}
