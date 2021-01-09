package com.crecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crecruit.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	// 連番チームIDの次の値を取得する
	@Query(value = "SELECT nextval('team_team_id_seq')", nativeQuery = true)
	public Integer getNextSeriesId();

	// 検索条件からチームを検索する
	@Query(value = "SELECT * from team LEFT OUTER JOIN summoner ON team.team_id = summoner.team_id", nativeQuery = true)
	public List<Team> findAllTeam();

}
