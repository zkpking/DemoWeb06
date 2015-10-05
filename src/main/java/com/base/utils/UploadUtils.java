package com.base.utils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtils {

	public static HashMap<String,Object> uploadFiles(HttpServletRequest request,HttpServletResponse response){
		HashMap<String,Object> map = new HashMap<String, Object>();
		String fileName = null;
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String realPath = request.getRealPath("/");
			String dirPath = realPath+"/upload";
			//System.out.println("dirPath:"+dirPath);
			File dirFile = new File(dirPath);
			if(!dirFile.exists()){
				dirFile.mkdirs();
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = upload.parseRequest(request);
			if(null!=items){
				Iterator itr = items.iterator();
				while(itr.hasNext()){
					FileItem item = (FileItem) itr.next();
					if(item.isFormField()){
						continue;
					}else{
						String name = item.getName();
						int i = name.lastIndexOf(".");
						String ext = name.substring(i,name.length());
						fileName = new Date().getTime()+ext;
						File saveFile = new File(dirPath,fileName);
						item.write(saveFile);
						map.put("name", item.getName());
						map.put("newName", fileName);
						map.put("size", item.getSize());
						map.put("url", "upload/"+fileName);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
