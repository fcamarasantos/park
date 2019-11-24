package br.com.hackathonfc.park.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class IndexController {

	
	@RequestMapping("/")
	   public ModelAndView index(){
	   return new ModelAndView("index");
	}
}
