package com.crecruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crecruit.entity.Member;
import com.crecruit.entity.Team;
import com.crecruit.repository.MemberRepository;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamSearchService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	// メンバーリポジトリ
	@Autowired
	private MemberRepository memberRepository;

	// チームとメンバーを登録する
	public String CreateTeam(Team team, Member member) {

		String messageText = null;

		// メンバーIDを生成し、memberに設定
		Integer memberId = memberRepository.getNextSeriesId();
		member.setMemberId(memberId);

		// チームIDを生成し、teamとmemberに設定
		Integer teamId = teamRepository.getNextSeriesId();
		team.setTeamId(teamId);
		member.setTeamId(teamId);

		// メンバーの情報を整形
		if (member.getInfoAddress() == null || member.getInfoAddress() == "") {
			member.setInfoAddress("https://jp.op.gg/summoner/userName=" + member.getSummonerName());
		}
		// 取り急ぎリーダーにする
		member.setLeaderFlag(1);

		// チームを登録
		teamRepository.save(team);

		// メンバーを登録
		memberRepository.save(member);

		return messageText;
	}

	public Page<Team> searchAllTeam(Pageable pageable) {
		// 全チームを検索する
		return teamRepository.findAll(pageable);
	}
}
