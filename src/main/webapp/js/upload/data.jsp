<%@ page language="java" import="java.util.HashMap,com.base.utils.UploadUtils,com.alibaba.fastjson.JSON" pageEncoding="UTF-8"%>
<% 
	HashMap<String,Object> map = UploadUtils.uploadFiles(request, response);
	out.print(JSON.toJSONString(map));
%>