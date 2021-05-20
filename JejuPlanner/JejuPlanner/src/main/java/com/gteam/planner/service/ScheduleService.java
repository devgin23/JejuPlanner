package com.gteam.planner.service;

import java.util.List;

import com.gteam.planner.domain.ScheduleVO;

public interface ScheduleService {
	
	// 일정 목록
	public List<ScheduleVO> list() throws Exception;
	
	// 일정 객체
	public ScheduleVO formData() throws Exception;
	
	// 일정 삽입
	public void write(ScheduleVO vo) throws Exception;

}
