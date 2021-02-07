
/*
 * 更新時確認メソッド
 */
function alertEdit() {

	// 更新の確認ポップアップ
	if (window.confirm("この内容で更新しますか？")) {

		// 更新前処理
		return prepareEdit();

		return true;
	} else {
		return false;
	}
}

/*
 * 更新前処理
 */
function prepareEdit() {
	// チーム名の前後空白を削除
	var teamName = document.getElementsByClassName("team_name_input");
	teamName[0].value = teamName[0].value.trim();

	if (teamName[0].value === "") {
		window.alert("チーム名を入力してください。");
		return false;
	}


	// サモナー名の前後空白を削除
	var summonerNameCollections = document.getElementsByClassName("summoner_name_input");
	var summonerNameArray = Array.from(summonerNameCollections);
	summonerNameArray.forEach(summonerName => {
		summonerName.value = summonerName.value.trim();
	});

	// 紹介文の前後空白を削除
	var teamIntroduction = document.getElementsByClassName("team_intro_textarea");
	teamIntroduction[0].value = teamIntroduction[0].value.trim();
}