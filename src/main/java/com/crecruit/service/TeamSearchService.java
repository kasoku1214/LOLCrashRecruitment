package com.crecruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crecruit.entity.Team;
import com.crecruit.form.TeamSearchForm;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamSearchService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	/**
	 * 全チーム検索メソッド
	 * @return 全チームリスト
	 */
	public Page<Team> searchAllTeam(Pageable pageable) {
		// 全チームを検索する
		return teamRepository.findAllTeam(pageable);
	}

	/**
	 * チーム検索メソッド
	 * @param teamSearchForm チーム検索条件
	 * @return チーム検索結果リスト
	 */
	public Page<Team> searchTeam(TeamSearchForm teamSearchForm, Pageable pageable) {

		// 検索用isRecruitedRole
		Integer isRecruitedTop = 99;
		Integer isRecruitedJG = 99;
		Integer isRecruitedMid = 99;
		Integer isRecruitedBot = 99;
		Integer isRecruitedSup = 99;

		// 検索条件からRole条件を抽出
		switch (teamSearchForm.getRoleCode()) {
		case 0:
			break;
		case 1:
			isRecruitedTop = 1;
			break;
		case 2:
			isRecruitedJG = 1;
			break;
		case 3:
			isRecruitedMid = 1;
			break;
		case 4:
			isRecruitedBot = 1;
			break;
		case 5:
			isRecruitedSup = 1;
			break;
		default:
			break;
		}

		// 検索条件のランクとロール、チーム名の入力状況を判定

		if (!teamSearchForm.getTeamName().equals("")) {
			// チーム名が入力されている場合
			// この場合はチーム名という条件のみから部分一致検索
			return teamRepository.findByTeamNameContainingIgnoreCaseOrderByUpdatedAtDesc(teamSearchForm.getTeamName(), pageable);
		} else if (teamSearchForm.getRankCode() != 0 && teamSearchForm.getRoleCode() != 0) {
			// ランクとロールがどちらも入力されている場合
			return teamRepository.findByRoleCodeAndRankCode(isRecruitedTop, isRecruitedJG, isRecruitedMid,
					isRecruitedBot, isRecruitedSup, teamSearchForm.getRankCode(), pageable);
		} else if (teamSearchForm.getRankCode() == 0 && teamSearchForm.getRoleCode() != 0) {
			// ロールのみが入力されている場合
			return teamRepository.findByRoleCode(isRecruitedTop, isRecruitedJG, isRecruitedMid,
					isRecruitedBot, isRecruitedSup, pageable);
		} else if (teamSearchForm.getRoleCode() == 0 && teamSearchForm.getRankCode() != 0) {
			// ランクのみが入力されている場合
			return teamRepository.findByRankCode(teamSearchForm.getRankCode(), pageable);
		}

		// ランクとロールがどちらも入力されていない時は全件検索
		return teamRepository.findAllTeam(pageable);
	}
}
