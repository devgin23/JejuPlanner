package com.gteam.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gteam.planner.dao.ScheduleDAO;
import com.gteam.planner.domain.ScheduleVO;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDAO dao;
	
	//일정 목록 출력
	@Override
	public List<ScheduleVO> list() throws Exception {
		return dao.list();
	}
	
	//일정 객체 출력
	@Override
	public ScheduleVO formData() throws Exception {
		return dao.list().get(0);
	}
	
	//일정 삽입
	@Override
	public void write(ScheduleVO vo) throws Exception {
		dao.write(vo);
	}

}
