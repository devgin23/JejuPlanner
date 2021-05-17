package com.gteam.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gteam.planner.domain.ScheduleVO;
import com.gteam.planner.service.ScheduleService;

@Controller
public class ScheduleController {
	
	@Autowired
	private ScheduleService service;
	
	//일정목록화면
	@RequestMapping(value="/schedule/list", method = RequestMethod.GET)
	public String outputList(Model model) throws Exception {
		System.out.println("목록화면입니다.");
		
		List<ScheduleVO> list = service.list();
		model.addAttribute("list", list);

		return "/schedule/output";
	}
	
	//일정추가폼
	@RequestMapping(value="/schedule/add", method = RequestMethod.GET)
	public String write(Model model) throws Exception {
		ScheduleVO formData = service.formData();
		model.addAttribute("formData", formData);
		
		return "/schedule/input";
	}
	
	@RequestMapping(value="/schedule/add", method = RequestMethod.POST)
	public String write(ScheduleVO vo, BindingResult error) throws Exception {
		System.out.println("Controller 출력 : " + vo.getPlanNo());
		service.write(vo);
		
		return "/schedule/input";
	}
	
}
