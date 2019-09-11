/**
 * 添加工作计划
 * @param path
 */
function addworkplan() {
	
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
				location.href = "/plan/work";
			} else if (data == '0') {
				alert("添加失败");
			} else {
				alert(data);
				location.href = "/plan/work";
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
					location.href = "/plan/work";
				} else if (data == '0') {
					alert("修改失败");
				} else {
					alert(data);
					location.href = "/plan/work";
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
function delworkplan(work) {
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
					location.href = "/plan/work";
				} else if (data == '0') {
					alert("删除失败");
				} else {
					alert(data);
					location.href = "/plan/work";
				}
			},error: function(data) {
				alert("系统错误，请联系管理员");
			}
		});
	}
}


	
/**
 * 修改HTML
 * @param path
 */
function workplanHTML(method,work) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#workplanModel') != null && $('#workplanModel') != undefined)
		$('#workplanModel').remove();
	
	var style_ = 'width: 800px; height: 500px; z-index: 1000; position: fixed; top: 30%;margin-top:-150px; left: 40%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var workplanHTML = '<div id="workplanModel" style="' + style_ + '">';
	workplanHTML += '<div class="form-horizontal" role="form">'	
				+'<span style="font-size:30px;">本周工作总结</span>';
	if (method =='add') {
		workplanHTML +='<textarea cols="80" rows="5" style="overflow:hidden;" id="weeksum"></textarea><br/>'
		+'<span style="font-size:30px;">本周遇到问题</span>'
		+'<textarea cols="80" rows="5" style="overflow:hidden;"  id="weekque"></textarea><br/>'
		+'<span style="font-size:30px;">下周工作计划</span>'
		+'<textarea cols="80" rows="5" style="overflow:hidden;" id="weekplan"></textarea><br/>'
		+'<div class="col-sm-12" style="text-align: center;">'
	    + '<input type="button" class="btn btn-primary btn" value="添加" onclick="addworkplan()"/>';
	} else {
		workplanHTML += '<input type="hidden" id="wid" value="'+work.wid+'"/>'
			+'<textarea cols="80" rows="5" style="overflow:hidden;" id="weeksum">'+work.weeksum+'</textarea><br/>'
			+'<span style="font-size:30px;">本周遇到问题</span>'
			+'<textarea cols="80" rows="5" style="overflow:hidden;"  id="weekque">'+work.weekque+'</textarea><br/>'
			+'<span style="font-size:30px;">下周工作计划</span>'
			+'<textarea cols="80" rows="5" style="overflow:hidden;" id="weekplan">'+work.weekplan+'</textarea><br/>'
			+'<div class="col-sm-12" style="text-align: center;">'
			+'<input type="button" class="btn btn-primary btn" value="修改" onclick="updateworkplan()"/>';
	}
	workplanHTML += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#workplanModel\').remove();" style="margin-left: 30px;"/>';
				 +'</div></div></div>';
	$("body").append(workplanHTML);
}