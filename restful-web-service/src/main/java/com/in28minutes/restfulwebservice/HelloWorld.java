package com.in28minutes.restfulwebservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	@ResponseBody
	@GetMapping(path = "/hello-world")
	public String getMsg() {
		return "Hello World...!";
	}
	@ResponseBody
	@GetMapping(path = "/hello-world-been")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Welcome Aditya Saini");
	}
	@ResponseBody
	@GetMapping(path = "/hello-world-been-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World,  %s ", name));
	}


}
