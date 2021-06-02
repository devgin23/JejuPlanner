package com.gteam.planner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gteam.planner.api.JeJuVisitAPI;

@Controller
public class APIController {
	
	//api 객체 선언
	private JeJuVisitAPI api = new JeJuVisitAPI();

	@RequestMapping(value ="/plan/api_test", method=RequestMethod.GET)
	public String ApiTest(Model model) throws Exception{
		/*model.addAttribute("apiTest", api.JejuAPI().photoid.thumbnailpath;);*/
		model.addAttribute("apiTest", api.JejuAPI());
		return "plan/api_test";
	}
	
	

}
