package com.crecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crecruit.entity.Summoner;
import com.crecruit.entity.Team;
import com.crecruit.repository.SummonerRepository;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamRegisterService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	// メンバーリポジトリ
	@Autowired
	private SummonerRepository summonerRepository;

	@Transactional
	public String CreateTeam(Team team, List<Summoner> summonerList) {

		String messageText = null;

		// チームIDを生成し、teamに設定
		Integer teamId = teamRepository.getNextSeriesId();
		team.setTeamId(teamId);

		// チームを登録
		teamRepository.save(team);

		// 以下メンバーの登録
		for (Summoner summoner: summonerList) {
			// サモナーIDの生成
			Integer summmonerId = summonerRepository.getNextSeriesId();

			// サモナーIDをsummonerに設定
			summoner.setSummonerId(summmonerId);

			// チームIDをsummonerに設定
			summoner.setTeamId(teamId);

			// メンバーを登録
			summonerRepository.save(summoner);
		}
		return messageText;
	}
}
