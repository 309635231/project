<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		<form action="login.do" method="post">
			账号:<input name="username"><br/>
			密码:<input type="password" name="pwd"><br/>
			<input type="submit" value="登录"/>
			${login_failed}
		</form>
	</body>
</html>