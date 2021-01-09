window.onload = function() {
	// ランクタグに色をつける
	for (i = 0; true; i++) {
		// minRankタグに色をつける
		var idName = 'minRank' + i;
		var minRank = document.getElementById(idName);

		if (minRank == undefined) {
			break;
		}

		changeRankColor(minRank);

	}

	// maxRankタグに色をつける
	for (i = 0; true; i++) {
		var idName = 'maxRank' + i;
		var maxRank = document.getElementById(idName);

		if (maxRank == undefined) {
			break;
		}

		changeRankColor(maxRank);
	}

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
