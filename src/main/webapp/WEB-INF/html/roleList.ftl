<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test FreeMarker</title>
</head>
<body>
	<h3>
		<#list role as role>
			<b>${role.roleName}</b>
		</#list>
	</h3>
	<br/>
	${json}
</body>
</html>