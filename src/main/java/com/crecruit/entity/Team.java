package com.crecruit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team {

	@Id
	@Column(name = "team_id")
	private Integer teamId;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "max_rank")
	private Integer maxRank;

	@Column(name = "min_rank")
	private Integer minRank;

	@Column(name = "is_recruited_top")
	private Integer isRecruitedTop;

	@Column(name = "is_recruited_jg")
	private Integer isRecruitedJG;

	@Column(name = "is_recruited_mid")
	private Integer isRecruitedMid;

	@Column(name = "is_recruited_bot")
	private Integer isRecruitedBot;

	@Column(name = "is_recruited_sup")
	private Integer isRecruitedSup;

	@Column(name = "team_introduction")
	private String teamIntroduction;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "team_id")
	private List<Summoner> summonerList;
}
