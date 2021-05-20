package com.gteam.planner.dao;

import java.util.List;

import com.gteam.planner.domain.ScheduleVO;

public interface ScheduleDao {
	
	// 일정 목록
	public List<ScheduleVO> list() throws Exception;
	
	// 일정 추가
	public void write(ScheduleVO vo) throws Exception;

}
