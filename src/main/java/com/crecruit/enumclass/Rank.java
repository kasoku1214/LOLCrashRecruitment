package com.crecruit.enumclass;

public enum Rank {

	// アイアン
	IRON4(1, "Iron 4"),
	IRON3(2, "Iron 3"),
	IRON2(3, "Iron 2"),
	IRON1(4, "Iron 1"),

	// ブロンズ
	BRONZE4(5, "Bronze 4"),
	BRONZE3(6, "Bronze 3"),
	BRONZE2(7, "Bronze 2"),
	BRONZE1(8, "Bronze 1"),

	// シルバー
	SILVER4(9, "Silver 4"),
	SILVER3(10, "Silver 3"),
	SILVER2(11, "Silver 2"),
	SILVER1(12, "Silver 1"),

	// ゴールド
	GOLD4(13, "Gold 4"),
	GOLD3(14, "Gold 3"),
	GOLD2(15, "Gold 2"),
	GOLD1(16, "Gold 1"),

	// プラチナ
	PLATINUM4(17, "Plat 4"),
	PLATINUM3(18, "Plat 3"),
	PLATINUM2(19, "Plat 2"),
	PLATINUM1(20, "Plat 1"),

	// ダイアモンド
	DIAMOND4(21, "Dia 4"),
	DIAMOND3(22, "Dia 3"),
	DIAMOND2(23, "Dia 2"),
	DIAMOND1(24, "Dia 1"),

	// マスター
	MASTER(25, "Master"),

	// グランドマスター
	GRANDMASTER(26, "GrandMaster"),

	// チャレンジャー
	CHALLENGER(27, "Challenger");

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

	//rankcodeからrankNameを返すメソッド
	public static String getRankNameByRankCode(int rankCode) {
		for (Rank rank : Rank.values()) {
			if (rank.getRankCode() == rankCode) {
				return rank.getRankName();
			}
		}
		// 見つからなかったらnullを返す
		return null;
	}
}
