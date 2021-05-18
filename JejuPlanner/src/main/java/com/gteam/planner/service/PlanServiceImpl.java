package com.gteam.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.planner.dao.PlanDao;
import com.gteam.planner.domain.PlanVO;

@Repository
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanDao dao;
	
	//게시판용 계획 목록
	@Override
	public List<PlanVO> list() throws Exception {
		return dao.list();
	}
	
	//유저별 계획 목록
	@Override
	public List<PlanVO> listForUser(String userId) throws Exception {
		return dao.listForUser(userId);
	}

}
