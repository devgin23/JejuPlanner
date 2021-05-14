package com.gteam.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gteam.domain.MemberVO;
import com.gteam.domain.PlanVO;
import com.gteam.service.MemberService;

@Controller
@RequestMapping(value="/")
@SessionAttributes({"cart"})
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
			return "redirect:/plan/schedulePlan";
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
	//로그인 후 일정 만들기 화면으로 이동
	@RequestMapping(value="/plan/schedulePlan", method = RequestMethod.GET)
	public void schedulePlanning(Model model) throws Exception{
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ArrayList<PlanVO>());
		}
		
	}
	
	@RequestMapping(value="/plan/schedulePlan/add", method=RequestMethod.POST)
	public String addSchedule(
			//입력 파라미터인 name, price, cnt가 goods에 일괄 바인딩 됨
            //goods라는 이름의 Model로 저장(Request Scope)
            @ModelAttribute PlanVO vo, 
            //세션에서 cart라는 이름의 Model을 가져와 cart에 할당
            @ModelAttribute("cart") List<PlanVO> cart) {
      // cart라는 Model(ArrayList)에 사용자가 입력한 항목들을 가진 goods 객체를 Add
		log.info("Modal Plan Add");
      cart.add(vo);

      //localhost:port/cart로 요청을 보냄
      return "redirect:/plan/schedulePlan";
	}
}
