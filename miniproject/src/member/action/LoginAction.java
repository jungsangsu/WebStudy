package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//µ•¿Ã≈Õ
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);

		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDTO = memberDAO.Select(memberDTO);
		
		
		if(memberDTO==null)
		{
			request.setAttribute("display","/member/loginFail.jsp" );
			
		}else {
			
			String name = memberDTO.getName();
			String email = memberDTO.getEmail1()+"@"+memberDTO.getEmail2();
			
			HttpSession session = request.getSession();
			
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", email);
			
			request.setAttribute("display", "/member/loginOk.jsp");
		}
		return "/main/index.jsp";
	}
}
