<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<center>

		<form class="form-horizontal" action="/checkLogin">
			<div class="control-group">
				<label class="control-label" for="inputEmail">用户名</label>
				<div class="controls">
					<input type="text" id="inputEmail" placeholder="username" name="userId">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">密码</label>
				<div class="controls">
					<input type="password" id="inputPassword" placeholder="password" name="userPass">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">登录</button>
				</div>
				<div class="controls">
					<button type="submit" class="btn">注册</button>
				</div>
			</div>
		</form>
	</center>
</body>
</html>