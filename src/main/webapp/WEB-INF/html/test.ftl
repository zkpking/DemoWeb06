<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test FreeMarker</title>
</head>
<body>
	<h1>Test FreeMarker ftl --> ${message!}</h1>
	<h1>Test FreeMarker ftl --> ${message2!"测试有无数据是否为空"}</h1>
	<h3>
		<#list user as user>
			<b>${user.userName}</b>
			<b>${user.userPassword}</b></br>
		</#list>
	</h3>
	<h3>
		${json}
	</h3>
	<h3>
		<#list user as user>
			<#if user.userStatus!=1>
				<b>${user.userName}</b>
			</#if>
		</#list>
	</h3>
	<h3>
		<#list user as user>
			<#if user.userStatus=1>
				<b>${user.userName}</b>
			</#if>
		</#list>
	</h3>
</body>
</html>