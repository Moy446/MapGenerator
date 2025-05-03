package com.bocchi.MapGenerator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    	return String.format("Hello %s!", name);
	}

	@GetMapping("/error")
	public String error(@RequestParam(value="error",defaultValue = "valio verga") String error){
		return String.format("Hello %s!", error);
	}
}
