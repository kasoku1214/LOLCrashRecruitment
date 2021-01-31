package com.crecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Team> searchAllTeam() {
		// 全チームを検索する
		return teamRepository.findAllTeam();
	}

	/**
	 * チーム検索メソッド
	 * @param teamSearchForm チーム検索条件
	 * @return チーム検索結果リスト
	 */
	public List<Team> searchTeam(TeamSearchForm teamSearchForm) {

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

		// 検索条件のランクとロールの入力状況を判定
		if (teamSearchForm.getRankCode() != 0 && teamSearchForm.getRoleCode() != 0) {
			// ランクとロールがどちらも入力されている場合
			return teamRepository.findByRoleCodeAndRankCode(isRecruitedTop, isRecruitedJG, isRecruitedMid,
					isRecruitedBot, isRecruitedSup, teamSearchForm.getRankCode());
		} else if (teamSearchForm.getRankCode() == 0 && teamSearchForm.getRoleCode() != 0) {
			// ロールのみが入力されている場合
			return teamRepository.findByRoleCode(isRecruitedTop, isRecruitedJG, isRecruitedMid,
					isRecruitedBot, isRecruitedSup);
		} else if (teamSearchForm.getRoleCode() == 0 && teamSearchForm.getRankCode() != 0) {
			// ランクのみが入力されている場合
			return teamRepository.findByRankCode(teamSearchForm.getRankCode());
		}

		// ランクとロールがどちらも入力されていない時は全件検索
		return teamRepository.findAllTeam();
	}
}
