//格林尼治时间转yyyy-MM-dd HH:mm:ss
//2017-03-15t00:00:00.000+08:00->2017-03-15 00:00:00
function GMTToStr(time){
    let date = new Date(time)
    let Str=date.getFullYear() + '-' +
    ((date.getMonth() + 1)>10?(date.getMonth() + 1):("0"+(date.getMonth() + 1))) + '-' + 
    (date.getDate()>10?(date.getDate()):("0"+(date.getDate()))) + ' ' + 
    date.getHours() + ':' + 
    date.getMinutes() + ':' + 
    date.getSeconds()
    return Str
}
/**
 * 返回给定小数位数的数字
 * @param num  给定数字
 * @param len  小数位数
 * @returns  number    
 */
function num(num,len) {
	var number = num.toFixed(len);
	return number
}
/**
 * 审批详情(加班管理)
 * @param path
 * @param id
 */
function detailOvertime(path,id) {
	overtimeHTML(path, 'upd');
	$.ajax({
		url: path + "/examine/examine/detail.action",
		type: "POST",
		data:{id :id},
		dataType: "JSON",
		success: function(data) {
			var examine = data.examine;
			var overtime = data.overtime;
			var stratTime = new Date(overtime.startTime)
			var endTime = new Date(overtime.endTime)
			$("#overtimeDivModel #examine").val(examine.id);
			$("#overtimeDivModel #startTime").val(stratTime.format('yyyy-MM-dd h:mm:ss'));
			$("#overtimeDivModel #endTime").val(endTime.format('yyyy-MM-dd h:mm:ss'));
			$("#overtimeDivModel #des").val(overtime.des);
		}, error: function(data) {
			
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

/**
 * 详情审批
 * @param path
 */
function examineStatus(state,id,aptid) {
	$.ajax({
		url:"/approval/examine",
		type: "POST",
		data:{
			"state":state,
			"id":id,
			"aptid":aptid
			},
		success: function(data) {
			if(data==1){
				var path = location.href;
				if(path.indexOf("/approval/queryall")){
					location.href="/approval/queryall/1"
				}else{
					location.href="/approval/query/1"
				}
					
			}else{
				alert("系统错误，请联系管理员")
			}
		
		}, error: function(data) {
		}
	});
}
	
/**
 * 详情页面HTML
 * @param path
 */
function detailHtml(id,data, aptid) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 500px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var detailHtml = '<div id="overtimeDivModel" style="' + style_ + '">';
	detailHtml += '<div class="form-horizontal" role="form">';
	detailHtml += '<input type="hidden" id="overtimeId" value=""/>';
	detailHtml += '<input type="hidden" id="examine" value=""/>';
	detailHtml += '<input type="hidden" id="status" value=""/>';
	detailHtml += '<div class="form-group">';
	switch(aptid){
	case 1:
		detailHtml += '<label for="startTime" class="col-sm-3 control-label">开始时间</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="startTime" value="'+GMTToStr(data.begin)+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="endTime" class="col-sm-3 control-label">结束时间</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="endTime" value="'+GMTToStr(data.end)+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="des" class="col-sm-3 control-label">加班描述</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="des" value="'+data.reason+'" readonly="readonly">';
		detailHtml += '</div></div>';
		break;
	case 2:
		detailHtml += '<label for="startTime" class="col-sm-3 control-label">开始时间</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="startTime" value="'+GMTToStr(data.begin)+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="endTime" class="col-sm-3 control-label">结束时间</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="endTime" value="'+GMTToStr(data.end)+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="des" class="col-sm-3 control-label">请假理由</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="des" value="'+data.reason+'" readonly="readonly">';
		detailHtml += '</div></div>';
		break;
	case 4:
		detailHtml += '<label for="startTime" class="col-sm-3 control-label">申请时间</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="startTime" value="'+GMTToStr(data.begin)+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="endTime" class="col-sm-3 control-label">申领物品</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="endTime" value="'+data.digest+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="des" class="col-sm-3 control-label">申领理由</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="des" value="'+data.reason+'" readonly="readonly">';
		detailHtml += '</div></div>';
		break;
	case 5:
		detailHtml += '<label for="startTime" class="col-sm-3 control-label">申请时间</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="startTime" value="'+GMTToStr(data.start)+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="endTime" class="col-sm-3 control-label">申购物品</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="endTime" value="'+data.digest+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="des" class="col-sm-3 control-label">申购理由</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="des" value="'+data.reason+'" readonly="readonly">';
		detailHtml += '</div></div>';
		break;
	case 3:
		detailHtml += '<label for="startTime" class="col-sm-3 control-label">报销项目</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="startTime" value="'+data.digest+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="endTime" class="col-sm-3 control-label">报销金额</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="endTime" value="￥： '+num(data.amount,2)+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="des" class="col-sm-3 control-label">报销理由</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="des" value="'+data.reason+'" readonly="readonly">';
		detailHtml += '</div></div>';
		break;
	case 6:
		detailHtml += '<label for="startTime" class="col-sm-3 control-label">标题</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="startTime" value="'+data.reason+'" readonly="readonly">';
		detailHtml += '</div></div>';
		detailHtml += '<div class="form-group">';
		detailHtml += '<label for="endTime" class="col-sm-3 control-label">摘要</label>';
		detailHtml += '<div class="col-sm-9">';
		detailHtml += '<input type="text" class="form-control" id="endTime" value="'+data.digest+'" readonly="readonly">';
		detailHtml += '</div></div>';
		break;
	}
	if(data.apid==0){
		detailHtml += '<div class="form-group">';
		detailHtml += '<div class="col-sm-12" style="text-align: center;">';
		detailHtml += '<input type="button" class="btn btn-primary btn" id="a" value="同意" onclick="examineStatus(1,\''+id+'\',\''+aptid+'\');" style="margin-left: 30px;"></input>';
		detailHtml += '<input type="button" class="btn btn-primary btn" id="b" value="拒绝" onclick="examineStatus(2,\''+id+'\',\''+aptid+'\');"style="margin-left: 30px;"/>';
		detailHtml += '<input type="button" class="btn btn-primary btn" value="关闭" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
		detailHtml += '</div></div>';
		detailHtml += '</div></div>';
	}else if(data.apid==1){
		detailHtml += '<div class="form-group">';
		detailHtml += '<div class="col-sm-12" style="text-align: center;">';
		detailHtml += '<input type="button" class="btn btn-success btn" id="b" value="审批已同意" style="margin-left: 30px;display="none""/>';
		detailHtml += '<input type="button" class="btn btn-primary btn" value="关闭" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
		detailHtml += '</div></div>';
		detailHtml += '</div></div>';
	}else if(data.apid==2){
		detailHtml += '<div class="form-group">';
		detailHtml += '<div class="col-sm-12" style="text-align: center;">';
		detailHtml += '<input type="button" class="btn btn-danger btn" id="b" value="审批已驳回" style="margin-left: 30px;display="none""/>';
		detailHtml += '<input type="button" class="btn btn-primary btn" value="关闭" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
		detailHtml += '</div></div>';
		detailHtml += '</div></div>';
	}

	$("body").append(detailHtml);
}
/**
 * 
 * 日期格式转换
 */
Date.prototype.format = function(format) {
    var date = {
           "M+": this.getMonth() + 1,
           "d+": this.getDate(),
           "h+": this.getHours(),
           "m+": this.getMinutes(),
           "s+": this.getSeconds(),
           "q+": Math.floor((this.getMonth() + 3) / 3),
           "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
           format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
           if (new RegExp("(" + k + ")").test(format)) {
                  format = format.replace(RegExp.$1, RegExp.$1.length == 1
                         ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
           }
    }
    return format;
}