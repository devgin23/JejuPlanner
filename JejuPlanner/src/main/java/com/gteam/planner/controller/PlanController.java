package com.gteam.planner.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.domain.ScheduleVO;
import com.gteam.planner.service.PlanService;

@Controller
@SessionAttributes({"cart"})
public class PlanController {
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	PlanService planService;
	//일정 추가 리스트
	List<Map<String,Object>> list = new ArrayList<>();
	//로그인 후 일정 만들기 화면으로 이동
	@RequestMapping(value="/plan/write", method = RequestMethod.GET)
	public void schedulePlanning(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ArrayList<PlanVO>());
		}
		
	}
	//일정 추가
	@RequestMapping(value="/plan/write/schAdd", method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> addSchedule(ScheduleVO vo) {
		log.info("Modal Schedule Add");
		log.info(vo.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("descript", vo.getDescript());
		map.put("addr", vo.getAddr());
		map.put("startTime", vo.getStartTime());
		list.add(map);
		log.info("map: " + map.toString());
		log.info("list: " + list.toString());
      return list;
	}
	
	//게시판에 계획 리스트 출력
	@RequestMapping(value="/plan/list", method = RequestMethod.GET)
	public void planList(Model model) throws Exception {
		List<PlanVO> list = planService.list();
		model.addAttribute("list", list);
	}
	
	//유저별 계획 리스트 출력
	@RequestMapping(value="/plan/list/user", method = RequestMethod.GET)
	public String planListForUser(Model model, @RequestParam("userId") String userId) throws Exception {
		List<PlanVO> list = planService.listForUser(userId);
		model.addAttribute("list", list);
		return "/plan/list";
	}
	
	//계획 조회하기
	@RequestMapping(value="/plan/view", method = RequestMethod.GET)
	public String planViewForUser(Model model,@RequestParam("planNo") int planNo, @RequestParam("userId") String userId) throws Exception {
		PlanVO view = planService.planView(planNo, userId);
		model.addAttribute("view", view);
		return "/plan/write";
	}
	
}