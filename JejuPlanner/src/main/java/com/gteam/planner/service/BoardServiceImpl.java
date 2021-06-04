package com.gteam.planner.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gteam.planner.dao.BoardDAO;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;
	
	//계획 총 갯수
	@Override
	public int boardPlanCount(String searchType, String keyword) throws Exception {
		return dao.boardPlanCount(searchType, keyword);
	}

	
	//일정 객체 출력
/*	@Override
	public ScheduleVO formData() throws Exception {
		return dao.list().get(0);
	}*/

}
