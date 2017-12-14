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
	
	
	function searchFamily(){
		$('#dg').datagrid('load',{
			stuName:$('#s_familyName').val()
		})
	}
	
	function deleteFamily(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].famId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("familyDelete",{delIds:ids},function(result){
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
		
		function openFamilyAddDialog(){
			$("#dlg").dialog("open").dialog("setTitle","添加家庭信息");
			url="familySave";
		}
		
		function openFamilyModifyDialog(){
			var selectedRows=$("#dg").datagrid('getSelections');
			if(selectedRows.length!=1){
				$.messager.alert("系统提示","请选择一条要编辑的数据！");
				return;
			}
			var row=selectedRows[0];
			$("#dlg").dialog("open").dialog("setTitle","编辑家庭信息");
			$("#fm").form("load",row);
			url="familySave?famId="+row.famId;
		}
		
		function closeFamilyDialog(){
			$("#dlg").dialog("close");
			resetValue();
		}
		
		function resetValue(){
			$("#familyName").val("");
			$("#familyDesc").val("");
		}
		
		function saveFamily(){
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
	<table id="dg" title="家庭信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="familyList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="famId" width="2" align="center">编号</th>
				<th field="stuName" width="5" align="center">学生姓名</th>
				<th field="famName" width="5" align="center">父母姓名</th>
				<th field="famOri" width="5" align="center">籍贯</th>
				<th field="famNation" width="5" align="center">民族</th>
				<th field="famCompany" width="5" align="center">工作单位</th>
				<th field="famJob" width="5" align="center">职务</th>
				<th field="famPol" width="5" align="center">政治面貌</th>
				<th field="famAdd" width="15" align="center">家庭住址</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openFamilyAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openFamilyModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteFamily()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>			
		</div>
		<div>&nbsp;学生姓名:&nbsp;<input type="text" name="s_familyName" id="s_familyName">			<a href="javascript:searchFamily()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>	</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height:  350px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
		<table cellspacing="&px;">
			<tr>
				<td>学生姓名:</td>
				<td><input type="text" name="stuName" id="stuName" class="easyui-validatebox" required="true"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>父母姓名:</td>
				<td><input type="text" name="famName" id="famName" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<td>籍贯:</td>
				<td><input type="text" name="famOri" id="famOri" class="easyui-validatebox" required="true"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>民族:</td>
				<td><input type="text" name="famNation" id="famNation" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<td>工作单位:</td>
				<td><input type="text" name="famCompany" id="famCompany" class="easyui-validatebox" required="true"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>职务:</td>
				<td><input type="text" name="famJob" id="famJob" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<td>政治面貌:</td>
				<td><input type="text" name="famPol" id="famPol" class="easyui-validatebox" required="true"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>家庭住址:</td>
				<td><input type="text" name="famAdd" id="famAdd" class="easyui-validatebox" required="true"/></td>
			</tr>
	    </table>
		</form>

	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveFamily()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeFamilyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	

</body>
</html>