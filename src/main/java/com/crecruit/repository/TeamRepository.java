package com.crecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crecruit.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	// 連番チームIDの次の値を取得する
	@Query(value = "SELECT nextval('team_team_id_seq')", nativeQuery = true)
	public Integer getNextSeriesId();

	// 全チームを検索する
	@Query(value = "SELECT * FROM team", nativeQuery = true)
	public List<Team> findAllTeam();

	// 検索条件(rankCode,roleCode)からチームを検索する
	@Query(value = "SELECT * FROM team WHERE (team.is_recruited_top = :isRecruitedTop OR "
			+ "team.is_recruited_jg = :isRecruitedJG OR team.is_recruited_mid = :isRecruitedMid OR "
			+ "team.is_recruited_bot = :isRecruitedBot OR team.is_recruited_sup = :isRecruitedSup) AND "
			+ "team.max_rank >= :rankCode AND team.min_rank <= :rankCode", nativeQuery = true)
	public List<Team> findByRoleCodeAndRankCode(@Param("isRecruitedTop") Integer isRecruitedTop,
			@Param("isRecruitedJG") Integer isRecruitedJG, @Param("isRecruitedMid") Integer isRecruitedMid,
			@Param("isRecruitedBot") Integer isRecruitedBot, @Param("isRecruitedSup") Integer isRecruitedSup,
			@Param("rankCode") Integer rankCode);

	// 検索条件(roleCode)からチームを検索する
	@Query(value = "SELECT * FROM team WHERE (team.is_recruited_top = :isRecruitedTop OR "
			+ "team.is_recruited_jg = :isRecruitedJG OR team.is_recruited_mid = :isRecruitedMid OR "
			+ "team.is_recruited_bot = :isRecruitedBot OR team.is_recruited_sup = :isRecruitedSup)", nativeQuery = true)
	public List<Team> findByRoleCode(@Param("isRecruitedTop") Integer isRecruitedTop,
			@Param("isRecruitedJG") Integer isRecruitedJG, @Param("isRecruitedMid") Integer isRecruitedMid,
			@Param("isRecruitedBot") Integer isRecruitedBot, @Param("isRecruitedSup") Integer isRecruitedSup);

	// 検索条件(rankCode)からチームを検索する
	@Query(value = "SELECT * FROM team WHERE team.max_rank >= :rankCode AND team.min_rank <= :rankCode", nativeQuery = true)
	public List<Team> findByRankCode(@Param("rankCode") Integer rankCode);

}
