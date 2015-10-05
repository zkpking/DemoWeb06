package com.core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.core.pojo.SysUser;
import com.core.service.ISysUserService;

@Controller
@RequestMapping("sysUser")
public class SysUserController {
	
	@Resource
	private ISysUserService service;
	
	/**
	 * 测试查询方法
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/show/{id}")
	public ModelAndView showmethod(@PathVariable int id) {
	      //构建ModelAndView实例，并设置跳转地址
	      ModelAndView view = new ModelAndView("userInfo");
	      Map<String,Object> map = new HashMap<String,Object>();
	      map.put("id", id);
	      SysUser user = (SysUser) service.select(map);
	      //将数据放置到ModelAndView对象view中,第二个参数可以是任何java类型   
	      view.addObject("user",user);
	     //返回ModelAndView对象view   
	      return view;   
	}
	
	/**
	 * 条件查询1
	 * http://localhost:8080/DemoWeb05/sysUser/showOne?id=1
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showOne",method=RequestMethod.GET)
	public String selectById(@RequestParam("id")int id,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		SysUser user = (SysUser) service.select(map);
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	/**
	 * 条件查询2
	 * http://localhost:8080/DemoWeb05/sysUser/showOne/1
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showOne/{id}",method=RequestMethod.GET)
	public String selectById2(@PathVariable int id,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		SysUser user = (SysUser) service.select(map);
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	/**
	 * 查询条件3
	 * http://localhost:8080/DemoWeb05/sysUser/showMap
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showMap",method=RequestMethod.GET)
	public String selectByMap(Map<String,Object> map, Model model){
		map.put("id", 1);
		map.put("userName", "试");
		SysUser user = (SysUser) service.select(map);
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	/**
	 * 更新方法 只执行方法
	 */
	@RequestMapping(value="/update")
	public void update(){
		SysUser user = new SysUser();
		user.setId(1);
		user.setUserName("测试1");
		service.update(user);
	}
	
	/**
	 * 更新方法之后跳转
	 * 如果不写method表示get和post都通用
	 * 如果写通用则为method={RequestMethod.GET,RequestMethod.POST}
	 * http://localhost:8080/DemoWeb05/sysUser/update2
	 * @return
	 */
	@RequestMapping(value="/update2")
	public String update2(){
		SysUser user = new SysUser();
		user.setId(1);
		user.setUserName("测试1");
		service.update(user);
		return "redirect:showOne/1";
	}
	
	/**
	 * 测试freemarker
	 * @return
	 */
	@RequestMapping(value="/show",method=RequestMethod.GET)
    public ModelAndView showFreemarker() {
        ModelAndView view = new ModelAndView("test");
        view.addObject("message", "Say hi for Freemarker.");
        view.addObject("message2", null);
        //存list
        List<SysUser> list = new ArrayList<SysUser>();
        list.add(new SysUser(1,"东","1",0));
        list.add(new SysUser(2,"西","2",1));
        list.add(new SysUser(3,"南","3",0));
        list.add(new SysUser(4,"北","4",1));
        view.addObject("user",list);
        //存json
        JSONArray array = new JSONArray();
        String json = array.toJSONString(list);
        view.addObject("json",json);
        
        return view;
    }
	
	/**
	 * 查询多个数据
	 * @return
	 */
	@RequestMapping(value="/showList",method=RequestMethod.GET)
	public ModelAndView showList(){
		ModelAndView view = new ModelAndView("userList");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", "测试");
		
		List list = service.selectObjList(map);
		view.addObject("user",list);
		
		JSONArray array = new JSONArray();
        String json = array.toJSONString(list);
        view.addObject("json",json);
		return view;
	}
	
}
