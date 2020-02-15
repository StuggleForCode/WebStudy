//验证表单

//1.声明变量

var emailObj;

//2.页面加载之后，获取页面的对象
window.onload = function(){
	emailObj = document.getElementById("email");
}



// 验证邮箱

function checkEmail(){
	
	var value = emailObj.value;
	var regex = /^[\w-]+@([\w-]+\.)+[a-zA-Z]{2,4}$/;
	var msg = "";
	if(!value){
		msg = "邮箱必须填写";
	}else if(!regex.test(value)){
		msg = "邮箱格式不合法";
	}
}