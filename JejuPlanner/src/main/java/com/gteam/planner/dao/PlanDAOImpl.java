package com.gteam.planner.dao;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.planner.controller.PlanController;
import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.domain.ScheduleVO;

@Repository
public class PlanDAOImpl implements PlanDAO {
	
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	private SqlSession sql;
	private static String namespace = "com.gteam.planner.mappers.plan";
	
	//계획 설정 추가
	@Override
	public void planAdd(PlanVO vo) throws Exception {
		sql.insert(namespace+".planAdd", vo);
	}
	
	//PlanNo 가져오기
	@Override
	public int planNoCheck(PlanVO vo) throws Exception {
		int result = sql.selectOne(namespace+".planNoGet", vo);
		return result;
	}

	//계획 일정 개별 추가
	@Override
	public void planSchAdd(ScheduleVO vo) throws Exception {
		sql.insert(namespace+".planSchAdd", vo);
	}
	
	//게시판용 계획 목록 및 페이징
	@Override
	public List<PlanVO> planList(HashMap<String, Object> data) throws Exception {
		return sql.selectList(namespace + ".planList", data);
	}
	
	//계획일정 목록
	@Override
	public List<ScheduleVO> planSchList(int planNo) throws Exception {
		return sql.selectList(namespace + ".planSchList", planNo);
	}
	
	//유저별 계획 목록
	@Override
	public List<PlanVO> planListForUser(HashMap<String, Object> data) throws Exception{
		return sql.selectList(namespace + ".planListForUser", data);
	}
	
	//계획 조회
	@Override
	public PlanVO planView(PlanVO vo) throws Exception {
		return sql.selectOne(namespace + ".planView", vo);
	}
	
	//계획 수정
	@Override
	public void viewPlanModify(PlanVO vo) {
		sql.update(namespace + ".viewPlanModify", vo);
	}
	
	//계획 삭제
	@Override
	public void viewPlanDelete(PlanVO vo) throws Exception {
		log.info("view Plan Delete"+vo.toString());
		sql.delete(namespace + ".viewPlanDelete", vo);
	}
	
	
	//view 삭제 추가 수정 완료버튼
	@Override
	public void viewSchDelete(HashMap<String,Object> map) throws Exception {
		sql.delete(namespace+".viewSchDelete", map);
	}
	
	
	
	
}
