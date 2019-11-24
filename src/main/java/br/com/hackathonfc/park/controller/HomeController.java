package br.com.hackathonfc.park.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	//just for test security
	@GetMapping("/")
	public String home() {
		return "Sucefully Log In";
	}
}
