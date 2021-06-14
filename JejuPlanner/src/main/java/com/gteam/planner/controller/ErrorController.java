package com.gteam.planner.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value = "/error")
	public String error404(HttpServletRequest request, Model model) {
		log.info(request.getAttribute("javax.servlet.error.status_code").toString());
		errorLog(request);
		model.addAttribute("msg", request.getAttribute("javax.servlet.error.status_code")+" Page");
		return "/error/errorPage";
	}

	
	private void errorLog(HttpServletRequest request) {
		log.info("status_code : " + request.getAttribute("javax.servlet.error.status_code"));
		log.info("exception_type : " + request.getAttribute("javax.servlet.error.exception_type"));
		log.info("message : " + request.getAttribute("javax.servlet.error.message"));
		log.info("request_uri : " + request.getAttribute("javax.servlet.error.request_uri"));
		log.info("exception : " + request.getAttribute("javax.servlet.error.exception"));
		log.info("servlet_name : " + request.getAttribute("javax.servlet.error.servlet_name"));
	}
}
