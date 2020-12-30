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
@Table(name = "team")
public class Team {

	@Id
	@Column(name = "team_id")
	Integer teamId;

	@Column(name = "team_name")
	String teamName;

	@Column(name = "max_rank")
	Integer maxRank;

	@Column(name = "min_rank")
	Integer minRank;

	@Column(name = "recruited_role_1")
	Integer recruitedRole1;

	@Column(name = "recruited_role_2")
	Integer recruitedRole2;

	@Column(name = "recruited_role_3")
	Integer recruitedRole3;

	@Column(name = "recruited_role_4")
	Integer recruitedRole4;

	@Column(name = "team_introduction")
	String teamIntroduction;

	@Column(name = "password")
	String password;

}
