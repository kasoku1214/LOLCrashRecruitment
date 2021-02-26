package com.crecruit.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageText {

	private String textContent;

	private String messageType;

	/*
	 * デフォルトコンストラクタ
	 * 何も表示しない場合
	 */
	public MessageText() {
		this.textContent = "";
		this.messageType = "none";
	}

	/*
	 * メッセージ格納時のコンストラクタ
	 */
	public MessageText(String textContent, String messageType) {
		this.textContent = textContent;
		this.messageType = messageType;
	}
}
