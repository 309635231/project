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
	
	
	function searchCheck(){
		$('#dg').datagrid('load',{
			checkId:$('#s_checkId').val()
		})
	}
	
	function deleteCheck(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].checkId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("checkDelete",{delIds:ids},function(result){
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
		
		function openCheckAddDialog(){
			$("#dlg").dialog("open").dialog("setTitle","添加考勤情况信息");
			url="checkSave";
		}
		
		function openCheckModifyDialog(){
			var selectedRows=$("#dg").datagrid('getSelections');
			if(selectedRows.length!=1){
				$.messager.alert("系统提示","请选择一条要编辑的数据！");
				return;
			}
			var row=selectedRows[0];
			$("#dlg").dialog("open").dialog("setTitle","编辑班级信息");
			$("#fm").form("load",row);
			url="checkSave?checkId="+row.checkId;
		}
		
		function closeCheckDialog(){
			$("#dlg").dialog("close");
			resetValue();
		}
		
		function resetValue(){
			$("#checkId").val("");
			$("#stuName").val("");
			$("#checkDesc").val("");
		}
		
		function saveCheck(){
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
	<table id="dg" title="班级信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="checkList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="checkId" width="50">编号</th>
				<th field="stuName" width="100">学生姓名</th>
				<th field="checkDesc" width="250">考勤情况</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openCheckAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openCheckModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteCheck()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>			
		</div>
		<div>&nbsp;学号:&nbsp;<input type="text" name="s_checkId" id="s_checkId">			<a href="javascript:searchCheck()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>	</div>
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
				<td>考勤情况:</td>
				<td><input type="text" name="checkDesc" id="checkDesc" class="easyui-validatebox" required="true"/></td>
			</tr>
	    </table>
		</form>

	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveCheck()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeCheckDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	

</body>
</html>