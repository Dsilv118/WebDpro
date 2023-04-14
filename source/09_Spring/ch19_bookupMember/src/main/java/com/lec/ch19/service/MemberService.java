package com.lec.ch19.service;

import com.lec.ch19.model.Member;

public interface MemberService {
	public int idConfirm(String mid);
	public int joinMember(Member member);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member);
}
