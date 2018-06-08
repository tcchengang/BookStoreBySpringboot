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
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							 <a href="/getBooks?userId=${userId }">首页</a>
						</li>						
					</ul>
					<form class="navbar-form navbar-left" role="search" action="selectStores">
						<div class="form-group">
							<input type="text" class="form-control" name="bookId"/>
							<input type="hidden" name="userId" value="${userId }">
						</div> <button type="submit" class="btn btn-default">查询</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							 <a href="/login" class="dropdown-toggle" data-toggle="dropdown">个人中心<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="#">退出</a>
								</li>
								<li>
									 <a href="/login">登录</a>
								</li>
							
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							仓库编号
						</th>
						<th>
							书编号
						</th>
						<th>
							剩余数量
						</th>
						<th>
							卖出数量
						</th>
						<th>
							所赚的钱
						</th>
					</tr>
				</thead>
				<tbody>
					<#list pageInfo.list as p>
						<tr class="success">
							<td>
								${p.storeId}
							</td>
							<td>
								${p.bookId}
							</td>
							<td>
								${p.storeLeftnum}
							</td>
							<td>
								${p.storeSalednum}
							</td>
							<td>
								${p.storeMoney}
							</td>
							
						</tr>			
					</#list>					
				</tbody>
			</table>
			<ul class="pagination pull-right">
				<li>
					 <a href="/getAllStore?userId=${userId }&pageNum=${pageInfo.getPrePage() }">上一页</a>
				</li>
				<#list pageInfo.getNavigatepageNums() as index>
					<li>
					<#if index==pageInfo.getPageNum()>
					<li class="disabled"><a href="/getAllStore?userId=${userId }&pageNum=${index}">${index }</a></li> 
					<#else>
					<li><a href="/getAllStore?userId=${userId }&pageNum=${index}">${index }</a></li>
					</#if>
					</li>
				</#list>
				
				<li>
					 <a href="/getAllStore?userId=${userId }&pageNum=${pageInfo.getNextPage() }">下一页</a>
				</li>
			</ul>
		</div>
	</div>
</div>

<a href="/addBook">增加</a>


</body>
</html>