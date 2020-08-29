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
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "member_id")
	Integer memberId;

	@Column(name = "summoner_name")
	String summonerName;

	@Column(name = "role_code_1")
	Integer roleCode1;

	@Column(name = "role_code_2")
	Integer roleCode2;

	@Column(name = "team_id")
	Integer teamId;

	@Column(name = "info_address")
	String infoAddress;

	@Column(name = "leader_flag")
	Integer leaderFlag;

}
