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
			<form role="form" action="/insertStore" method="get">
				<div class="form-group">
					 <label for="exampleInputEmail1">书编号：</label><input type="text" class="form-control" name="bookId" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">入库本数：</label><input type="text" class="form-control" name="storeLeftnum" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">卖出本数：</label><input type="text" class="form-control" name="storeSalednum" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">初始金额：：</label><input type="text" class="form-control" name="storeMoney" />
				</div>
				<input type="hidden" name="userId" value="${userId }">
				</div> <button type="submit" class="btn btn-default">增加</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>