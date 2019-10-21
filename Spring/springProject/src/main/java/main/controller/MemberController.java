package main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.service.MemberServiceImpl;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@RequestMapping(value = "/member/loginAction", method = RequestMethod.POST)
	public ModelAndView loginAction(@RequestParam String id, @RequestParam String pwd, HttpSession session , HttpServletRequest  request) {

		MemberDTO memberDTO = memberServiceImpl.login(id, pwd);
		ModelAndView mav = new ModelAndView();
		if (memberDTO == null) {
			mav.addObject("display", "/member/loginFail.jsp");
		} else {
			mav.addObject("display", "/member/loginOk.jsp");
			String name = memberDTO.getName();
			String email = memberDTO.getEmail1() + "@" + memberDTO.getEmail2();
			
			 session = request.getSession();
			 
			 session.setAttribute("memName", name); session.setAttribute("memId", id);
			 session.setAttribute("memEmail", email);
		}

		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping(value="/member/logoutAction", method = RequestMethod.GET)
	public ModelAndView loginAction(HttpSession session, HttpServletRequest  request) {
		
		ModelAndView mav = new ModelAndView();
		
		session = request.getSession();

		session.removeAttribute("memName");
		session.removeAttribute("memId");
		session.removeAttribute("memEmail");

		mav.addObject("display", "/member/logout.jsp");
		mav.setViewName("/main/index");
		
		
		return mav;
	}
	
	

}
