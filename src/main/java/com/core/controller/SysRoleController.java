package com.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.core.service.ISysRoleService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.core.pojo.SysRole;

@Controller
@RequestMapping("sysRole")
public class SysRoleController {
	
	@Resource
	private ISysRoleService service;
	
	/**
	 * 查询多条数据
	 * @return
	 */
	@RequestMapping(value="/showList",method=RequestMethod.GET)
	public ModelAndView showList(){
		ModelAndView view = new ModelAndView("roleList");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName", "测试");
		
		List list = service.selectObjList(map);
		view.addObject("role",list);
		
		JSONArray array = new JSONArray();
        String json = array.toJSONString(list);
        view.addObject("json",json);
		return view;
	}
	
	@RequestMapping(value="/showList2")
	public ModelAndView showList2(){
		ModelAndView view = new ModelAndView("roleList2");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName", "测试1");
		SysRole role = (SysRole) service.select(map);
		
		JSONArray array = new JSONArray();
        String json = array.toJSONString(role);
        view.addObject("json",json);
		return view;
	}
	
}
