package com.gteam.planner.service;

import com.gteam.planner.domain.MemberVO;

public interface MemberService {
	//회원가입
	public void register(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	//아이디 중복 체크
	public int idCheck(MemberVO vo) throws Exception;
}
