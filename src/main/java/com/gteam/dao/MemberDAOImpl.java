package com.gteam.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gteam.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sql;
	
	private final String namespace="com.gteam.mappers.member";
	private Logger log;
	
	//회원가입
	@Override
	public void register(MemberVO vo) {
		try {
			sql.insert(namespace+".register", vo);
		}catch(Exception e){
			e.printStackTrace();
			log.info("DAO에서 DB접근 중 에러발생 : register");
		}
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sql.selectOne(namespace+".loginMapper", vo);
	}

	@Override
	public int idCheck(MemberVO vo) throws Exception {
		return sql.selectOne(namespace+".idCheck", vo);
	}
}
