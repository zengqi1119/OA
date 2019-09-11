/**
 * 检验通知公告数据
 */
function noticeCheck() {
	var title = $("#title").val();
	var content = $("#content").val();
	var recipinets = $("#noticeForm").find("input[type='checkbox']:checked");
	if (title == '') {
		alert("标题不允许为空");
		return false;
	}
	if (content == '') {
		alert("内容不允许为空！");
		return false;
	}
	if (recipinets.length == 0) {
		alert("请选择接收人");
		return false;
	}
	
	return true;
}

/**
 * 我发布的通知公告
 * @param path
 * @param offset
 */
function myPulish(path, offset) {
	// 清空tbody中数据
	$("#publishTable").html('');
	// 清空分页数据
	$("#publishPage").html('');
	$.ajax({
		url: path + "/notice/my/publish.action",
		type: "POST",
		data: {offset: offset},
		dataType: "JSON",
		success: function(data){
			var tbody = $("#publishTable");
			if (data.msg != ''){
				var $tr = $('<tr><td colspan="5" style="text-align: center;">' + data.msg + '</td></tr>');
				$tr.appendTo(tbody);
				return;
			}
			var page = data.page;
			$.each(data.notices, function(k ,v){
				var $tr = $('<tr></tr>');
				if (k % 2 == 0)
					$tr.addClass('success');
				var index = Number((page.pageNo - 1) * page.pageSize)+ Number(1) + Number(k);
				var $numTd = $('<td>' + index + '</td>');
				var $titleTd = $('<td><a href = "' + path + '/notice/notice/detail.action?id=' + v.id + '&type=0">' + v.title + '</a></td>');
				var $contenTd = $('<td>' + v.content + '</td>');
				var statu_ = v.status == 0 ? '待审核' : v.status == 1 ? '审核通过' : '审核失败';
				var $statusTd = $('<td>' + statu_  + '</td>');
				var $btnTd = $('<td></td>');
				var $btn = $('<input type="button" class="btn btn-primary btn" value="修改" onclick="javascript:location.href=\'' + path + '/notice/notice/detail.action?id=' + v.id + '&type=1\'"/>');
				// 只有未审核的才能修改
				if (v.status == 0)
					$btn.appendTo($btnTd);
				
				$numTd.appendTo($tr);
				$titleTd.appendTo($tr);
				$contenTd.appendTo($tr);
				$statusTd.appendTo($tr);
				$btnTd.appendTo($tr);
				$tr.appendTo(tbody);
			});
			var pageDiv = $("#publishPage");
			var spanStr = '<span>共' + page.totalRecords + '条记录 共' + page.totalPages + '页 当前第' + page.pageNo + '页</span>';
			var ulStr = '<ul class="pagination" style="float: right;margin: 0;">';
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', 1)">首页</a></li>';
				if (page.pageNo != 1) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo-1 })">上一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">上一页</a></li>';
				}
				if (page.pageNo != page.totalPages) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo + 1 })">下一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">下一页</a></li>';
				}
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.totalPages })">尾页</a></li>';
			
			pageDiv.append(spanStr);
			pageDiv.append(ulStr);
		},error: function(data) {
			alert("系统错误，请联系管理员！");
		}
	});
}

/**
 * 我接收的公告
 * @param path
 * @param offset
 */
function myReceive(path, offset) {
	// 清空tbody中数据
	$("#receiveTable").html('');
	// 清空分页数据
	$("#receivePage").html('');
	$.ajax({
		url: path + "/notice/notice/list.action",
		type: "POST",
		data: {offset: offset},
		dataType: "JSON",
		success: function(data){
			var tbody = $("#receiveTable");
			if (data.msg != ''){
				var $tr = $('<tr><td colspan="4" style="text-align: center;">' + data.msg + '</td></tr>');
				$tr.appendTo(tbody);
				return;
			}
			var page = data.page;
			$.each(data.notices, function(k ,v){
				var $tr = $('<tr></tr>');
				if (k % 2 == 0)
					$tr.addClass('success');
				var index = Number((page.pageNo - 1) * page.pageSize)+ Number(1) + Number(k);
				var $numTd = $('<td>' + index + '</td>');
				var $titleTd = $('<td><a href = "' + path + '/notice/notice/detail.action?id=' + v.id + '&type=0">' + v.title + '</a></td>');
				var $contenTd = $('<td>' + v.content + '</td>');
				var $realNameTd = $('<td>' + v.reanlName + '</td>');
				
				$numTd.appendTo($tr);
				$titleTd.appendTo($tr);
				$contenTd.appendTo($tr);
				$realNameTd.appendTo($tr);
				$tr.appendTo(tbody);
			});
			var pageDiv = $("#receivePage");
			var spanStr = '<span>共' + page.totalRecords + '条记录 共' + page.totalPages + '页 当前第' + page.pageNo + '页</span>';
			var ulStr = '<ul class="pagination" style="float: right;margin: 0;">';
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', 1)">首页</a></li>';
				if (page.pageNo != 1) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo-1 })">上一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">上一页</a></li>';
				}
				if (page.pageNo != page.totalPages) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo + 1 })">下一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">下一页</a></li>';
				}
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.totalPages })">尾页</a></li>';
			
			pageDiv.append(spanStr);
			pageDiv.append(ulStr);
		},error: function(data) {
			alert("系统错误，请联系管理员！");
		}
	});
}
