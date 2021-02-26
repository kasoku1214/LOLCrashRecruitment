
/*
 * 更新時確認メソッド
 */
function alertEdit() {

	// 募集ランクの入力チェック
	if (checkMaxMinRank()) {

	} else {
		alert("募集ランクを正しく入力してください");
		return false;
	}

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

	// チーム名が空になっていないか判定
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

	// 全てのサモナー名が空になっていないか判定
	var summonerNullFlag = summonerNameArray.every(summonerName => {
		return summonerName.value == "";
	});

	// 全てのサモナー名が空なら遷移させない
	if (summonerNullFlag) {
		window.alert("サモナー名を入力してください。");
		return false;
	}

	// 紹介文の前後空白を削除
	var teamIntroduction = document.getElementsByClassName("team_intro_textarea");
	teamIntroduction[0].value = teamIntroduction[0].value.trim();
}

/*
 * 最大ランク、最小ランクの整合性チェック
 */
function checkMaxMinRank(){
	var maxRank = document.getElementById("maxRank").value;
	var minRank = document.getElementById("minRank").value;

	if (Number(maxRank) < Number(minRank) || Number(maxRank) == 0 || Number(minRank) == 0) {
		return false;
	} else {
		return true;
	}
}