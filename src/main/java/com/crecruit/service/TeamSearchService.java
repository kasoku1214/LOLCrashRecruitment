package com.crecruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crecruit.entity.Team;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamSearchService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	public Page<Team> searchAllTeam(Pageable pageable) {
		// 全チームを検索する
		return teamRepository.findAll(pageable);
	}
}
