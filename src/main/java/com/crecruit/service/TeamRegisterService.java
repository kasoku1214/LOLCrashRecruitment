package com.crecruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crecruit.entity.Member;
import com.crecruit.entity.Team;
import com.crecruit.repository.MemberRepository;
import com.crecruit.repository.TeamRepository;

@Service
public class TeamRegisterService {

	// チームリポジトリ
	@Autowired
	private TeamRepository teamRepository;

	// メンバーリポジトリ
	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public String CreateTeam(Team team, Member member) {

		String messageText = null;

		// メンバーIDを生成し、memberに設定
		Integer memberId = memberRepository.getNextSeriesId();
		member.setMemberId(memberId);

		// チームIDを生成し、teamとmemberに設定
		Integer teamId = teamRepository.getNextSeriesId();
		team.setTeamId(teamId);
		member.setTeamId(teamId);

		// チームを登録
		teamRepository.save(team);

		// メンバーを登録
		memberRepository.save(member);

		return messageText;
	}
}
