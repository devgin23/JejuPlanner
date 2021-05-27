package com.gteam.planner.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.planner.controller.PlanController;
import com.gteam.planner.dao.PlanDAO;
import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.domain.ScheduleVO;

@Repository
public class PlanServiceImpl implements PlanService{
	
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	private PlanDAO dao;
	
	//계획 설정 추가
	@Override
	public void planAdd(PlanVO vo, List<Map<String, Object>> schList) throws Exception {
		dao.planAdd(vo);
		int planNo = dao.planNoCheck(vo);
		for(int i = 0; i<schList.size(); i++) {
			ScheduleVO schVo = new ScheduleVO();
			//vo 값 세팅
			schVo.setPlanNo(planNo);
			schVo.setUserId(vo.getUserId());
			schVo.setDescript(schList.get(i).get("descript").toString());
			schVo.setAddr(schList.get(i).get("addr").toString());
			schVo.setPlanDay(Integer.parseInt(schList.get(i).get("planDay").toString()));
			schVo.setStartTime(Integer.parseInt(schList.get(i).get("startTime").toString()));
			log.info(schVo.toString());
			dao.planSchAdd(schVo);
		}
		log.info("Insert Plan END");
		
	}
	
	//게시판용 계획 목록
	@Override
	public List<PlanVO> planList() throws Exception {
		return dao.planList();
	}
	
	//유저별 계획 목록
	@Override
	public List<PlanVO> planListForUser(String userId) throws Exception {
		return dao.planListForUser(userId);
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
