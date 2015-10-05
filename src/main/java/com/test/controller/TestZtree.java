package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("testZtree")
public class TestZtree {
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public ModelAndView showList(){
		ModelAndView view = new ModelAndView("testZTree");
		return view;
	}
}
