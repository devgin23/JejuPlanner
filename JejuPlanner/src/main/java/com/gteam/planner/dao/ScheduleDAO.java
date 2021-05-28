package com.gteam.planner.dao;

import java.util.List;

import com.gteam.planner.domain.ScheduleVO;

public interface ScheduleDAO {
	
	// 일정 목록
	public List<ScheduleVO> scheduleList(int planNo) throws Exception;


}
