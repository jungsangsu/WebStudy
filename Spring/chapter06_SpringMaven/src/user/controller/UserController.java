package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}

	@RequestMapping(value = "/user/write", method = RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String list() {
		return "/user/list";
	}

	/*
	 * @RequestMapping(value="/user/getList", method = RequestMethod.POST) public
	 * ModelAndView getList() { List<UserDTO> list = userService.getList();
	 * ModelAndView mav = new ModelAndView(); mav.addObject("list", list);
	 * mav.setViewName("jsonView"); System.out.println(mav.toString()); return mav;
	 * }
	 */

	@RequestMapping(value = "/user/getList", method = RequestMethod.POST)
	@ResponseBody
	public Map getList() {
		List<UserDTO> list = userService.getList();

		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", jsonArray);

		return map;
	}

	@RequestMapping(value = "/user/modifyForm", method = RequestMethod.GET)
	public String ModifyForm() {
		return "/user/modifyForm";
	}

	@RequestMapping(value = "/user/getUser", method = RequestMethod.POST)
	public ModelAndView getUser(@RequestParam String id) {

		UserDTO userDTO = userService.getUser(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userDTO", userDTO);
		mav.setViewName("jsonView");

		return mav;
	}

	@RequestMapping(value = "/user/modify", method = RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}

	@RequestMapping(value = "/user/deleteForm", method = RequestMethod.GET)
	public String DeleteForm() {
		return "/user/deleteForm";
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	@ResponseBody
	public void Delete(@RequestParam String id) {
		userService.delete(id);
	}

	@RequestMapping(value = "/user/checkId", method = RequestMethod.POST)
	@ResponseBody
	public String CheckId(@RequestParam String id) {
		UserDTO userDTO = userService.checkID(id);
		if (userDTO == null) {
			return "not_exist";
		} else {
			return "exist";
		}
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	@ResponseBody
	public Map search(@RequestParam String key, @RequestParam String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (content != "") {
			List<UserDTO> userDTO = userService.search(key, content);
			JSONArray jsonArray = JSONArray.fromObject(userDTO);
			System.out.println(jsonArray);
			map.put("list", jsonArray);
		}
		return map;
	}

}
