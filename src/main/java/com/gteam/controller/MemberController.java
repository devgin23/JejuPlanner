package com.gteam.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gteam.domain.MemberVO;
import com.gteam.service.MemberService;

@Controller
@RequestMapping(value="/")
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private final MemberService service;
	
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	// localhost:9090/ GET 요청 시 login.jsp로 던져줌
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin() {
		log.info("login.jsp");
		return "/member/login";
	}
	// localhost:9090/member/register GET 요청 시 register.jsp로 던져줌
	@RequestMapping(value="/member/register", method=RequestMethod.GET)
	public void getRegister() {
		log.info("register.jsp");
	}
	// 회원가입
	@RequestMapping(value="/member/register", method=RequestMethod.POST)
	public String postRegister(MemberVO vo) {
		try {
		service.register(vo);
		}catch(Exception e) {
			e.printStackTrace();
			log.info("MemberController에서 MemberService 호출 시 에러");
		}
		return "redirect:/";
	}
	//로그인
	//RedirectAttributes => 일회성으로 데이터를 전달할 때 사용
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		log.info("post login");
		log.info(vo.toString());
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		log.info("logout");
		session.invalidate();
		
		return "redirect:/";
	}
	
}
