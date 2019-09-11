/**
 * 添加报销项HTML
 * @param path
 */
function applyaddHTML(method,apply,uname) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#applyaddDivModel') != null && $('#applyaddDivModel') != undefined)
		$('#applyaddDivModel').remove();
	var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var applyaddHtml = '<div id="applyaddDivModel" style="' + style_ + '">';
	if (method =='add') {
		applyaddHtml += '<div class="form-horizontal" role="form">';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<label for="startTime" class="col-sm-2 control-label">报销项目名称</label>';
		applyaddHtml += '<div class="col-sm-10">';
		applyaddHtml += '<input type="text" class="form-control" name="item" id="item">';
		applyaddHtml += '</div></div>';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<label for="endTime" class="col-sm-2 control-label">计价单位</label>';
		applyaddHtml += '<div class="col-sm-10">';
		applyaddHtml += '<input type="text" class="form-control" id="endTime" placeholder="元">';
		applyaddHtml += '</div></div>';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<label for="des" class="col-sm-2 control-label">报销项目单价</label>';
		applyaddHtml += '<div class="col-sm-10">';
		applyaddHtml += '<input type="text" class="form-control" name="amount" id="amount">';
		applyaddHtml += '</div></div>';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<div class="col-sm-12" style="text-align: center;">';
		applyaddHtml += '<input type="button" class="btn btn-primary btn" value="添加" onclick="addapply(1)"/>';
	} else {
		applyaddHtml += '<div class="form-horizontal" role="form">';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<label for="startTime" class="col-sm-2 control-label">报销人</label>';
		applyaddHtml += '<div class="col-sm-10">';
		applyaddHtml += '<input type="text" class="form-control" name="item" id="uname" value="'+uname+'">';
		applyaddHtml += '</div></div>';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<label for="startTime" class="col-sm-2 control-label">报销项目名称</label>';
		applyaddHtml += '<div class="col-sm-10">';
		applyaddHtml += '<input type="text" class="form-control" name="item" id="item" value="'+apply.item+'">';
		applyaddHtml += '</div></div>';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<label for="endTime" class="col-sm-2 control-label">计价单位</label>';
		applyaddHtml += '<div class="col-sm-10">';
		applyaddHtml += '<input type="text" class="form-control" id="endTime" placeholder="元">';
		applyaddHtml += '</div></div>';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<label for="des" class="col-sm-2 control-label">报销项目单价</label>';
		applyaddHtml += '<div class="col-sm-10">';
		applyaddHtml += '<input type="text" class="form-control" name="amount" id="amount" value="'+apply.amount+'">';
		applyaddHtml += '</div></div>';
		applyaddHtml += '<div class="form-group">';
		applyaddHtml += '<div class="col-sm-12" style="text-align: center;">';
		applyaddHtml += '<input type="button" class="btn btn-primary btn" value="修改" onclick="modifyapply('+apply.appid+','+apply.uid+','+apply.apid+')"/>';
	}
	applyaddHtml += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#applyaddDivModel\').remove();" style="margin-left: 30px;"/>';
	applyaddHtml += '</div></div>';
	applyaddHtml += '</div></div>';
	$("body").append(applyaddHtml);
}

function addapply(uid){
	$.ajax({
		url:"/apply/add",
		type:"POST",
		data:{
			item:$("#item").val(),
			amount:$("#amount").val(),
			uid:uid
		},
		success:function(data){
			if(data==0){
				alert("添加成功!");
				location.href="/apply/query?uid="+uid;
			}
			if(data==1){
				alert("添加失败!");
			}
			if(data==2){
				alert("系统维护中!");
			}
		}
	})
}

function modifyapply(appid,uid,apid){
	$.ajax({
		url:"/apply/modify",
		type:"POST",
		data:{
			appid:appid,
			item:$("#item").val(),
			amount:$("#amount").val(),
			apid:apid,
			uid:uid
		},
		success:function(data){
			if(data==0){
				alert("修改成功!");
				location.href="/apply/query?uid="+uid;
			}
			if(data==1){
				alert("修改失败!");
			}
			if(data==2){
				alert("系统维护中!");
			}
		}
	})
}