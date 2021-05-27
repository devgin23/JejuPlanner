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

import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.domain.ScheduleVO;
import com.gteam.planner.service.PlanService;

@Controller
public class PlanController {
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	PlanService planService;
	
	//계획 초기 설정 저장 객체
	List<PlanVO> planSetList = new ArrayList<>();
	//일정 추가 저장 리스트
	List<Map<String,Object>> schList = new ArrayList<>();
	
	//로그인 후 일정 만들기 화면으로 이동
	@RequestMapping(value="/plan/write", method = RequestMethod.GET)
	public void schedulePlanning() throws Exception{
	}
	
	//계획 초기 설정
	@RequestMapping(value="/plan/write/planSet", method=RequestMethod.POST)
	@ResponseBody
	public PlanVO planSet(PlanVO vo)throws Exception{
		log.info(vo.toString());
		planSetList.add(vo);
		return vo;
	}
	
	//일정 추가
	@RequestMapping(value="/plan/write/schAdd", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> schAdd(ScheduleVO vo) throws Exception{
		log.info("Modal Schedule Add");
		schList.add(planService.schAdd(vo));
		log.info("schList: " + schList.toString());
      return planService.schAdd(vo);
	}
	
	//계획 추가
	@RequestMapping(value="plan/write/planAdd", method=RequestMethod.GET)
	public String planAdd() throws Exception {
		planService.planAdd(planSetList.get(0), schList);
		planSetList.clear();
		schList.clear();
		log.info("계획 추가 완료");
		return "redirect:/plan/write";
	}
	
	//게시판에 계획 리스트 출력
	@RequestMapping(value="/plan/list", method=RequestMethod.GET)
	public String planList(Model model) throws Exception {
		List<PlanVO> list = planService.planList();
		model.addAttribute("list", list);
		return "/plan/list";
	}
	
	//유저별 계획 리스트 출력
	@RequestMapping(value="/plan/list/user", method=RequestMethod.POST)
	public String planListForUser(Model model, @RequestParam("userId") String userId) throws Exception {
		List<PlanVO> list = planService.planListForUser(userId);
		model.addAttribute("list", list);
		return "/plan/list_user";
	}
	
	//계획 조회하기
	@RequestMapping(value="/plan/view", method = RequestMethod.POST)
	public String planViewForUser(Model model,@RequestParam("planNo") int planNo, @RequestParam("userId") String userId) throws Exception {
		PlanVO view = planService.planView(planNo, userId);
		model.addAttribute("view", view);
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