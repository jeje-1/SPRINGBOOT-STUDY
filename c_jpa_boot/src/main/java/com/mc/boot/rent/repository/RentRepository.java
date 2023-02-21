package com.mc.boot.rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.mc.boot.rent.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>, RentRepositoryExtension{
	
	//대출 건 제목이 '디디'로 시작하거나 대출자가 jpa인 모든 대출건을 조회
	@EntityGraph(value="Rent.rentBooks", type= EntityGraphType.FETCH)
	List<Rent> findByTitleStartsWithOrMemberUserIdEquals(String title, String userId);

}
