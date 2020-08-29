package com.crecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crecruit.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	// 連番メンバーIDの次の値を取得する
		@Query(value = "SELECT nextval('member_member_id_seq')", nativeQuery = true)
		Integer getNextSeriesId();

}
