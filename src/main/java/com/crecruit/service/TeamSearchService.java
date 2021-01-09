package com.crecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crecruit.entity.Team;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamSearchService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	public List<Team> searchAllTeam() {
		// 全チームを検索する
		return teamRepository.findAllTeam();
	}
}
