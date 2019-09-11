// 条件查询(判断时间格式是否正确)
function findAttend() {
	//设置时间格式
	var reg = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/;
	
	var signInStr = $("#signInStr").val();
	var signOutStr = $("#signOutStr").val();
	if (signInStr != '' && !reg.test(signInStr)) {
		alert("输入的签到时期格式有误，正确格式为：YYYY-MM-DD");
		return;
	}
	if (signOutStr != '' && !reg.test(signOutStr)) {
		alert("输入的签退时期格式有误，正确格式为：YYYY-MM-DD");
		return;
	}
	if (signInStr != '' && signOutStr != '') {
		// 部分火狐浏览器不兼容 YYYY-MM-DD格式
		signInStr = signInStr.replace(/-/g,"/");
		signOutStr = signOutStr.replace(/-/g,"/");
		var signIn = new Date(signInStr);
		var signOut = new Date(signOutStr);
		if (signIn.getTime() > signOut.getTime()) {
			alert("签退日期不能早于签到日期");
			return;
		}
	}
	
	$("#attendForm").submit();
}

// 分页查询
function attendPage(page) {
	$("#pageNo").val(page);
	findAttend();
}



/**
 * 签到
 * @param path
 */
function attendSignIn(path) {
	$.ajax({
		url:"/signin/signin",
		type: "POST",
		dataType: "TEXT",
		success: function(data) {
			if (data == '2') {
				alert("今天已经签到过了，不可重复签到！");
			} else if (data == '0') {
				alert("签到失败！");
			} else {
				alert("签到成功！");
				window.location.href ="/signin/attendance";
			}
		}, error: function(data) {
			alert("系统错误，请联系管理员！");
		}
	});
}

/**
 * 签退
 * @param path
 */
function atttendSignOut(path) {
	$.ajax({
		url:"/signin/signout",
		type: "POST",
		dateType: "TEXT",
		success: function(data) {
			if (data == 2) {
				alert("还没有签到呢，请先签到");
			} else if (data == 0) {
				alert("签退失败！");
			}else if (data == 3) {
				alert("今天已经签退过了，不可重复签退！");
			} else {
				alert("签退成功！");
				window.location.href ="/signin/attendance";
			}
		}, error: function(data) {
			alert("系统错误，请联系管理员！");
		}
	});
}