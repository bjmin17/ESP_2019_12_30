

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

