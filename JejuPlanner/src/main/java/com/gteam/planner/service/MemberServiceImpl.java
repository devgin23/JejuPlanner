package com.gteam.planner.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gteam.planner.dao.MemberDAO;
import com.gteam.planner.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO  dao;
	
	private Logger log;
	
	//회원가입
	@Override
	public void register(MemberVO vo){
		try {
			dao.register(vo);
		}catch(Exception e) {
			e.printStackTrace();
			log.info("Service에서 DAO호출 시 오류 발생");
		}
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}

	@Override
	public int idCheck(MemberVO vo) throws Exception {
		return dao.idCheck(vo);
	}
}
