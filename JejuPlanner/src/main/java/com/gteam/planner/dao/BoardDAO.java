package com.gteam.planner.dao;


public interface BoardDAO {
	
	//계획 총 갯수
	public int boardPlanCount(String searchType, String keyword) throws Exception;


}
