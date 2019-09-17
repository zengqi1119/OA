/**
 * 添加加班
 * @param path
 */
function addOvertime(path) {
	
	var startTime = $("#startTime").val();
	
	var endTime = $("#endTime").val();
	var des = $("#des").val();
	//验证日期格式是否正确
	var res =  validate();
	if (!res) return;
	$.ajax({
		url:"/overtime/addOvertime",
		type: "POST",
		data:{
			begintime:startTime,
			endtime:endTime,
			description:des
			},
		success: function(data) {
			//alert(data)
			if (data == '1') {
				alert("添加成功");
				$('#overtimeDivModel').remove();
				location.href =path+"/null/1";
			} else if (data == '0') {
				alert("添加失败");
			}else if (data == '2') {
				alert("添加失败,加班时间重叠,请重新选择时间");
				location.href =path+"/null/1";
			} else {
				alert(data);
				location.href =path+"/null/1";
			}
		},error: function(data) {
			alert("系统错误，请联系管理员add");
		}
	});
}






/**
 * 加班详情
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
		}, 
		error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}

/**
 * 修改加班
 * @param path
 */
function updOvertime(path) {
	var id = $("#overtimeId").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var des = $("#des").val()
	var res =  validate();
	//alert(id)
	if (!res) return; 
	$.ajax({
		url:"/overtime/updateOvertime",
		type: "POST",
		data:{
			"oid":id,
			begintime:startTime,
			endtime:endTime,
			description:des
			},
		//dataType: "JSON",
		success: function(data) {
			
			if (data == '1') {
				alert("修改成功");
				$('#overtimeDivModel').remove();
				location.href =path+"/null/1";
			} else if (data == '0') {
				alert("修改失败");
			} else {
				alert(data);
				location.href =path+"/null/1";
			}
		},
		error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}

/**
 * 删除加班
 * @param path
 */
function delOvertime(path, id) {
	if (confirm("确定删除吗")) {
		$.ajax({
			url:"/overtime/deleteOvertime",
			type: "POST",
			data:{oid: id},
			dataType: "JSON",
			success: function(data) {
				if (data == '1') {
					alert("删除成功");					
					location.href =path+"/null/1";
				} else if (data == '0') {
					alert("删除失败");
				} else {
					alert(data);
					location.href =path+"/null/1";
				}
			},
			error: function(data) {
				alert("系统错误，请联系管理员");
			}
		});
	}
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

//格林尼治时间转yyyy-MM-dd HH:mm:ss
//2017-03-15t00:00:00.000+08:00->2017-03-15 00:00:00
function GMTToStr(time){
  let date = new Date(time)
  let Str=date.getFullYear() + '-' +
  ((date.getMonth() + 1)>10?(date.getMonth() + 1):("0"+(date.getMonth() + 1))) + '-' + 
  (date.getDate()>10?(date.getDate()):("0"+(date.getDate()))) + ' ' + 
  (date.getHours()>10?(date.getHours()):("0"+(date.getHours()))) + ':' + 
  (date.getMinutes()>10?(date.getMinutes()):("0"+(date.getMinutes()))) + ':' + 
  (date.getSeconds()>10?(date.getSeconds()):("0"+(date.getSeconds())))
  return Str
}



	
/**
 * 加班HTML
 * @param path
 */
function overtimeHTML(path, method,overtime) {
	
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var overtimeHtml = '<div id="overtimeDivModel" style="' + style_ + '">';
	overtimeHtml += '<div class="form-horizontal" role="form">';
	if (method =='add') {
		overtimeHtml += '<input type="hidden" id="overtimeId" value="'+overtime+'"/>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<label for="startTime" class="col-sm-2 control-label">开始时间</label>';
		overtimeHtml += '<div class="col-sm-10">';
		overtimeHtml += '<input  type="text" class="form-control" id="startTime" autocomplete="off" placeholder="如：2017-04-19 08:00:00"/>';
		overtimeHtml += '</div></div>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<label for="endTime" class="col-sm-2 control-label">结束时间</label>';
		overtimeHtml += '<div class="col-sm-10">';
		overtimeHtml += '<input type="text" class="form-control" id="endTime" autocomplete="off" placeholder="如：2017-04-19 18:00:00">';
		overtimeHtml += '</div></div>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<label for="des" class="col-sm-2 control-label">加班描述</label>';
		overtimeHtml += '<div class="col-sm-10">';
		overtimeHtml += '<input type="text" class="form-control" id="des">';
		overtimeHtml += '</div></div>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<div class="col-sm-12" style="text-align: center;">';
		overtimeHtml += '<input type="button" class="btn btn-primary btn" value="添加" onclick="addOvertime(\'' + path + '\')"/>';
	} else {
		overtimeHtml += '<input type="hidden" id="overtimeId" value="'+overtime.oid+'"/>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<label for="startTime" class="col-sm-2 control-label">开始时间</label>';
		overtimeHtml += '<div class="col-sm-10">';
		overtimeHtml += '<input type="text" class="form-control" id="startTime" autocomplete="off" value="'+GMTToStr(overtime.begintime)+'">';
		overtimeHtml += '</div></div>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<label for="endTime" class="col-sm-2 control-label">结束时间</label>';
		overtimeHtml += '<div class="col-sm-10">';
		overtimeHtml += '<input type="text" class="form-control" id="endTime" autocomplete="off" value="'+GMTToStr(overtime.endtime)+'">';
		overtimeHtml += '</div></div>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<label for="des" class="col-sm-2 control-label">加班描述</label>';
		overtimeHtml += '<div class="col-sm-10">';
		overtimeHtml += '<input type="text" class="form-control" id="des" value="'+overtime.description+'">';
		overtimeHtml += '</div></div>';
		overtimeHtml += '<div class="form-group">';
		overtimeHtml += '<div class="col-sm-12" style="text-align: center;">';
		overtimeHtml += '<input type="button" class="btn btn-primary btn" value="修改" onclick="updOvertime(\'' + path + '\')"/>';
	}
	overtimeHtml += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '</div></div>';

	$("body").append(overtimeHtml);
	
	laydate.render({
	  	  elem: '#startTime', //指定元素
	  	  type: 'datetime',
	  	  format: 'yyyy-MM-dd HH:mm:ss',
	  	});
	
	laydate.render({
	  	  elem: '#endTime', //指定元素
	  	  type: 'datetime',
	  	  format: 'yyyy-MM-dd HH:mm:ss',
	  	});  	
			
							
		
}