package com.gteam.planner.dao;

import java.util.List;

import com.gteam.planner.domain.PlanVO;
import com.gteam.planner.domain.ScheduleVO;

public interface PlanDAO {
	
	//계획 추가
	public void planAdd(PlanVO vo) throws Exception;
	
	//계획 번호 확인
	public int planNoCheck(PlanVO vo) throws Exception;
	
	//일정 개별 추가
	public void planSchAdd(ScheduleVO vo) throws Exception;
	
	//게시판용 계획 목록
	List<PlanVO> planList() throws Exception;

	//유저별 계획 목록
	List<PlanVO> planListForUser(String userId) throws Exception;

	//계획 조회
	PlanVO planView(int planNo, String userId) throws Exception;

	//계획 수정
	void planModify(PlanVO vo);

	//계획 삭제
	void planDelete(int planNo, String userId) throws Exception;
	

}
