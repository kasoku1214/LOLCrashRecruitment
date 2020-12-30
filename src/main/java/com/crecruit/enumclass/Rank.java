package com.crecruit.enumclass;

public enum Rank {

	//any
	ANY(0, "all"),

	// アイアン
	IRON4(1, "Iron 4"),
	IRON3(2, "Iron 3"),
	IRON2(3, "Iron 2"),
	IRON1(4, "Iron 1"),

	// シルバー
	SILVER4(5, "Silver 4"),
	SILVER3(6, "Silver 3"),
	SILVER2(7, "Silver 2"),
	SILVER1(8, "Silver 1"),

	// ゴールド
	GOLD4(9, "Gold 4"),
	GOLD3(10, "Gold 3"),
	GOLD2(11, "Gold 2"),
	GOLD1(12, "Gold 1"),

	// プラチナ
	PLATINUM4(13, "Plat 4"),
	PLATINUM3(14, "Plat 3"),
	PLATINUM2(15, "Plat 2"),
	PLATINUM1(16, "Plat 1"),

	// ダイアモンド
	DIAMOND4(17, "Dia 4"),
	DIAMOND3(18, "Dia 3"),
	DIAMOND2(19, "Dia 2"),
	DIAMOND1(20, "Dia 1");

	// ランクコード
	private int rankCode;

	// ランク表示名
	private String rankName;

	// コンストラクタ
	Rank(int rankCode, String rankName) {
		this.rankCode = rankCode;
		this.rankName = rankName;
	}

	// ゲッター
	public int getRankCode() {
		return this.rankCode;
	}
	public String getRankName() {
		return this.rankName;
	}
}
