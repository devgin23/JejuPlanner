package com.gteam.planner.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.planner.domain.ScheduleVO;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{
	
	@Autowired
	private SqlSession sql;
	private static String namespace = "com.gteam.planner.mappers.schedule";
	
	//일정 목록
	@Override
	public List<ScheduleVO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}
	
	//일정추가
	@Override
	public void write(ScheduleVO vo) throws Exception {
		System.out.println("DAO 출력 : " + vo.getPlanNo());
		sql.insert(namespace + ".write", vo);
	}
	
}
