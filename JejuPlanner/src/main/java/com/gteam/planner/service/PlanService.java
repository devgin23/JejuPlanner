package com.gteam.planner.service;

import java.util.List;

import com.gteam.planner.domain.PlanVO;

public interface PlanService {

	
	//게시판용 계획 목록
	List<PlanVO> list() throws Exception;

	//유저별 계획 목록
	List<PlanVO> listForUser(String userId) throws Exception;

}
