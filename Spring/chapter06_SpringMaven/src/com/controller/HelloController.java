package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value="/hello.do",method = RequestMethod.GET)
	public ModelAndView aaa() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("result","helloSpring!!");
		/* mav.setViewName("hello"); */
		mav.setViewName("/view/hello");
		
		return mav;
	}
}
