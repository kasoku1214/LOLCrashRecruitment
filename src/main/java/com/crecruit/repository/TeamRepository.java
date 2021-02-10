package com.crecruit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Query(value = "SELECT * FROM team ORDER BY updated_at DESC", nativeQuery = true)
	public Page<Team> findAllTeam(Pageable pageable);

	// 検索条件(rankCode,roleCode)からチームを検索する
	@Query(value = "SELECT * FROM team WHERE (team.is_recruited_top = :isRecruitedTop OR "
			+ "team.is_recruited_jg = :isRecruitedJG OR team.is_recruited_mid = :isRecruitedMid OR "
			+ "team.is_recruited_bot = :isRecruitedBot OR team.is_recruited_sup = :isRecruitedSup) AND "
			+ "team.max_rank >= :rankCode AND team.min_rank <= :rankCode ORDER BY updated_at DESC", nativeQuery = true)
	public Page<Team> findByRoleCodeAndRankCode(@Param("isRecruitedTop") Integer isRecruitedTop,
			@Param("isRecruitedJG") Integer isRecruitedJG, @Param("isRecruitedMid") Integer isRecruitedMid,
			@Param("isRecruitedBot") Integer isRecruitedBot, @Param("isRecruitedSup") Integer isRecruitedSup,
			@Param("rankCode") Integer rankCode, Pageable pageable);

	// 検索条件(roleCode)からチームを検索する
	@Query(value = "SELECT * FROM team WHERE (team.is_recruited_top = :isRecruitedTop OR "
			+ "team.is_recruited_jg = :isRecruitedJG OR team.is_recruited_mid = :isRecruitedMid OR "
			+ "team.is_recruited_bot = :isRecruitedBot OR team.is_recruited_sup = :isRecruitedSup) "
			+ "ORDER BY updated_at DESC", nativeQuery = true)
	public Page<Team> findByRoleCode(@Param("isRecruitedTop") Integer isRecruitedTop,
			@Param("isRecruitedJG") Integer isRecruitedJG, @Param("isRecruitedMid") Integer isRecruitedMid,
			@Param("isRecruitedBot") Integer isRecruitedBot, @Param("isRecruitedSup") Integer isRecruitedSup,
			Pageable pageable);

	// 検索条件(rankCode)からチームを検索する
	@Query(value = "SELECT * FROM team WHERE team.max_rank >= :rankCode AND team.min_rank <= :rankCode "
			+ "ORDER BY updated_at DESC", nativeQuery = true)
	public Page<Team> findByRankCode(@Param("rankCode") Integer rankCode, Pageable pageable);

}
