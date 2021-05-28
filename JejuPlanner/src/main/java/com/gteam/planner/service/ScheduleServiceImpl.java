package com.gteam.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gteam.planner.dao.ScheduleDao;
import com.gteam.planner.domain.ScheduleVO;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDao dao;
	
	//일정 목록 출력
	@Override
	public List<ScheduleVO> scheduleList(int planNo) throws Exception {
		System.out.println("스케줄 서비스 인자 확인 : " + planNo);
		return dao.scheduleList(planNo);
	}
	
	//일정 객체 출력
/*	@Override
	public ScheduleVO formData() throws Exception {
		return dao.list().get(0);
	}*/

}
