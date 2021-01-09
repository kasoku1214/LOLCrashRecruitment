package com.crecruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "summoner")
public class Summoner {

	@Id
	@Column(name = "summoner_id")
	private Integer summonerId;

	@Column(name = "summoner_name")
	private String summonerName;

	@Column(name = "role_code_1")
	private Integer roleCode1;

	@Column(name = "rank_code")
	private Integer rankCode;

	@Column(name = "team_id")
	private Integer teamId;

}
