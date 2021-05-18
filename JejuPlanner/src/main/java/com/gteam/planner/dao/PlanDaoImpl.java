package com.gteam.planner.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.planner.domain.PlanVO;

@Repository
public class PlanDaoImpl implements PlanDao {
	
	@Autowired
	private SqlSession sql;
	private static String namespace = "com.gteam.planner.mappers.plan";
	
	//게시판용 계획 목록
	@Override
	public List<PlanVO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}
	
	//유저별 계획 목록
	@Override
	public List<PlanVO> listForUser(String userId) throws Exception{
		return sql.selectList(namespace + ".listForUser", userId);
	}

}
