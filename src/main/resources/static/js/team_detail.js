window.onload = function() {
	// サモナーのランクタグに色をつける
	for (i = 0; true; i++) {
		// rankタグに色をつける
		var idName = 'detail_summoner_rank' + i;
		var rankTag = document.getElementById(idName);

		if (rankTag == undefined) {
			break;
		}

		changeRankColor(rankTag);
	}

	// 募集ランクに色をつける

}

//
function changeRankColor(rankObj) {
	var isColorChanged = false;

	var rankText = rankObj.textContent;
	// 文字列が含まれていて、かつ、isColorChangedがfalseの時
	if (rankText.indexOf('Iron') != -1 && !isColorChanged) {
		rankObj.classList.add('iron');
		isColorChanged = true;
	}
	if (rankText.indexOf('Bronze') != -1 && !isColorChanged) {
		rankObj.classList.add('bronze');
		isColorChanged = true;
	}
	if (rankText.indexOf('Silver') != -1 && !isColorChanged) {
		rankObj.classList.add('silver');
		isColorChanged = true;
	}
	if (rankText.indexOf('Gold') != -1 && !isColorChanged) {
		rankObj.classList.add('gold');
		isColorChanged = true;
	}
	if (rankText.indexOf('Plat') != -1 && !isColorChanged) {
		rankObj.classList.add('platinum');
		isColorChanged = true;
	}
	if (rankText.indexOf('Dia') != -1 && !isColorChanged) {
		rankObj.classList.add('diamond');
		isColorChanged = true;
	}
	if (rankText.indexOf('GrandMaster') != -1 && !isColorChanged) {
		rankObj.classList.add('grandmaster');
		isColorChanged = true;
	}
	if (rankText.indexOf('Master') != -1 && !isColorChanged) {
		rankObj.classList.add('master');
		isColorChanged = true;
	}
	if (rankText.indexOf('Challenger') != -1 && !isColorChanged) {
		rankObj.classList.add('challenger');
		isColorChanged = true;
	}
}
