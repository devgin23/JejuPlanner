package com.gteam.planner.controller;

import java.util.HashMap;
import java.util.List;

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
import com.gteam.planner.domain.PlaceVO;
import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.domain.ScheduleVO;
import com.gteam.planner.service.BoardService;
import com.gteam.planner.service.PlanService;

@Controller
public class BoardController {
	
	@Autowired
	private PlanService planService;
	@Autowired
	private BoardService boardService;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	//일정 목록 출력
	@RequestMapping(value="/plan/fromMap", method = RequestMethod.POST)
	@ResponseBody
	public Object fromMap(@RequestBody PlaceVO vo) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("place", vo.getPlace());
	    map.put("addr", vo.getAddr());
	    map.put("longitude", vo.getLongitude());
	    map.put("latitude", vo.getLatitude());
	    
		return map;
	}
	
	//게시판에 계획 리스트 출력 및 페이징
	@RequestMapping(value="/plan/list", method=RequestMethod.GET)
	public String planList(Model model, @RequestParam("num") int num
			, @RequestParam(value="searchType", required=false, defaultValue="planTitle") String searchType	
			, @RequestParam(value="keyword", required=false, defaultValue="") String keyword
			) throws Exception {
		// 정적 계획 리스트 초기화
		PlanController.allPlanListClear();
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
		// 정적 계획 리스트 초기화
		PlanController.allPlanListClear();
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
		log.info("planView: "+planView.toString());
		//일정 호출
		List<ScheduleVO> scheduleList = planService.planSchList(planNo);
		model.addAttribute("scheduleList", scheduleList);
		return "/plan/view";
	}
	
}
