package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class PostAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");

		ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
		zipcodeDTO.setSido(sido);
		zipcodeDTO.setSigungu(sigungu);
		zipcodeDTO.setRoadname(roadname);
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		List<ZipcodeDTO> list = null;

		if (sido != null && roadname != null) {
			list = memberDAO.getZipcodeList(zipcodeDTO);
		}
		
		if(list!=null) {
			request.setAttribute("list",list);
		}
		
		return "/member/checkPost.jsp";
		
	}
}
