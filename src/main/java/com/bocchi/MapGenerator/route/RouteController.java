package com.bocchi.MapGenerator.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    @GetMapping("/")
    public String home() {
    	return "index";
	}

	@GetMapping("/map/getMap")
	public String getMethodName() {
		return "map";
	}
	
	
	@GetMapping("/error")
	public String error(@RequestParam(value="error",defaultValue = "valio verga") String error){
		return String.format("Hello %s!", error);
	}
}
