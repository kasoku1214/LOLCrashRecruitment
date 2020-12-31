package com.crecruit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@Column(name = "recruited_role_1")
	private Integer recruitedRole1;

	@Column(name = "recruited_role_2")
	private Integer recruitedRole2;

	@Column(name = "recruited_role_3")
	private Integer recruitedRole3;

	@Column(name = "recruited_role_4")
	private Integer recruitedRole4;

	@Column(name = "team_introduction")
	private String teamIntroduction;

	@Column(name = "password")
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
	private List<Member> memberList;

}
