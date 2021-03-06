package com.crecruit.enumclass;

public enum Role {

	// トップ
	TOP(1, "Top"),

	// ジャングル
	JG(2, "JG"),

	// ミッド
	MID(3, "Mid"),

	// ボット
	BOT(4, "Bot"),

	// サポート
	SUP(5, "Sup");

	// ロールコード
	private int roleCode;

	// ロール名
	private String roleName;

	// コンストラクタ
	Role(int roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	}

	// ゲッター
	public int getRoleCode() {
		return this.roleCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	//roleCodeからroleNameを返すメソッド
	public static String getRoleNameByRoleCode(int roleCode) {
		for (Role role : Role.values()) {
			if (role.getRoleCode() == roleCode) {
				return role.getRoleName();
			}
		}
		// 見つからなかったらnullを返す
		return null;
	}
}
