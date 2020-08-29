package com.crecruit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crecruit.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	// 連番チームIDの次の値を取得する
	@Query(value = "SELECT nextval('team_team_id_seq')", nativeQuery = true)
	public Integer getNextSeriesId();

	// 全チームを検索する
	public Page<Team> findAll(Pageable pageable);

	// 検索条件からチームを検索する

}
