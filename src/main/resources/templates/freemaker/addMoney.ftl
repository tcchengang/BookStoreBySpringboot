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
			<form role="form" action="/updateUser" method="get">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户ID：</label><input type="text" class="form-control" value=${userId } />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">现有金额：</label><input type="text" class="form-control" value=${userMoney } />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">充值金额：</label><input type="text" class="form-control" name="money" />
				</div>
				<input type="hidden" name="userId" value="${userId }">
				</div> <button type="submit" class="btn btn-default">增加</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>