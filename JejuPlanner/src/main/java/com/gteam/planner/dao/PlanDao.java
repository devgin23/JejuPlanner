package com.gteam.planner.dao;

import java.util.List;

import com.gteam.planner.domain.PlanVO;

public interface PlanDao {

	//게시판용 계획 목록
	List<PlanVO> planList() throws Exception;

	//유저별 계획 목록
	List<PlanVO> planListForUser(String userId) throws Exception;

	//계획 + 일정 조회
	List<PlanVO> planView(int planNo) throws Exception;

	//계획 수정
	void planModify(PlanVO vo);

	//계획 삭제
	void planDelete(int planNo, String userId) throws Exception;
	

}
