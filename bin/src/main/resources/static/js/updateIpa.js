function updateIpa(ipa) {
	//alert(ipa.userinfo.uname)
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 600px; height: 350px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var overtimeHtml = '<div id="overtimeDivModel" style="' + style_ + '">';
	overtimeHtml += '<div class="form-horizontal" role="form">';
	overtimeHtml += '<input type="hidden" id="overtimeId" value=""/>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="startTime" class="col-sm-2 control-label">姓名</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="hidden" class="form-control" name="rid"  value="'+ipa.reid+'"/>';
	overtimeHtml += '<input type="text" class="form-control" name="unames"  value="'+ipa.userinfo.uname+'" readonly="readonly"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="endTime" class="col-sm-2 control-label">家庭住址</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" name="addresss"  value="'+ipa.address+'"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="des" class="col-sm-2 control-label">移动电话</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" name="mobilephones" value="'+ipa.mobilephone+'"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="des" class="col-sm-2 control-label">固定电话</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" name="telephones" value="'+ipa.telephone+'"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="des" class="col-sm-2 control-label" >紧急联系人</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" name="contactss" value="'+ipa.contacts+'"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<div class="col-sm-12" style="text-align: center;">';
	overtimeHtml += '<input type="button" class="btn btn-primary btn" value="修改" onclick="updateIpas()"/>';
	overtimeHtml += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '</div></div>';
	$("body").append(overtimeHtml);
}

function updateIpas(){
	if(confirm("确认修改?")){
	$.ajax({
	    type: "post",
	    url: "/ipa/updataIpa",
	    data: {
	    	reid:$("input[name='rid']").val(),
	    	uname:$("input[name='uname']").val(),
	    	address:$("input[name='addresss']").val(),
	    	mobilephone:$("input[name='mobilephones']").val(),
	    	telephone:$("input[name='telephones']").val(),
	    	contacts:$("input[name='contactss']").val()
	    },
	    dataType: "json",
	    success: function(result){
	    	if(result==1){
	    		alert("修改成功");
	    		window.location.href="/ipa/findIpa";
	    	}else{
	    		alert("修改失败");
	    	}
	    }
	});
	}
}
