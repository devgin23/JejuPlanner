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

import com.gteam.planner.domain.PlaceVO;
import com.gteam.planner.domain.ScheduleVO;
import com.gteam.planner.service.ScheduleService;

@Controller
public class ScheduleController {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired
	private ScheduleService service;
	
	//일정 목록 출력
/*	@RequestMapping(value="/plan/view", method = RequestMethod.POST)
	public String scheduleList(Model model, @RequestParam("planNo") int planNo) throws Exception {

		//일정 리스트 넘겨주기
		List<ScheduleVO> scheduleList = service.scheduleList(planNo);
		model.addAttribute("scheduleList", scheduleList);
		System.out.println("스케줄 컨트롤러 인자 확인 : " + planNo);
		log.info("schedule Controller log"+scheduleList.get(0).getAddr());
		return "/plan/view";
	}*/
	
	@RequestMapping(value="/plan/fromMap", method = RequestMethod.POST)
	@ResponseBody
	public Object fromMap(@RequestBody PlaceVO vo) throws Exception {
		System.out.println("vo 출력 : " + vo.toString());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("placeName", vo.getPlaceName());
	    map.put("placeAddress", vo.getPlaceAddress());
	    
		return map;
	}
	
}
