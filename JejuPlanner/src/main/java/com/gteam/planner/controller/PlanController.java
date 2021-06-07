package com.gteam.planner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gteam.planner.domain.Paging;
import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.domain.ScheduleVO;
import com.gteam.planner.service.BoardService;
import com.gteam.planner.service.PlanService;

@Controller
public class PlanController {
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	private PlanService planService;
	@Autowired
	private BoardService boardService;
	
	//계획 초기 설정 저장 객체
	List<PlanVO> planSetList = new ArrayList<>();
	//일정 추가 리스트
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
		schList.add(planService.schAdd(vo));
		log.info("schList: " + schList.toString());
      return planService.schAdd(vo);
	}
	//계획 추가
	@RequestMapping(value="/plan/write/planAdd", method=RequestMethod.GET)
	public String planAdd() throws Exception {
		planService.planAdd(planSetList.get(0), schList);
		log.info("일정 정보 조회"+schList.toString());
		planSetList.clear();
		schList.clear();
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
	
	//게시판에 계획 리스트 출력 및 페이징
	@RequestMapping(value="/plan/list", method=RequestMethod.GET)
	public String planList(Model model, @RequestParam("num") int num
			, @RequestParam(value="searchType", required=false, defaultValue="planTitle") String searchType	
			, @RequestParam(value="keyword", required=false, defaultValue="") String keyword
			) throws Exception {
		log.info("searchType:"+searchType+" keyword:"+keyword);
		//페이징 필드 값 생성자 통해서 초기화
		Paging page = new Paging(num, searchType, keyword);
		//전체 계획 갯수 구하기 (검색어 입력시 해당 검색 계획 갯수)
		page.setCount(boardService.boardPlanCnt(searchType, keyword));
		//계획 리스트 (검색어 입력시 해당 검색 리스트 출력)
		List<PlanVO> planList = planService.planList(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		//Model에 필요 값들 담아 list page로 리턴
		model.addAttribute("planList", planList);
		model.addAttribute("page", page);
		return "/plan/list";
	}
	
	//유저별 계획 리스트 출력
	@RequestMapping(value="/plan/list/user", method=RequestMethod.GET)
	public String planListForUser(Model model, @RequestParam("userId") String userId
			, @RequestParam("num") int num
			, @RequestParam(value="searchType", required=false, defaultValue="planTitle") String searchType	
			, @RequestParam(value="keyword", required=false, defaultValue="") String keyword
			) throws Exception {
		log.info("userId : "+userId);
		//페이징 필드 값 생성자 통해서 초기화
		Paging page = new Paging(num, searchType, keyword);
		//전체 계획 갯수 구하기 (검색어 입력시 해당 검색 계획 갯수)
		page.setCount(boardService.boardUserPlanCnt(userId, searchType, keyword));
		//계획 리스트 (검색어 입력시 해당 검색 리스트 출력)
		/*List<PlanVO> planList = planService.planList(page.getDisplayPost(), page.getPostNum(), searchType, keyword);*/
		List<PlanVO> planListForUser = planService.planListForUser(userId, page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		model.addAttribute("planListForUser", planListForUser);
		model.addAttribute("page", page);
		return "/plan/list_user";
	}
	
	//계획 조회하기
	@RequestMapping(value="/plan/view", method = RequestMethod.GET)
	public String planView(Model model,@RequestParam("planNo") int planNo, @RequestParam("userId") String userId) throws Exception {
		
		//계획 호출
		PlanVO planView = planService.planView(planNo, userId);
		model.addAttribute("planView", planView);
		
		//일정 호출
		List<ScheduleVO> scheduleList = planService.planSchList(planNo);
		model.addAttribute("scheduleList", scheduleList);
		System.out.println("planDay : "+scheduleList.get(1).getPlanDay());
		return "/plan/view";
	}
	
	//계획 수정하기(진짜)
	@RequestMapping(value = "/plan/view/modify", method = RequestMethod.POST)
	public String planModify(PlanVO vo) throws Exception {
		log.info("PlanVO : " + vo.toString());
		planService.planModify(vo);
		
		return "redirect:/plan/view?planNo=" + vo.getPlanNo() + "&userId=" +vo.getUserId();
	}
	
	//계획 삭제하기
	@RequestMapping(value="/plan/view/delete", method = RequestMethod.POST)
	public String planDelete(@RequestParam("planNo") int planNo, @RequestParam("userId") String userId) throws Exception{
		log.info("Controller인자출력 : " + planNo + userId);
		planService.planDelete(planNo, userId);
		return "/plan/write";
	}
	
}