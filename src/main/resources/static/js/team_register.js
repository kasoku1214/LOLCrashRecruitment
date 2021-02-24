
function alertRegistration() {

	if (checkMaxMinRank()) {

	} else {
		alert("募集ランクを正しく入力してください");
		return false;
	}

	if (window.confirm("この内容で募集しますか？")) {
		return prepareRegister();

		return true;
	} else {
		return false;
	}

}

/*
 * 更新前処理
 */
function prepareRegister() {
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

/*
 * 最大ランク、最小ランクの生合成チェック
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
