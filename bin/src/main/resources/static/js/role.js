/**
 * 添加角色
 * @param path
 */
function addRole(path) {
	var roleName = $("#roleName").val();
	var parentId = $("#parentId").val();
	var describe = $("#describe").val();
	if (roleName == '') {
		alert("角色名称不允许为空");
		return;
	}
	$.ajax({
		url: path + "/role/role/add.action",
		type: "POST",
		data:{roleName: roleName, parentId: parentId, describe: describe},
		dataType: "TEXT",
		success: function(data) {
			if (data == '1') {
				alert("添加成功");
				$('#roleDivModel').remove();
				location.href = path + "/role/role/list.action";
			} else if (data == '0') {
				alert("添加失败");
			} else {
				alert(data);
				location.href = path + "/role/role/list.action";
			}
		},error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}

/**
 * 角色详情
 * @param path
 * @param id
 */
function detailRole(path, id) {
	roleHTML(path, 'upd');
	$.ajax({
		url: path + "/role/role/detail.action",
		type: "POST",
		data:{id: id},
		dataType: "JSON",
		success: function(data) {
			if (data.msg != '') {
				alert(data.msg);
				return;
			}
			var role = data.role;
			$("#roleDivModel #roleId").val(role.id);
			$("#roleDivModel #roleName").val(role.roleName);
			$("#roleDivModel #parentId").find('option[value="'+role.parentId+'"]').attr("selected", true);
			$("#roleDivModel #describe").val(role.describe);
		}, error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}

/**
 * 修改角色
 * @param path
 */
function updRole(path) {
	var id = $("#roleId").val();
	var roleName = $("#roleName").val();
	var parentId = $("#parentId").val();
	var describe = $("#describe").val();
	if (roleName == '') {
		alert("角色名称不允许为空");
		return;
	}
	if (parentId == id) {
		alert("上级角色不允许和当前角色相同");
		return;
	}
	$.ajax({
		url: path + "/role/role/update.action",
		type: "POST",
		data:{id: id, roleName: roleName, parentId: parentId, describe: describe},
		dataType: "JSON",
		success: function(data) {
			alert(data.msg);
			location.href = path + "/role/role/list.action";
		}, error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}

/**
 * 删除角色
 * @param path
 */
function delRole(path, id) {
	if (confirm("确定删除吗")) {
		$.ajax({
			url: path + "/role/role/delete.action",
			type: "POST",
			data:{id: id},
			dataType: "JSON",
			success: function(data) {
				alert(data.msg);
				location.href = path + "/role/role/list.action";
			}, error: function(data) {
				alert("系统错误，请联系管理员");
			}
		});
	}
}

/**
 * 角色HTML
 * @param path
 */
function roleHTML(path, method) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#roleDivModel') != null && $('#roleDivModel') != undefined)
		$('#roleDivModel').remove();
	
	$.ajax({
		url: path + "/role/role/list/ajax.action",
		type: "POST",
		async: false,// 同步ajax，否则展示角色详情时无法赋值
		dataType: "JSON",
		success: function(data) {
			if (data.msg != '') {
				alert(data.msg);
				return;
			}
			var roles = data.roles;
			var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
			var roleHtml = '<div id="roleDivModel" style="' + style_ + '">';
			roleHtml += '<div class="form-horizontal" role="form">';
			roleHtml += '<div class="form-group">';
			roleHtml += '<label for="roleName" class="col-sm-2 control-label">角色名称</label>';
			roleHtml += '<div class="col-sm-10">';
			roleHtml += '<input type="hidden" id="roleId" value=""/>';
			roleHtml += '<input type="text" class="form-control" id="roleName" placeholder="角色名称">';
			roleHtml += '</div></div>';
			roleHtml += '<div class="form-group">';
			roleHtml += '<label for="roleName" class="col-sm-2 control-label">上级角色</label>';
			roleHtml += '<div class="col-sm-10">';
			roleHtml += '<select id="parentId" class="form-control"><option value="0">请选择</option>';
			$.each(roles, function(k, v){
				roleHtml += '<option value="' + v.id +'">' + v.roleName +'</option>';
			});
			roleHtml += '</select>';
			roleHtml += '</div></div>';
			roleHtml += '<div class="form-group">';
			roleHtml += '<label for="describe" class="col-sm-2 control-label">角色描述</label>';
			roleHtml += '<div class="col-sm-10">';
			roleHtml += '<textarea class="form-control" id="describe" rows="5" style="resize: none;"></textarea>';
			roleHtml += '</div></div>';
			roleHtml += '<div class="form-group">';
			roleHtml += '<div class="col-sm-12" style="text-align: center;">';
			if (method =='add') {
				roleHtml += '<input type="button" class="btn btn-primary btn" value="添加" onclick="addRole(\'' + path + '\')"/>';
			} else {
				roleHtml += '<input type="button" class="btn btn-primary btn" value="修改" onclick="updRole(\'' + path + '\')"/>';
			}
			roleHtml += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#roleDivModel\').remove();" style="margin-left: 30px;"/>';
			roleHtml += '</div></div>';
			roleHtml += '</div></div>';
			$("body").append(roleHtml);
		}, error: function(data){
			alert("获取角色信息失败！");
		}
	});
}