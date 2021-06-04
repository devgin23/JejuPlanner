package com.gteam.planner.dao;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sql;
	private static String namespace = "com.gteam.planner.mappers.board";
	
	//계획 총 갯수
	@Override
	public int boardPlanCount(String searchType, String keyword) throws Exception {
		Map<String, String> map = new HashMap<>();
		
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		
		return sql.selectOne(namespace+".boardPlanCount", map);
	}
	
	
	
}
