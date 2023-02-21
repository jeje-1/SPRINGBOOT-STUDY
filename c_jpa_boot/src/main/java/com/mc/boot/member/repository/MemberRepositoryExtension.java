package com.mc.boot.member.repository;

import java.util.List;

import com.mc.boot.member.Member;
import com.mc.boot.rent.Rent;

public interface MemberRepositoryExtension {

	List<Member> subQuery();

}
