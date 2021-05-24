package com.gteam.planner.dao;

import java.util.List;

import com.gteam.planner.domain.PlanVO;

public interface PlanDao {

	//게시판용 계획 목록
	List<PlanVO> list() throws Exception;

	//유저별 계획 목록
	List<PlanVO> listForUser(String userId) throws Exception;

	//계획 조회
	PlanVO planView(int planNo, String userId) throws Exception;

	//계획 수정
	void planModify(PlanVO vo);

	//계획 삭제
	void planDelete(int planNo, String userId) throws Exception;
	

}
