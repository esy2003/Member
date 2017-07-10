package com.hanbit.member.service;


import com.hanbit.member.domain.MemberBean;

public interface MemberService {
	public void addMember(MemberBean member);
	public MemberBean[] getMembers();
	public int countMembers();
	public MemberBean findById(String id);
	public MemberBean[] findByName(String name);
	public void updatePass(MemberBean member);
	public void delete(String id);
}
