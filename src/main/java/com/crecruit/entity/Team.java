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

	@Column(name = "team_memo")
	String teamMemo;

	@Column(name = "team_introduction")
	String teamIntroduction;

	@Column(name = "password")
	String password;

}
