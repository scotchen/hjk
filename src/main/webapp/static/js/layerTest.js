//弹出窗口，带关闭回调函数
layer.open({
    type : 2,
    title : 'xxxxx',
    shadeClose : false,
    shade : 0.1,
    area : [ '800px', '600px' ],
    content : path + '/xxx/xxx/xxx?xxx='+id,
    end: function(){
        window.document.getElementById("xxx").submit();
    }
});


$.post(
    "${pageContext.request.contextPath}/xxxxxx",
    $("#eleForm").serialize(),
    function(data){
        if(data.status==1){
            alert(data.content)
            parent.window.location.href= "${pageContext.request.contextPath}/xxxxx";
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        }else{
            alert("保存失败");
        }
    }
)


function xx(ids){
    $.ajax({
        type : "GET",
        url : "${pageContext.request.contextPath}xxxxxx?ids="+ids,
        async : true,
        dataType : "text",
        contentType: "text",
        success : function(data) {
            if(data=='1'){
                alert("删除成功！");
                window.location.href= "${pageContext.request.contextPath}/xxxxx"
            }
            if(data=='-1'){
                alert("删除失败！");
            }
        },
        error: function(data) {
            alert('失败!');
        }
    });
}