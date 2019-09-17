

function changeTime(time){
	    var commonTime = "";
	    if(time){
	        var unixTimestamp = new Date(time*1) ;
	        commonTime = unixTimestamp.toLocaleString();
	    }
	     return commonTime;
}
//格林尼治时间转yyyy-MM-dd HH:mm:ss
//2017-03-15t00:00:00.000+08:00->2017-03-15 00:00:00
function GMTToStr(time){
    let date = new Date(time)
    let Str=date.getFullYear() + '-' +
    ((date.getMonth() + 1)>10?(date.getMonth() + 1):("0"+(date.getMonth() + 1))) + '-' + 
    date.getDate() + ' ' + 
    date.getHours() + ':' + 
    date.getMinutes() + ':' + 
    date.getSeconds()
    return Str
}
/**
 * 添加请假
 * @param path
 */
function addOvertime(path) {
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var des = $("#des").val();
	var res =  validate();
	if (!res) return;
	$.ajax({
		url: "/leave/insert",
		type: "POST",
		data:{
			'startdate':$("#startTime").val(),
			'enddate':$("#endTime").val(),
			'ltid':$("#type").val(),
			"reason":$("#reason").val()
		},
		success: function(data) {
			if (data == 1) {
				alert("添加成功");
				$('#overtimeDivModel').remove();
				location.href = "/leave/query/null/1";
			} else if (data == '0') {
				alert("添加失败");
			} else {
				alert(data);
				location.href = path + "/overtime/list.action";
			}
		},error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}


/**
 * 请假详情
 * @param path
 * @param id
 */
function detailOvertime(path, id) {
	overtimeHTML(path, 'upd');
	$.ajax({
		url: path + "/overtime/detail.action",
		type: "POST",
		data:{id: id},
		dataType: "JSON",
		success: function(data) {
			if (data.msg != '') {
				alert(data.msg);
				return;
			}
			var overtime = data.overtime;
			$("#overtimeDivModel #overtimeId").val(overtime.id);
			$("#overtimeDivModel #startTime").val(data.startTime);
			$("#overtimeDivModel #endTime").val(data.endTime);
			$("#overtimeDivModel #des").val(overtime.des);
		}, error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}

/**
 * 修改请假
 * @param path
 */
function updPermission(uid) {
	var rid = $("#rid").val();
	if(rid==0){
		alert("权限不能为空")
		return;
	}
	$.ajax({
		url: "/permission/update",
		type: "POST",
		data:{
			"uid":uid,
			"rid":rid
		},
		success: function(data) {
			if(data==1){
				alert("修改成功")
				location.href = "/permission/query/null/1";
			}else{
				alert("系统错误，请联系管理员");
			}
		}, error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}

/**
 * 删除请假
 * @param path
 */
function delOvertime(path, id) {
	if (confirm("确定删除吗")) {
		$.ajax({
			url: path + "/overtime/delete.action",
			type: "POST",
			data:{id: id},
			dataType: "JSON",
			success: function(data) {
				alert(data.msg);
				location.href = path + "/overtime/list.action";
			}, error: function(data) {
				alert("系统错误，请联系管理员");
			}
		});
	}
}
function checkByName(){
	var name = $("#realName").val();
	if(name=="")  name="null";
	location.href="/permission/query/"+name+"/1";
}
/**
 * 验证日期格式
 */
function validate(){
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var st = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	if (startTime != '' && !st.test(startTime)){
		alert("请输入正确的开始日期格式");
		return false;
	}
	var et = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	if (endTime != '' && !et.test(endTime)){
		alert("请输入正确的结束日期格式");
		return false;
	}
	var d1 = Date.parse(startTime);
	var d2 = Date.parse(endTime);
	var date = d2 - d1;
	var time = 60*60*1000;
	if(date<0||date<time){
		alert("开始时间应小于结束时间并且间隔小于一小时,请检查!");
		return false;
	}
	return true;
}
	
/**
 * 请假HTML
 * @param path
 */
function permissionHTML(data) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var permissionHTML = '<div id="overtimeDivModel" style="' + style_ + '">';
	permissionHTML += '<div class="form-horizontal" role="form">';
	permissionHTML += '<input type="hidden" id="overtimeId" value=""/>';
	permissionHTML += '<div class="form-group">';
	permissionHTML += '<label for="startTime" class="col-sm-2 control-label">姓名</label>';
	permissionHTML += '<div class="col-sm-10">';
	permissionHTML += '<input type="text" class="form-control" id="startTime" autocomplete="off" placeholder="如：2017-04-19 08:00:00" value="'+data.uname+'">';
	permissionHTML += '</div></div>';
	permissionHTML += '<div class="form-group">';
	permissionHTML += '<label for="endTime" class="col-sm-2 control-label ">账号</label>';
	permissionHTML += '<div class="col-sm-10">';
	permissionHTML += '<input type="text" class="form-control" id="endTime" autocomplete="off" placeholder="如：2017-04-19 18:00:00" value="'+data.account+'">';
	permissionHTML += '</div></div>';
	permissionHTML += '<div class="form-group">';
	permissionHTML += '<label for="des" class="col-sm-2 control-label">权限</label>';
	permissionHTML += '<div class="col-sm-10">';
	permissionHTML +='<select id="rid" >';
	permissionHTML += '<option value ="'+data.rid+'" >初始权限：'
	switch(data.rid){
	case 1:
		permissionHTML += '超级管理员';
		break;
	case 2:
		permissionHTML += '人事权限';
		break;
	case 3:
		permissionHTML += '审批权限';
		break;
	case 4:
		permissionHTML += '普通用户';
		break;
	}
	permissionHTML +='</option>';
	permissionHTML += '<option value ="1" >超级管理员</option>';
	permissionHTML += '<option  value="2">人事权限</option>';
	permissionHTML += '<option  value="3">审批权限</option>';
	permissionHTML += '<option  value="4">普通用户</option>';
	permissionHTML +='</select>';
	permissionHTML += '</div></div>';
	permissionHTML += '<div class="form-group">';
	permissionHTML += '<div class="col-sm-12" style="text-align: center;">';
	permissionHTML += '<input type="button" class="btn btn-primary btn" value="修改" onclick="updPermission(\'' +data.uid + '\')"/>';
	permissionHTML += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	permissionHTML += '</div></div>';
	permissionHTML += '</div></div>';
	$("body").append(permissionHTML);
}