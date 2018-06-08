<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>  
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="/insertUser" method="get">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户名</label><input type="text" class="form-control" name="userName" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">用户密码</label><input type="text" class="form-control" name="userPass" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">首充余额</label><input type="text" class="form-control" name="userMoney" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">地址</label><input type="text" class="form-control" name="userAddress" />
				</div>
				</div> <button type="submit" class="btn btn-default">注册 </button>
			</form>
		</div>
	</div>
</div>
</body>
</html>