package com.gteam.planner.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.gteam.planner.service.ScheduleService;

@Controller
public class PlanController {
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	//일정 추가 리스트
	List<Map<String,Object>> list = new ArrayList<>();
	
	//로그인 후 일정 만들기 화면으로 이동
	@RequestMapping(value="/plan/write", method = RequestMethod.GET)
	public void schedulePlanning() throws Exception{
	}
	
	//계획 초기 설정
	@RequestMapping(value="/plan/write/planAdd", method=RequestMethod.POST)
	@ResponseBody
	public PlanVO planAdd(PlanVO vo)throws Exception{
		log.info(vo.toString());
		return vo;
	}
	
	//일정 추가
	@RequestMapping(value="/plan/write/schAdd", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> schAdd(ScheduleVO vo) {
		log.info("Modal Schedule Add");
		log.info(vo.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("planDay", vo.getPlanDay());
		map.put("descript", vo.getDescript());
		map.put("addr", vo.getAddr());
		map.put("startTime", vo.getStartTime());
		list.add(map);
		log.info("map: " + map.toString());
		log.info("list: " + list.toString());
      return map;
	}
	
	//게시판에 계획 리스트 출력
	@RequestMapping(value="/plan/list", method=RequestMethod.GET)
	public String planList(Model model) throws Exception {
		List<PlanVO> planList = planService.planList();
		model.addAttribute("planList", planList);
		return "/plan/list";
	}
	
	//유저별 계획 리스트 출력
	@RequestMapping(value="/plan/list/user", method=RequestMethod.POST)
	public String planListForUser(Model model, @RequestParam("userId") String userId) throws Exception {
		List<PlanVO> planListForUser = planService.planListForUser(userId);
		model.addAttribute("planListForUser", planListForUser);
		return "/plan/list_user";
	}
	
	//계획 조회하기
	@RequestMapping(value="/plan/view", method = RequestMethod.POST)
	public String planView(Model model,@RequestParam("planNo") int planNo, @RequestParam("userId") String userId) throws Exception {
		
		//계획 호출
		PlanVO planView = planService.planView(planNo, userId);
		model.addAttribute("planView", planView);
		
		//일정 호출
		List<ScheduleVO> scheduleList = scheduleService.scheduleList(planNo);
		model.addAttribute("scheduleList", scheduleList);
		System.out.println(scheduleList.size());
		System.out.println(scheduleList.get(1).toString());
		
		return "/plan/view";
	}
	
	//계획 수정하기
	@RequestMapping(value="/plan/view/modify", method = RequestMethod.POST)
	public String planModify(PlanVO vo) throws Exception{
		planService.planModify(vo);
		return "/plan/write";
	}
	
	//계획 삭제하기
	@RequestMapping(value="/plan/view/delete", method = RequestMethod.POST)
	public String planDelete(@RequestParam("planNo") int planNo, @RequestParam("userId") String userId) throws Exception{
		log.info("Controller인자출력 : " + planNo + userId);
		planService.planDelete(planNo, userId);
		return "/plan/write";
	}
	
}