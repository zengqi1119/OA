$(function(){
	$("#user").change(function(){
		var current = $("#user").val();
		link(current);
	})
})

function link(current){
	$.ajax({
		url:"/announcement/find",
		type:"POST",
		data:{
			uid:current
		},
		success:function(data){
			var content = '<input type="checkbox" id="'+data.uid+'" name="box" value="'+data.uid+'" checked onclick="remove('+data.uid+',\''+data.uname+'\')"/>';
			content += '<span id="'+data.uname+'" style="margin-right:15px">'+data.uname+'</span>';
			$("#users").append(content);
		}
	})
}

function remove(uid,uname){
	document.getElementById(uid).remove();
	document.getElementById(uname).remove();
}