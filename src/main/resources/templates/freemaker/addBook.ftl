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
			<form role="form" action="/insertBook" method="get">
				<div class="form-group">
					 <label for="exampleInputEmail1">书名：</label><input type="text" class="form-control" name="bookName" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">书的价格</label><input type="text" class="form-control" name="bookPrice" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">书的描述</label><input type="text" class="form-control" name="bookDesc" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">书的类型</label><input type="text" class="form-control" name="bookType" />
				</div>
				<input type="hidden" name="userId" value="${userId }">
				</div> <button type="submit" class="btn btn-default">增加</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>