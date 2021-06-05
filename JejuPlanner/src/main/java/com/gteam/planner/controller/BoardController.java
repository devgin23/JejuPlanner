package com.gteam.planner.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gteam.planner.domain.PlaceVO;

@Controller
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	//일정 목록 출력
	@RequestMapping(value="/plan/fromMap", method = RequestMethod.POST)
	@ResponseBody
	public Object fromMap(@RequestBody PlaceVO vo) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("place", vo.getPlace());
	    map.put("addr", vo.getAddr());
	    
		return map;
	}
	
}
