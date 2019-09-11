/**
 * 添加用户
 * @returns {Boolean}
 */
function userAdd() {
	
	return dateVerify();
}

/**
 * 修改用户信息
 * @returns {Boolean}
 */
function userUpdate() {

	return dateVerify();
}

/**
 * 删除用户信息
 * @param path 路径前缀
 * @param id
 */
function userDel(path, id) {
	if (confirm("确定删除吗")){
		$.ajax({
			url: path + "/userInfo/del/user.action",
			type: "POST",
			data: {id: id},
			dataType: "text",
			success: function(data) {
				alert(data);
				window.location.href = path + "/userInfo/find/user/list.action";
			},error: function(data) {
				alert("系统错误，请联系管理员");
			}
		});
	}
}


/**
 * 验证用户信息
 * @returns {Boolean}
 */
function dateVerify() {
	var account = $("#account").val();
	var realName = $("#realName").val();
	var age = $("#age").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var birthday = $("#birthday").val();
	var identity = $("#identity").val();
	var entryTime = $("#entryTime").val();
	
	if (account == '') {
		alert("帐号不允许为空！");
		return false;
	}
	if (realName == '') {
		alert("姓名不允许为空！");
		return false;
	}
	if (age == '') {
		alert("年龄不允许为空！");
		return false;
	}
	var numberVer = /^\+?[1-9][0-9]*$/;
	if (!numberVer.test(age)) {
		alert("年龄必须为非零正整数");
		return false;
	}
	var mobileVer = /^((1[3|4|5|7|8][0-9]{1})+\d{8})$/;
	if (mobile != '') {
		if (!mobileVer.test(mobile)) {
			alert("请输入正确的手机号！");
			return false;
		}
	}
	var emailVer = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if (email != '') {
		if (!emailVer.test(email)) {
			alert("请输入正确的邮箱！");
			return false;
		}
	}
	var birthdayVer = /^((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))$/;
	if (birthday != '' && !birthdayVer.test(birthday)){
		alert("请输入正确的生日格式");
		return false;
	}
	var identityVer = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
	if (identity != '' && !identityVer.test(identity)) {
		alert("请输入正确的身份证号！");
		return false;
	}
	if (entryTime != '') {
		var date_ymd = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		if (!date_ymd.test(entryTime)) {
			alert("请输入正确的入职日期格式！");
			return false;
		}
	}
	
	return true;
}