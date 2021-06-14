package com.gteam.planner.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value = "/throwable")
	public String throwable(HttpServletRequest request, Model model) {
		log.info("throwable");
		errorLog(request);
		model.addAttribute("msg", "throwable");
		return "/error/errorPage";
	}
	@RequestMapping(value = "/exception")
	public String exception(HttpServletRequest request, Model model) {
		log.info("exception");
		errorLog(request);
		model.addAttribute("msg", "exception");
		return "/error/errorPage";
	}
	@RequestMapping(value = "/400")
	public String error400(HttpServletRequest request, Model model) {
		log.info("400");
		errorLog(request);
		model.addAttribute("msg", "400 Error");
		return "/error/errorPage";
	}
	@RequestMapping(value = "/403")
	public String error403(HttpServletRequest request, Model model) {
		log.info("403");
		errorLog(request);
		model.addAttribute("msg", "403 Error");
		return "/error/errorPage";
	}
	@RequestMapping(value = "/404")
	public String error404(HttpServletRequest request, Model model) {
		log.info("404");
		errorLog(request);
		model.addAttribute("msg", "404 Error");
		return "/error/errorPage";
	}
	@RequestMapping(value = "/405")
	public String error405(HttpServletRequest request, Model model) {
		log.info("405");
		errorLog(request);
		model.addAttribute("msg", "405 Error");
		return "/error/errorPage";
	}
	@RequestMapping(value = "/500")
	public String error500(HttpServletRequest request, Model model) {
		log.info("500");
		errorLog(request);
		model.addAttribute("msg", "500 Error");
		return "/error/errorPage";
	}
	@RequestMapping(value = "/503")
	public String error503(HttpServletRequest request, Model model) {
		log.info("503");
		errorLog(request);
		model.addAttribute("msg", "503 Error");
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
