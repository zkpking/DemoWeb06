package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Upload")
public class FileUploadController {
	
	@RequestMapping(value="/fupload",method=RequestMethod.GET)
	public ModelAndView fupLoad(){
		ModelAndView view = new ModelAndView("fileUpload");
		return view;
	}

	@RequestMapping(value="/upload")
	public ModelAndView upload(){
		ModelAndView view = new ModelAndView("data");
		return view;
	}
	
}
