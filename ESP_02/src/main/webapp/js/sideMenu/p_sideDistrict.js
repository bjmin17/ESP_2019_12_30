
$(document).ready(function() {

	if (disSideSlideSW == 1) { // 상황에 따른 드롭다운

		var submenu = $(".columnSideDistrictDrop");

		submenu.slideDown();

	}

	if (disSideSlideSW == 2) {

		var submenu = $(".columnSideProvinceDrop");

		submenu.slideDown();

	}

	if (sideColorBold == "seoul") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideSeoul").css("font-weight", "bold");

	}

	if (sideColorBold == "gyeonggi") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideGyeonggi").css("font-weight", "bold");

	}

	if (sideColorBold == "incheon") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideIncheon").css("font-weight", "bold");

	}
	
	if (sideColorBold == "busan") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideBusan").css("font-weight", "bold");

	}
	
	if (sideColorBold == "daejeon") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideDaejeon").css("font-weight", "bold");

	}
	
	if (sideColorBold == "gwangju") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideGwangju").css("font-weight", "bold");

	}
	
	if (sideColorBold == "ulsan") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideUlsan").css("font-weight", "bold");

	}
	
	if (sideColorBold == "daegu") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideDaegu").css("font-weight", "bold");

	}
	
	if (sideColorBold == "gyeonggi") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideGyeonggi").css("font-weight", "bold");

	}
	
	if (sideColorBold == "gangwon") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideGangwon").css("font-weight", "bold");

	}
	
	if (sideColorBold == "chungbuk") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideChungbuk").css("font-weight", "bold");

	}
	
	if (sideColorBold == "chungnam") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideChungnam").css("font-weight", "bold");

	}
	
	if (sideColorBold == "jeonbuk") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideJeonbuk").css("font-weight", "bold");

	}
	
	if (sideColorBold == "jeonnam") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideJeonnam").css("font-weight", "bold");

	}
	
	if (sideColorBold == "gyeongbuk") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideGyeongbuk").css("font-weight", "bold");

	}
	
	if (sideColorBold == "gyeongnam") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideGyeongnam").css("font-weight", "bold");

	}
	
	if (sideColorBold == "jeju") { // 상황에 따른 사이드메뉴 폰트굵기

		$("#sideJeju").css("font-weight", "bold");

	}


	$(".columnSideDistrictMenu").click(function() {
		var submenu = $(this).next("div");

		if (submenu.is(":visible")) {
			submenu.slideUp();
		} else {
			submenu.slideDown();
		}

		return false;
	});

	$(".columnSideProvinceMenu").click(function() {
		var submenu = $(this).next("div");

		if (submenu.is(":visible")) {
			submenu.slideUp();
		} else {
			submenu.slideDown();
		}

		return false;
	});

});
