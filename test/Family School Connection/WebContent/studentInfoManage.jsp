<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	function searchStudent(){
		$('#dg').datagrid('load',{
			stuNo:$('#s_stuNo').val(),
			stuName:$('#s_stuName').val(),
			sex:$('#s_sex').combobox("getValue"),
			gradeId:$('#s_gradeId').combobox("getValue"),
			stuDesc:$('#s_stuDesc').val(),
			stuConsp:$('#s_stuConsp').val(),
		})
	}
	
	function deleteStudent(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].stuId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("studentDelete",{delIds:ids},function(result){
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
	
	function openStudentAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加学生信息");
		url="studentSave";
	}
	
	function saveStudent(){
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
	
	function resetValue(){
		$("#stuNo").val("");
		$("#stuName").val("");
		$("#sex").combobox("setValue","");
		$("#birthday").datebox("setValue","");
		$("#gradeId").val("");
		$("#stuDesc").val("");
		$("#stuConsp").val("");
	}
	
	function closeStudentDialog(){
		$("#dlg").dialog("close");
		resetValue;
	}
	
	function openStudentModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑学生信息");
		$("#fm").form("load",row);
		url="studentSave?stuId="+row.stuId;
	}
</script>
</head>
<body style="margin:&px;">
	<table id="dg" title="学生信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="studentList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="stuId" width="5" align="center">编号</th>
				<th field="stuNo" width="10" align="center">学号</th>
				<th field="stuName" width="10" align="center">姓名</th>
				<th field="sex" width="5" align="center">性别</th>
				<th field="birthday" width="20" align="center">生日</th>
				<th field="gradeId" width="20" align="center" hidden="true">班级ID</th>
				<th field="gradeName" width="20" align="center">班级名称</th>
				<th field="stuDesc" width="30" align="center">学生表现</th>
				<th field="stuConsp" width="20" align="center">学生月消费</th>
			</tr>
		</thead>
	</table>
	
		<div id="tb">
		<div>
			<a href="javascript:openStudentAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openStudentModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteStudent()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>			
		</div>
		<div>&nbsp;学号:&nbsp;<input type="text" name="s_stuNo" id="s_stuNo" size="10">
		&nbsp;姓名:&nbsp;<input type="text" name="s_stuName" id="s_stuName" size="5">	
		&nbsp;性别:&nbsp;<select class="easyui-combobox" id="s_sex" name="s_sex" editable="false" panelHeight="auto">
			<option value="">请选择...</option>
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
		&nbsp;班级名称:&nbsp;<input class="easyui-combobox" name="s_gradeId" id="s_gradeId" size="5" editable="false" panelHeight="auto" data-options="valueField:'id',textField:'gradeName',url:'gradeComboList'">	
		&nbsp;学生表现:&nbsp;<input type="text" name="s_stuDesc" id="s_stuDesc" size="5">
		&nbsp;月消费:&nbsp;<input type="text" name="s_stuConsp" id="s_stuConsp" size="5">					
		<a href="javascript:searchStudent()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>	</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
		<table cellspacing="&px;">
			<tr>
				<td>学号:</td>
				<td><input type="text" name="stuNo" id="stuNo" class="easyui-validatebox" required="true"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>姓名:</td>
				<td><input type="text" name="stuName" id="stuName" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><select class="easyui-combobox" id="sex" name="sex" editable="false" panelHeight="auto" style="width: 153px">
					<option value="">请选择...</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select></td>
				<td></td>
				<td>生日:</td>
				<td><input class="easyui-datebox" name="birthday" id="birthday" editable="false" required="true"/></td>
			</tr>
			<tr>
				<td>班级名称:</td>
				<td><input class="easyui-combobox" name="gradeId" id="gradeId"  editable="false" panelHeight="auto" data-options="valueField:'id',textField:'gradeName',url:'gradeComboList'"></td>
				<td></td>
				<td>学生表现:</td>
				<td><input type="text" name="stuDesc" id="stuDesc" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<td valign="top">月消费:</td>
				<td><input type="text" name="stuConsp" id="stuConsp" class="easyui-validatebox" required="true"/></td>
			</tr>
	    </table>
		</form>

	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveStudent()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeStudentDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>