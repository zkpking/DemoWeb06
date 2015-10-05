<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/js/upload/upload.css"></link>
<script src="<%=contextPath%>/js/jquery-1.4.4.min.js"></script>
<script src="<%=contextPath%>/js/upload/upload.js"></script>
<title>File Upload</title>
</head>
<body>
	<h1>文件</h1>
	<div id="fileSave">
		<span id="saveFile" style="border:1px solid black"></span>
	</div>
	<script type="text/javascript">
		$.tmUpload({
			btnId:"saveFile",
			url:"data.jsp",
			limitSize:"100 MB",
			fileTypes:"*.doc;*.docx",
			multiple:false,
			callback:function(serverData,file){
				//alert(serverData);
				var jsonData = eval("("+serverData+")");
				//jsonData.name：原始名字，jsonData.url：真实路径加存入存储名字
				//alert(jsonData.name+"----"+jsonData.newName+"--"+jsonData.url);
				$("#fileSave").append(
					"<input type='hidden' name='filename' value='"+jsonData.name+"'/>"+
					"<input type='hidden' name='newfilename' value='"+jsonData.newName+"'/>"+
					"<input type='hidden' name='fileurl' value='"+jsonData.url+"'/>"
				);
			}
		});
	</script>
</body>
</html>