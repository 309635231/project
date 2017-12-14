<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级信息管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	
	function searchCorporation(){
		$('#dg').datagrid('load',{
			stuName:$('#s_stuName').val()
		})
	}
	
	function deleteCorporation(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].corId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("corporationDelete",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","删除失败");

					}
				},"json");
			}
		})
	}
		
		function openCorporationAddDialog(){
			$("#dlg").dialog("open").dialog("setTitle","添加学生社团信息");
			url="corporationSave";
		}
		
		function openCorporationModifyDialog(){
			var selectedRows=$("#dg").datagrid('getSelections');
			if(selectedRows.length!=1){
				$.messager.alert("系统提示","请选择一条要编辑的数据！");
				return;
			}
			var row=selectedRows[0];
			$("#dlg").dialog("open").dialog("setTitle","编辑学生社团信息");
			$("#fm").form("load",row);
			url="corporationSave?corId="+row.corId;
		}
		
		function closeCorporationDialog(){
			$("#dlg").dialog("close");
			resetValue();
		}
		
		function resetValue(){
			$("#stuName").val("");
			$("#corDesc").val("");
			$("#job").val("");
		}
		
		function saveCorporation(){
			$("#fm").form("submit",{
				url:url,
				onSubmit:function(){
					return $(this).form("validate");
				},
				success:function(result){
					if(result.errorMsg){
						$.messager.alert("系统提示",result.errorMsg);
						return;
					}else{
						$.messager.alert("系统提示","保存成功");
						resetValue();
						$("#dlg").dialog("close");
						$("#dg").datagrid("reload");
					}
				}
			});
		}
		

</script>
</head>
<body style="margin:&px;">
	<table id="dg" title="班级信息" class="easyui-datagrid" 
	 pagination="true" rownumbers="true" url="corporationList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" ></th>
				<th field="corId" width="50" align="center">编号</th>
				<th field="stuName" width="100" align="center">学生姓名</th>
				<th field="corDesc" width="100" align="center">社团名称</th>
				<th field="job" width="100" align="center">职位</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openCorporationAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openCorporationModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteCorporation()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>			
		</div>
		<div>&nbsp;学生姓名:&nbsp;<input type="text" name="s_stuName" id="s_stuName">			<a href="javascript:searchCorporation()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>	</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 400px;height: 280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
		<table>
			<tr>
				<td>学生姓名:</td>
				<td><input type="text" name="stuName" id="stuName" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<td>社团名称:</td>
				<td><input type="text" name="corDesc" id="corDesc" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<td>职位:</td>
				<td><input type="text" name="job" id="job" class="easyui-validatebox" required="true"/></td>
			</tr>
	    </table>
		</form>

	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveCorporation()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeCorporationDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	

</body>
</html>