<script type="text/javascript">
	$(document).ready(function(){
		//对话框关闭
		$('#xxxx').on('click', function(){
			var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
			parent.layer.close(index); //执行关闭
		});
	});
	function imp() {
		var options ={
			url: "${pageContext.request.contextPath}/xx/xx/xx",
			success: function (data) {
				if(data=="1"){
					alert("导入成功！");
				}else{
					BootstrapDialog.show({
						title:"温馨提示：",
						type:BootstrapDialog.TYPE_DEFAULT,
						cssClass: 'login-dialog',
						message:  "导入失败！",
					});
				}
			},
			error:function(){
				BootstrapDialog.show({
					title:"温馨提示：",
					type:BootstrapDialog.TYPE_DEFAULT,
					cssClass: 'login-dialog',
					message:  "导入失败！！！",
				});
			}
		}
		if($("#file").val()){
			console.log($("#importExcel"));
			$("#importExcel").ajaxSubmit(options)

		}else{
			BootstrapDialog.show({
				title:"温馨提示：",
				type:BootstrapDialog.TYPE_DEFAULT,
				cssClass: 'login-dialog',
				message:  "请选择要导入数据的Excel文件",
			});
			return;
		}

	}

</script>
<script src="${ctx}/static/jquery/jquery-1.9.1.min.js" crossorigin="anonymous"></script>
<body >
<div >
<form id="xxx"   method="post"  enctype="multipart/form-data" >
		<div >
				<table  class="gridtable" style="border: 1px solid #CCCCCC;width: 100%;height: auto" >
					<tbody>
					<tr>
						<td align="right" width="50%">
							<label class="control-label">请选择文件：</label>
						</td>
						<td align="right" width="50%">
							<input type="file" name="file" id="file"   />
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" >
							<input id="xxxxx" type="button" class="btn btn-default" value="导入" onclick="imp()"/>&nbsp;
							<input id="xxxx" type="button" class="btn btn-default" value="关闭"/>&nbsp;
						</td>
					</tr>
					<tbody>
				</table>
		</div>
	</div>
			</form>
		</div>
</body>