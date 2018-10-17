package com.esther.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String hello(@RequestParam(value="name", required=false) String humanName) {
		if (humanName == null) {
			return "<h1>Hello Human!</h1> <p>Welcome to SpringBoot!</p>";
		}
		else {
			return "<h1>Hello " + humanName + "!</h1><p>Welcome to SpringBoot!</p>";
		}
		
	}

}
