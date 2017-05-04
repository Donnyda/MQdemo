$(function(){
	//建立长连接到服务器
	getMsg();
});

function getMsg(){
	$.ajax({
        url: "/ActiveMQSpringDemo/mchat/loadChat",
        dataType: "json",
        success: function(data){
        	console.debug(data)
            $('#center').empty();   //清空resText里面的所有内容
            var html = data.data;
            $('#center').html(html);
            getMsg();
        	},
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	//getMsg();
         }
      
    });
}

function sendMsg(){
	
	/*$.ajax({
		type: "POST",
		url:"/ActiveMQSpringDemo/mchat/sendMsg",
		data:{"msg":$("#msg").value},
		dataType: "json"
	});*/
	console.debug($("#msg").val());
	 $.post("/ActiveMQSpringDemo/mchat/sendMsg",
	    {
	        msg:$("#msg").val()
	        
	    },
	        function(data,status){
	        alert("数据: \n" + data + "\n状态: " + status);
	    });
}