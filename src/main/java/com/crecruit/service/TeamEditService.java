package com.crecruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crecruit.entity.Summoner;
import com.crecruit.entity.Team;
import com.crecruit.repository.SummonerRepository;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamEditService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	// サモナーリポジトリ
	@Autowired
	private SummonerRepository summonerRepository;

	/**
	 * チームIDからチームの検索メソッド
	 * @return チームorNUll
	 */
	public Team findByTeamId(Integer teamId) {
		// 全チームを検索する
		return teamRepository.findById(teamId).orElse(null);
	}

	@Transactional
	public String editTeam(Team team) {

		String messageText = null;

		// 以下メンバーの登録
		for (Summoner summoner: team.getSummonerList()) {
			// 新規サモナーか判定
			if (summoner.getSummonerId() == null) {
				// サモナーIDの生成
				Integer summmonerId = summonerRepository.getNextSeriesId();
				// サモナーIDをsummonerに設定
				summoner.setSummonerId(summmonerId);
			}

			// チームIDをsummonerに設定
			summoner.setTeamId(team.getTeamId());
		}

		// チームを登録
		teamRepository.save(team);

		return messageText;
	}

}
