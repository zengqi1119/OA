function selectworkplan() {
	realName=$("#realName").val()
	if(realName == ""){
		alert('输入内容为空，请重新输入')
		return false;
	}
	location.href = "/plan/work/" + realName+"/"+1;
}


/**
 * 添加工作计划
 * @param path
 */
function addworkplan() {
	var role =$("#role").val();
	$.ajax({
		url: "/plan/insert",
		type: "POST",
		data:{
			weeksum:$("#weeksum").val(),
			weekque:$("#weekque").val(),
			weekplan:$("#weekque").val()
		},
		
		success: function(data) {
			if (data == '1') {
				alert("添加成功");
				$('#workplanModel').remove();
				if(role=="admin"){
					location.href = "/plan/work/null/1";
				}else{
					location.href = "/plan/work/1";
				}
				
			} else if (data == '0') {
				alert("添加失败");
			} else {
				alert(data);
				if(role=="admin"){
					location.href = "/plan/work/null/1";
				}else{
					location.href = "/plan/work/1";
				}
			}
		},error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}




/**
 * 修改工作计划
 * @param path
 */
function updateworkplan() {
	var role =$("#role").val();
	$.ajax({
		url:  "/plan/update",
		type: "POST",
		data:{
			wid:$("#wid").val(),
			weeksum:$("#weeksum").val(),
			weekque:$("#weekque").val(),
			weekplan:$("#weekque").val()
			},
			success: function(data) {
				if (data == '1') {
					alert("修改成功");
					$('#workplanModel').remove();
					if(role=="admin"){
						location.href = "/plan/work/null/1";
					}else{
						location.href = "/plan/work/1";
					}
				} else if (data == '0') {
					alert("修改失败");
				} else {
					alert(data);
					if(role=="admin"){
						location.href = "/plan/work/null/1";
					}else{
						location.href = "/plan/work/1";
					}
				}
			},error: function(data) {
				alert("系统错误，请联系管理员");
			}
	});
}

/**
 * 删除工作计划
 * @param path
 */
function delworkplan(work,role) {
	if (confirm("确定删除吗")) {
		$.ajax({
			url:  "/plan/delete",
			type: "POST",
			data:{
				wid: work.wid,
			},
			success: function(data) {
				if (data == '1') {
					alert("删除成功");
					if(role=="admin"){
						location.href = "/plan/work/null/1";
					}else{
						location.href = "/plan/work/1";
					}
				} else if (data == '0') {
					alert("删除失败");
				} else {
					alert(data);
					if(role=="admin"){
						location.href = "/plan/work/null/1";
					}else{
						location.href = "/plan/work/1";
					}
				}
			},error: function(data) {
				alert("系统错误，请联系管理员");
			}
		});
	}
}


	
/**
 * 修改HTML
 */
function workplanHTML(method,work,role) {
	
	// 检查当前页面是否弹层，如果有则删除
	if($('#workplanModel') != null && $('#workplanModel') != undefined)
		$('#workplanModel').remove();
	
	var style_ = 'width: 800px; height: 320px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 40%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var workplanHTML = '<div id="workplanModel" style="' + style_ + '">';
	workplanHTML += '<div class="form-horizontal" role="form">'	
				+'<input type="hidden" id="role" value="'+role+'"/>';
	if (method =='add') {
		workplanHTML +='<div class="form-group">'
		 + '<label for="startTime" class="col-sm-2 control-label">本周工作总结</label>'
		 + '<div class="col-sm-10">'
		 +'<textarea cols="80" rows="3" style="overflow:hidden;" id="weeksum"></textarea><br/>'
		 + '</div></div>'
		 +'<div class="form-group">'
		 + '<label for="startTime" class="col-sm-2 control-label">本周遇到问题</label>'
		 + '<div class="col-sm-10">'
		 +'<textarea cols="80" rows="3" style="overflow:hidden;" id="weekque"></textarea><br/>'
		 + '</div></div>'
		 +'<div class="form-group">'
		 + '<label for="startTime" class="col-sm-2 control-label">下周工作计划</label>'
		 + '<div class="col-sm-10">'
		 +'<textarea cols="80" rows="3" style="overflow:hidden;" id="weekplan"></textarea><br/>'
		 + '</div></div>'
		+'<div class="col-sm-12" style="text-align: center;">'
	    + '<input type="button" class="btn btn-primary btn" value="添加" onclick="addworkplan()"/>';
	} else {
		workplanHTML += '<input type="hidden" id="wid" value="'+work.wid+'"/>'
			 +'<div class="form-group">'
			 + '<label for="startTime" class="col-sm-2 control-label">本周工作总结</label>'
			 + '<div class="col-sm-10">'
			 +'<textarea cols="80" rows="3" style="overflow:hidden;" id="weeksum">'+work.weeksum+'</textarea><br/>'
			 + '</div></div>'
			 +'<div class="form-group">'
			 + '<label for="startTime" class="col-sm-2 control-label">本周遇到问题</label>'
			 + '<div class="col-sm-10">'
			 +'<textarea cols="80" rows="3" style="overflow:hidden;"  id="weekque">'+work.weekque+'</textarea><br/>'
			 + '</div></div>'
			 +'<div class="form-group">'
			 + '<label for="startTime" class="col-sm-2 control-label">下周工作计划</label>'
			 + '<div class="col-sm-10">'
			 +'<textarea cols="80" rows="3" style="overflow:hidden;" id="weekplan">'+work.weekplan+'</textarea><br/>'
			 + '</div></div>'
			+'<div class="col-sm-12" style="text-align: center;">'
			+'<input type="button" class="btn btn-primary btn" value="修改" onclick="updateworkplan()"/>';
	
	}
	workplanHTML += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#workplanModel\').remove();" style="margin-left: 30px;"/>';
				 +'</div></div></div>';
	$("body").append(workplanHTML);
}