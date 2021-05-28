package com.gteam.planner.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gteam.planner.domain.MemberVO;
import com.gteam.planner.service.MemberService;

@Controller
@RequestMapping(value="/")
@SessionAttributes({"cart"})
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	
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
		log.info("post register");
		//아이디 중복 체크
		try {
			int idResult=service.idCheck(vo);
			if(idResult==1) {
				
				return "redirect:/member/register";
			}else if(idResult==0){
				service.register(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.info("MemberController에서 MemberService 호출 시 에러");
		}
		return "redirect:/";
	}
	
	// 회원가입 시 아이디 중복 체크 
	@ResponseBody
	@RequestMapping(value="/member/register/idCheck", method = RequestMethod.POST)
	public int idCheck(MemberVO vo) throws Exception{
		log.info("idCheck");
		// 중복이면 1, 아니면 0 을 반환
		return service.idCheck(vo);
	}
	
	//로그인
	//RedirectAttributes => 일회성으로 데이터를 전달할 때 사용
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		log.info("post login");
		log.info(vo.toStringLogin());
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if(login == null) {
			//DB에서 회원정보가 없을 시 view단에 null값 반환
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/";
		}else {
			//DB에서 회원정보 존재 시 view단에 회원정보(아이디, 패스워드 반환)
			session.setAttribute("member", login);
			return "redirect:/plan/write";
		}
		
	}
	//로그아웃
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		log.info("logout");
		//세션 소멸
		session.invalidate();
		
		return "redirect:/";
	}

}
