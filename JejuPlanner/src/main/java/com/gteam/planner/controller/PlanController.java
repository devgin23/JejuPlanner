package com.gteam.planner.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.service.ScheduleService;

@Controller
@SessionAttributes({"cart"})
public class PlanController {
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	
	//로그인 후 일정 만들기 화면으로 이동
	@RequestMapping(value="/plan/write", method = RequestMethod.GET)
	public void schedulePlanning(Model model) throws Exception{
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ArrayList<PlanVO>());
		}
		
	}
	@RequestMapping(value="/plan/write/add", method=RequestMethod.POST)
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
      return "redirect:/plan/write";
	}
}