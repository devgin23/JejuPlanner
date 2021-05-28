package com.gteam.planner.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.planner.controller.ScheduleController;
import com.gteam.planner.domain.ScheduleVO;

@Repository
public class ScheduleDaoImpl implements ScheduleDao{
	
	@Autowired
	private SqlSession sql;
	private static String namespace = "com.gteam.planner.mappers.schedule";
	
	//일정 목록
	@Override
	public List<ScheduleVO> scheduleList(int planNo) throws Exception {
		System.out.println("스케줄DAO 인자 확인 " + planNo);
		return sql.selectList(namespace + ".scheduleList", planNo);
	}
	
}
