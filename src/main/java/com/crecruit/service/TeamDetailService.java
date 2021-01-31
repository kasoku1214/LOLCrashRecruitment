package com.crecruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crecruit.entity.Team;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamDetailService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	/**
	 * チーム名からチームの検索メソッド
	 * @return チームorNUll
	 */
	public Team findByTeamId(Integer teamId) {
		// 全チームを検索する
		return teamRepository.findById(teamId).orElse(null);
	}
}
