/**
 * 验证日期格式
 */
function validate(){
	
//	var startTime = $("#startTime").val();
	var atime = $("#atime").val();
//	var st = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
//	if (startTime != '' && !st.test(startTime)){
//		alert("请输入正确的开始日期格式");
//		return false;
//	}
	var et = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	if (atime != '' && !et.test(atime)){
		alert("请输入正确的申领日期格式");
		return false;
	}
//	var d1 = Date.parse(startTime);
//	var d2 = Date.parse(atime);
//	var date = d2 - d1;
//	var time = 60*60*1000;
//	if(date<0||date<time){
//		alert("开始时间应小于结束时间并且间隔小于一小时,请检查!");
//		return false;
//	}
	return true;
}

//格林尼治时间转yyyy-MM-dd HH:mm:ss
//2017-03-15t00:00:00.000+08:00->2017-03-15 00:00:00
function GMTToStr(time){
    let date = new Date(time)
    let Str=date.getFullYear() + '-' ;
    (date.getMonth() + 1)
    var mon = (date.getMonth()+1);
    if(mon<10)
    	Str+="0"+mon;
    	else{
    		Str+=mon;
    	}
    Str+= '-' + 
    date.getDate() + ' ' + 
    date.getHours() + ':' + 
    date.getMinutes() + ':' + 
    date.getSeconds()
    return Str
}


function showUpdateGetGoodsBox(message, method) {
	if(message==null){
		message=document.getElementById("uid").value;
	}else {
		var datetime=GMTToStr(message.bdate)
		var messagebname=message.bname;
	}
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var overtimeHtml = '<div id="overtimeDivModel" style="' + style_ + '">';
	overtimeHtml += '<div class="form-horizontal" role="form">';
	overtimeHtml += '<input type="hidden" id="overtimeId" value=""/>';
/*	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="startTime" class="col-sm-2 control-label">开始时间</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" id="startTime" placeholder="如：2017-04-19 08:00:00">';
	overtimeHtml += '</div></div>';*/
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="atime" class="col-sm-2 control-label" >申领时间</label>';
	overtimeHtml += '<div class="col-sm-10">';
	if(datetime!=null){
		overtimeHtml += '<input type="text" class="form-control" id="atime" autocomplete="off"  value="'+datetime+'">';
	}else {
		overtimeHtml += '<input type="text" class="form-control" id="atime" autocomplete="off" placeholder="如：2017-04-19 08:00:00">';	
	}
	
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="des" class="col-sm-2 control-label" >申领物品</label>';
	overtimeHtml += '<div class="col-sm-10">';
	if(messagebname!=null){
		overtimeHtml += '<input type="text" class="form-control" id="goods" value="'+messagebname+'">';
	}else {
		overtimeHtml += '<input type="text" class="form-control" id="goods">';
	}
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<div class="col-sm-12" style="text-align: center;">';
	
	if (method =='add') {
		overtimeHtml += '<input type="button" class="btn btn-primary btn" value="添加" onclick="addgoods('+message+')"/>';
	} else{
		overtimeHtml += '<input type="button" class="btn btn-primary btn" value="修改" onclick="updgoods('+message.bid+')"/>';
	}
	overtimeHtml += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '</div></div>';
	$("body").append(overtimeHtml);
	//执行一个laydate实例
	laydate.render({
	  elem: '#atime', //指定元素
	  type: 'datetime',
	  format: 'yyyy-MM-dd HH:mm:ss',
	});
}
//修改
function updgoods(bid) {
	var res =  validate();
	if (!res) return; 
	bname=$("#goods").val()
	datetime=$("#atime").val()
			$.ajax({
			url:"/subscribe/updateGoods",
			type:"POST",
			data:{
			"bid":bid,
			"bname":bname,
			"bdate":datetime
			},
			success:function(data){
				if(data.indexOf("成功")!=-1){
					alert("修改成功")
					window.location.href = "/subscribe/officeSubscribe/null/1";	
				}else {
					alert("修改失败，请稍后重试")
				}
				}
			});
		}	
//添加
function addgoods(uid) {
	var res =  validate();
	if (!res) return; 
	bname=$("#goods").val()
	datetime=$("#atime").val()
			$.ajax({
			url:"/subscribe/addGoods",
			type:"POST",
			data:{
			"uid":uid,
			"bname":bname,
			"bdate":datetime
			},
			success:function(data){
				if(data.indexOf("成功")!=-1){
					alert("添加成功")
					window.location.href = "/subscribe/officeSubscribe/null/1";	
				}else {
					alert("添加失败，请稍后重试")
				}
				}
			});
		}	
//模糊查询通过 名字
function selectName() {
	realName = $("#realName").val()
	if (realName == "") {
		alert('输入内容为空，请重新输入')
		return false;
	}
	 window.location.href = "/subscribe/officeSubscribe/" + realName+"/"+1;
		}	