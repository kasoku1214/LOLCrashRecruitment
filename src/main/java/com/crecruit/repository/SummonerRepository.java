package com.crecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crecruit.entity.Summoner;

@Repository
public interface SummonerRepository extends JpaRepository<Summoner, Integer>{

	// 連番メンバーIDの次の値を取得する
		@Query(value = "SELECT nextval('summoner_summoner_id_seq')", nativeQuery = true)
		Integer getNextSeriesId();

}
