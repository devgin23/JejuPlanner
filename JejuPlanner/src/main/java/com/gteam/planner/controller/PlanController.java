package com.gteam.planner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	private PlanService planService;
	
	//계획 초기 설정 저장 객체
	static List<PlanVO> planSetList = new ArrayList<>();
	//일정 추가 리스트
	static List<Map<String,Object>> schList = new ArrayList<>();
	
	//로그인 후 일정 만들기 화면으로 이동
	@RequestMapping(value="/plan/write", method = RequestMethod.GET)
	public void schedulePlanning() throws Exception{
		// 리스트 초기화
		allPlanListClear();
	}
	
	//계획 초기 설정
	@RequestMapping(value="/plan/write/planSet", method=RequestMethod.POST)
	@ResponseBody
	public PlanVO planSet(PlanVO vo)throws Exception{
		if(planSetList.size()!=0) {
			allPlanListClear();
		}else {
			planSetList.add(vo);
		}
		log.info("planSetList :"+planSetList.toString());
		log.info("schList :"+schList.toString());
		return vo;
	}
	
	//일정 추가
	@RequestMapping(value="/plan/write/schAdd", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> schAdd(ScheduleVO vo) throws Exception{
		schList.add(planService.schAdd(vo));
		log.info("schList: " + schList.toString());
      return planService.schAdd(vo);
	}
	//계획 추가
	@RequestMapping(value="/plan/write/planAdd", method=RequestMethod.GET)
	public String planAdd() throws Exception {
		planService.planAdd(planSetList.get(0), schList);
		log.info("일정 정보 조회"+schList.toString());
		allPlanListClear();
		log.info("계획 추가 완료");
		return "redirect:/plan/write";
	}
	
	//장바구니 일정 삭제 (데이터 받아와서 List에서 삭제)
	@RequestMapping(value="/plan/write/planDel", method=RequestMethod.POST)
	@ResponseBody
	public void planDel(@RequestBody ScheduleVO vo) throws Exception {
		schList.remove(planService.planDel(vo));
		log.info("schList : " + schList.toString());
	}
	
	// 새로고침 시 리스트 초기화
	@RequestMapping(value="/plan/write/clear", method=RequestMethod.GET)
	public String planRefresh() throws Exception{
		allPlanListClear();
		return "/plan/write";
	}
	// 전체 리스트 초기화 메서드
	public static void allPlanListClear() {
		planSetList.clear();
		schList.clear();
		log.info("All PlanList Clear");
	}
	
	//계획 수정하기(진짜)
	@RequestMapping(value = "/plan/view/modify", method = RequestMethod.POST)
	public String planModify(PlanVO vo) throws Exception {
		log.info("PlanVO : " + vo.toString());
		planService.planModify(vo);
		
		return "redirect:/plan/view?planNo=" + vo.getPlanNo() + "&userId=" +vo.getUserId();
	}
	
	/*//계획 삭제하기(일단 살려둘 것)
	@RequestMapping(value="/plan/view/delete", method = RequestMethod.POST)
	public String planDelete(@RequestParam("planNo") int planNo, @RequestParam("userId") String userId) throws Exception{
		log.info("Controller인자출력 : " + planNo + userId);
		planService.planDelete(planNo, userId);
		return "/plan/write";
	}*/
	@RequestMapping(value = "/plan/view/deleteSch", method = RequestMethod.POST)
	@ResponseBody
	public void viewDeleteMap(@RequestBody ScheduleVO vo) {
		
	}
}