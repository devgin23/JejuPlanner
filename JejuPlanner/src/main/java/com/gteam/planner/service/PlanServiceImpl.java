package com.gteam.planner.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.planner.controller.PlanController;
import com.gteam.planner.dao.PlanDao;
import com.gteam.planner.domain.PlanVO;

@Repository
public class PlanServiceImpl implements PlanService{
	
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
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
	
	//계획 조회
	@Override
	public PlanVO planView(int planNo, String userId) throws Exception {
		return dao.planView(planNo, userId);
	}
	
	//계획 수정
	@Override
	public void planModify(PlanVO vo) throws Exception {
		dao.planModify(vo);
	}
	
	//계획 삭제
	@Override
	public void planDelete(int planNo, String userId) throws Exception {
		log.info("Service인자출력 : " + planNo + userId);
		dao.planDelete(planNo, userId);
	}

}
