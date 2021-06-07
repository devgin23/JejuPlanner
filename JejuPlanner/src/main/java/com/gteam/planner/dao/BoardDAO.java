package com.gteam.planner.dao;


public interface BoardDAO {
	
	//계획 총 갯수
	public int boardPlanCnt(String searchType, String keyword) throws Exception;
	
	//유저별 계획 총 갯수
	public int boardUserPlanCnt(String userId, String searchType, String keyword) throws Exception;
}
