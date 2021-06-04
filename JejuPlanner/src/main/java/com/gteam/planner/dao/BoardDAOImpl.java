package com.gteam.planner.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sql;
	private static String namespace = "com.gteam.planner.mappers.schedule";
	
	
	
}
