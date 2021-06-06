package com.gteam.planner.service;

import java.util.HashMap;
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
			schVo.setPlace(schList.get(i).get("place").toString());
			log.info(schVo.toString());
			dao.planSchAdd(schVo);
		}
		log.info("Insert Plan END");
	}
	
	//일정 List 객체
	@Override
	public Map<String, Object> schAdd(ScheduleVO vo) throws Exception {
		Map<String, Object> schMap = new HashMap<>();
		schMap.put("planDay", vo.getPlanDay());
		schMap.put("descript", vo.getDescript());
		schMap.put("addr", vo.getAddr());
		schMap.put("startTime", vo.getStartTime());
		schMap.put("place", vo.getPlace());
		schMap.put("longitude", vo.getLongitude());
		schMap.put("latitude", vo.getLatitude());
		return schMap;
	}
	
	//장바구니 일정 삭제 (데이터 받아와서 List에서 삭제)
	@Override
	public HashMap<String, Object> planDel(ScheduleVO vo) throws Exception {
		HashMap<String, Object> delMap = new HashMap<String, Object>();
		delMap.put("startTime",vo.getStartTime());
		delMap.put("planDay",vo.getPlanDay());
		delMap.put("descript",vo.getDescript());
		delMap.put("addr",vo.getAddr());
		delMap.put("place", vo.getPlace());
		delMap.put("longitude", vo.getLongitude());
		delMap.put("latitude", vo.getLatitude());
		log.info("delMap : " + delMap.toString());
		return delMap;
	}
	
	//게시판용 계획 목록 및 페이징 및 페이징 처리
	@Override
	public List<PlanVO> planList(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return dao.planList(displayPost, postNum, searchType, keyword);
	}

	
	
	//일정 목록 출력
	@Override
	public List<ScheduleVO> planSchList(int planNo) throws Exception {
		return dao.planSchList(planNo);
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
		dao.planDelete(planNo, userId);
	}

	

}
