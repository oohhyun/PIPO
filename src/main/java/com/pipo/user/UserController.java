package com.pipo.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/user/**")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * 최초 작성일 : 2021.07.18 (OH)
	 * 기능 : 로그인  
	 * 내용 : Spring Security 적용 예정
 	 */
	@GetMapping("login")
	public String getUserLogin(Model model) {
		return "user/login";
	}
	
	@PostMapping("login")
	public String getLogin(UserVO userVO, HttpServletRequest request, RedirectAttributes rd) {
		
		userVO = userService.getUserLogin(userVO);
		
		if(userVO != null)
		{
			request.getSession().setAttribute("user",userVO); // 로그인 정보 세션 저장 
			return "redirect:/";
		}
		else
		{
			rd.addAttribute("message", "로그인에 실패하였습니다");
			return "redirect:/user/login";
		}
	}
	
	/* 
	 * 최초 작성일 : 2021.07.18 (OH)
	 * 기능 : 로그아웃
	 * 내용 : Spring Security 적용 예정
 	 */
	@GetMapping("logout")
	public String setLogout(UserVO userVO,  Model model,HttpServletRequest request) throws Exception {
		request.getSession().invalidate(); // 세션 종료 
		return "redirect:/";
	}
	
}
