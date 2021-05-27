package com.gteam.planner.service;

import java.util.List;
import java.util.Map;

import com.gteam.planner.domain.PlanVO;

public interface PlanService {

	//일정 설정 추가 및 PlanNo 확인
	public void planAdd(PlanVO vo, List<Map<String,Object>> schList) throws Exception;
	
	//게시판용 계획 목록
	List<PlanVO> planList() throws Exception;

	//유저별 계획 목록
	List<PlanVO> planListForUser(String userId) throws Exception;

	//계획조회
	PlanVO planView(int planNo, String userId) throws Exception;

	//계획수정
	void planModify(PlanVO vo) throws Exception;

	//계회갓ㄱ제
	void planDelete(int planNo, String userId) throws Exception;


}
