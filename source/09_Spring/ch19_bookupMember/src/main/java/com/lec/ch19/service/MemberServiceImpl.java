package com.lec.ch19.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.model.Member;

public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(Member member) {
		return memberDao.joinMember(member);
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}
