

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
function updOvertime(lid) {
	var id = $("#overtimeId").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var des = $("#des").val()
	var res =  validate();
	if (!res) return; 
	$.ajax({
		url: "/leave/change",
		type: "POST",
		data:{
			'startdate':$("#startTime").val(),
			'enddate':$("#endTime").val(),
			'ltid':$("#type").val(),
			"reason":$("#reason").val(),
			"uid":$("#uid").val(),
			"lid":lid
		},
		success: function(data) {
			location.href = "/leave/query/null/1";
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
	location.href="/leave/query/"+name+"/1";
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
function leaveHTML(path, method,data) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var leaveHTML = '<div id="overtimeDivModel" style="' + style_ + '">';
	leaveHTML += '<div class="form-horizontal" role="form">';
	leaveHTML += '<input type="hidden" id="overtimeId" value=""/>';
	
	if(method=='add'){
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="startTime" class="col-sm-2 control-label ">开始时间</label>';
		leaveHTML += '<div class="col-sm-10 jeinpbox">';
		leaveHTML += '<input type="text" class="form-control" id="startTime" autocomplete="off" placeholder="如：2017-04-19 08:00:00" >';
		leaveHTML += '</div></div>';
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="endTime" class="col-sm-2 control-label">结束时间</label>';
		leaveHTML += '<div class="col-sm-10">';
		leaveHTML += '<input type="text" class="form-control" id="endTime" autocomplete="off" placeholder="如：2017-04-19 18:00:00" >';
		leaveHTML += '</div></div>';
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="des" class="col-sm-2 control-label">请假类型</label>';
		leaveHTML += '<div class="col-sm-10">';
		 leaveHTML +='<select id="type" >';
		leaveHTML += '<option value ="1" >事假</option>';
		leaveHTML += '<option  value="2">病假</option>';
		leaveHTML += '<option  value="3">婚假</option>';
		leaveHTML += '<option  value="4">产假</option>';
		leaveHTML += '<option  value="5">丧假</option>';
		leaveHTML += '<option value="6">其他</option>';
		leaveHTML +='</select>';
		leaveHTML += '</div></div>';
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="des" class="col-sm-2 control-label">请假原因</label>';
		leaveHTML += '<div class="col-sm-10">';
		leaveHTML += '<input type="text" class="form-control" id="reason" >';
		leaveHTML += '</div></div>';
	}else{
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="startTime" class="col-sm-2 control-label">开始时间</label>';
		leaveHTML += '<div class="col-sm-10">';
		leaveHTML += '<input type="text" class="form-control" id="startTime" autocomplete="off" placeholder="如：2017-04-19 08:00:00" value="'+GMTToStr(data.startdate)+'">';
		leaveHTML += '</div></div>';
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="endTime" class="col-sm-2 control-label ">结束时间</label>';
		leaveHTML += '<div class="col-sm-10">';
		leaveHTML += '<input type="text" class="form-control" id="endTime" autocomplete="off" placeholder="如：2017-04-19 18:00:00" value="'+GMTToStr(data.enddate)+'">';
		leaveHTML += '</div></div>';
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="des" class="col-sm-2 control-label">请假类型</label>';
		leaveHTML += '<div class="col-sm-10">';
		 leaveHTML +='<select id="type" >';
		leaveHTML += '<option value ="1" >事假</option>';
		leaveHTML += '<option  value="2">病假</option>';
		leaveHTML += '<option  value="3">婚假</option>';
		leaveHTML += '<option  value="4">产假</option>';
		leaveHTML += '<option  value="5">丧假</option>';
		leaveHTML += '<option value="6">其他</option>';
		leaveHTML +='</select>';
		leaveHTML += '</div></div>';
		leaveHTML += '<div class="form-group">';
		leaveHTML += '<label for="des" class="col-sm-2 control-label">请假原因</label>';
		leaveHTML += '<div class="col-sm-10">';
		leaveHTML += '<input type="text" class="form-control" id="reason" value="'+data.reason+'">';
		leaveHTML += '</div></div>';
	}
	leaveHTML += '<div class="form-group">';
	leaveHTML += '<div class="col-sm-12" style="text-align: center;">';
	if (method =='add') {
		leaveHTML += '<input type="button" class="btn btn-primary btn" value="添加" onclick="addOvertime(\'' + path + '\')"/>';
	} else {
		leaveHTML += '<input type="button" class="btn btn-primary btn" value="修改" onclick="updOvertime(\'' + data.lid + '\')"/>';
	}
	leaveHTML += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	leaveHTML += '</div></div>';
	leaveHTML += '</div></div>';
	$("body").append(leaveHTML);
	//执行一个laydate实例
	laydate.render({
	  elem: '#startTime', //指定元素
	  type: 'datetime',
	  format: 'yyyy-MM-dd HH:mm:ss',
	});
	//执行一个laydate实例
	laydate.render({
	  elem: '#endTime', //指定元素
	  type: 'datetime',
	  format: 'yyyy-MM-dd HH:mm:ss',
	});
}