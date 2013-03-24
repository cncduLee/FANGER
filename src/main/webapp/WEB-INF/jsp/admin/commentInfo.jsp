<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>站点管理</title>
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/js/jquery-1.7.2.js"/>" rel="stylesheet">
</head>
<body>
	<form id="searchForm" action="#" method="post" class="breadcrumb form-search">
		<label>名称：</label>
		<input maxlength="50" class="input-medium"/>&nbsp;
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
		
		<label>状态：</label>
		<input type="radio" name="status" value="" checked="checked"/><label>审核通过</label>
		<input type="radio" name="status" value=""/><label>审核未通过</label>
	</form>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>用户名</th><th>email</th><th>性别</th><th>状态</th><th>创建时间</th><th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td><a href="#" title="${user.name}">${user.name}</a></td>
				<td>${user.email}</td>
				<td>${user.gender}</td>
				<td>${user.status}</td>
				<td>${user.createAt}</td>
				<td>
    				<a href="#">修改</a>
					<a href="#" onclick="return confirmx('确认要删除吗？', this.href);" >删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>