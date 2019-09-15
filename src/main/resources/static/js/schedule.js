//查询
function selectSchedule() {
	realName=$("#realName").val()
	if(realName == ""){
		alert('输入内容为空，请重新输入')
		return false;
	}
	location.href = "/schedule/select/" + realName+"/"+1;
}
//添加日程安排
function addSchedule(){
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var bid = $("#bid").val();
	var agenda = $("#agenda").val();
	var res =  validate();
	if (!res) return;
	$.ajax({
		url:"/schedule/insert",
		type:"POST",
		data:{
			starttime:startTime,
			endtime:endTime,
			bid:bid,
			agenda:agenda
		},
		success:function(data){
			if(data == '1'){
				alert("添加成功");
				$('#scheduleDivModel').remove();
				location.href = "/schedule/select/null/1";
			}else if(data == '0'){
				alert("添加失败");
			}else{
				alert(data);
				location.href = "/schedule/select/null/1";
			}
		},
		error:function(data){
			alert("系统错误，请联系管理员");
		}
	});
	
}

//修改日程安排
function updSchedule(){
	
	var res =  validate();
	if (!res) return;
	$.ajax({
		url:"/schedule/update",
		type:"POST",
		data:{
			sid:$("#sid").val(),
			starttime:$("#startTime").val(),
			endtime:$("#endTime").val(),
			bid:$("#bid").val(),
			agenda:$("#agenda").val()
		},
		success:function(data){
			if(data == '1'){
				alert("修改成功");
				$('#scheduleDivModel').remove();
				location.href = "/schedule/select/null/1";
			}else if(data == '0'){
				alert("修改失败");
			}else{
				alert(data);
				location.href = "/schedule/select/null/1";
			}
		},
		error:function(data){
			alert("系统错误，请联系管理员");
		}
	});
	
}

//删除日程安排 软删除
function delSchedule(schedule){
	
	$.ajax({
		
		url:"/schedule/delete",
		type:"POST",
		data:{
			sid:schedule.sid,
			
		},
		success:function(data){
			if(data == '1'){
				alert("删除成功");
				location.href = "/schedule/select/null/1";
			}else if(data == '0'){
				alert("删除失败");
			}else{
				alert(data);
				location.href = "/schedule/select/null/1";
			}
		},
		error:function(data){
			
			alert("系统错误，请联系管理员");
		}
	});
	
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

function scheduleHTML(schedule,method) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#scheduleDivModel') != null && $('#scheduleDivModel') != undefined)
		$('#scheduleDivModel').remove();
	
	var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var scheduleHTML = '<div id="scheduleDivModel" style="' + style_ + '">'
	scheduleHTML += '<div class="form-horizontal" role="form">';
		//修改		
	if (method =='update') {
	scheduleHTML += '<input type="hidden" id="sid" value="'+schedule.sid+'"/>'
				 + '<div class="form-group">'
				 + '<label for="startTime" class="col-sm-2 control-label">开始时间</label>'
				 + '<div class="col-sm-10">'
				 + '<input type="text" class="form-control" id="startTime" autocomplete="off"  value="'+GMTToStr(schedule.starttime)+'">'
				 + '</div></div>'
				 + '<div class="form-group">'
				 +'<label for="endTime" class="col-sm-2 control-label">结束时间</label>'
				 + '<div class="col-sm-10">'
				 + '<input type="text" class="form-control" id="endTime"  autocomplete="off" value="'+GMTToStr(schedule.endtime)+'">'
				 + '</div></div>'
				 +'<div class="form-group">'
				 + '<label for="bid" class="col-sm-2 control-label" >事务类型</label>'
				 +'<div class="col-sm-10">';
		if(schedule.business.bname=="外出"){
			scheduleHTML += '<select id="bid" ><option value="1" selected = "selected">外出</option><option value="2" >采购</option><option value="3">来访</option><option value="3">出差</option>'
		}else if(schedule.business.bname=="采购"){
			scheduleHTML += '<select id="bid" ><option value="1">外出</option><option value="2" selected = "selected">采购</option><option value="3">来访</option><option value="3">出差</option>'
		}else if(schedule.business.bname=="来访"){
			scheduleHTML += '<select id="bid" ><option value="1">外出</option><option value="2">采购</option><option value="3" selected = "selected">来访</option><option value="4">出差</option>'
		}else{
			scheduleHTML += '<select id="bid" ><option value="1">外出</option><option value="2" >采购</option><option value="3">来访</option><option value="4" selected = "selected">出差</option>'
		}
	scheduleHTML +=	'</select></div></div>'
				 +'<div class="form-group">'
				 + '<label for="des" class="col-sm-2 control-label">日程内容</label>'
				 +'<div class="col-sm-10">'
				 + '<input type="text" class="form-control" id="agenda" value="'+schedule.agenda+'">'
				 + '</div></div>'
				 + '<div class="form-group">'
				 +'<div class="col-sm-12" style="text-align: center;">'
				 + '<input type="button" class="btn btn-primary btn" value="修改" onclick="updSchedule()"/>';
	} else {
		//添加
		scheduleHTML += '<div class="form-group">'
			 + '<label for="startTime" class="col-sm-2 control-label">开始时间</label>'
			 + '<div class="col-sm-10">'
			 + '<input type="text" class="form-control" id="startTime" placeholder="如：2017-04-19 08:00:00" autocomplete="off">'
			 + '</div></div>'
			 + '<div class="form-group">'
			 +'<label for="endTime" class="col-sm-2 control-label">结束时间</label>'
			 + '<div class="col-sm-10">'
			 + '<input type="text" class="form-control" id="endTime" placeholder="如：2017-04-19 18:00:00" autocomplete="off">'
			 + '</div></div>'
			 +'<div class="form-group">'
			 + '<label for="des" class="col-sm-2 control-label">事务类型</label>'
			 +'<div class="col-sm-10">'
			 +'<select id="bid" ><option value="1">外出</option><option value="2" >采购</option><option value="3">来访</option><option value="3">出差</option>'
			 + '</select></div></div>'
			 +'<div class="form-group">'
			 + '<label for="des" class="col-sm-2 control-label">日程内容</label>'
			 +'<div class="col-sm-10">'
			 + '<input type="text" class="form-control" id="agenda">'
			 + '</div></div>'
			 + '<div class="form-group">'
			 +'<div class="col-sm-12" style="text-align: center;">'
			 +'<input type="button" class="btn btn-primary btn" value="添加"  onclick="addSchedule()"/>';
	}
	scheduleHTML += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#scheduleDivModel\').remove();" style="margin-left: 30px;"/>';
	scheduleHTML += '</div></div>';
	scheduleHTML += '</div></div>';
	$("body").append(scheduleHTML);
	//执行一个laydate实例
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