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
		log.info("planNo: " + String.valueOf(result));
		return result;
	}
	
	//계획 일정 개별 추가
	@Override
	public void planSchAdd(ScheduleVO vo) throws Exception {
		sql.insert(namespace+".planSchAdd", vo);
	}
	
	//게시판용 계획 목록
	@Override
	public List<PlanVO> planList() throws Exception {
		return sql.selectList(namespace + ".planList");
	}
	
	//유저별 계획 목록
	@Override
	public List<PlanVO> planListForUser(String userId) throws Exception{
		return sql.selectList(namespace + ".planListForUser", userId);
	}
	
	//계획 조회
	@Override
	public PlanVO planView(int planNo, String userId) throws Exception {
		
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("planNo", planNo);
		data.put("userId", userId);
		
		return sql.selectOne(namespace + ".planView", data);
	}
	
	//계획 수정
	@Override
	public void planModify(PlanVO vo) {
		sql.update(namespace + ".planModify", vo);
	}
	
	//계획 삭제
	@Override
	public void planDelete(int planNo, String userId) throws Exception {
		log.info("Dao인자출력 : " + planNo + userId);
		HashMap<String, Object> data = new HashMap<>();
		
		data.put("planNo", planNo);
		data.put("userId", userId);
		
		sql.delete(namespace + ".planDelete", data);
		
	}
		
}
