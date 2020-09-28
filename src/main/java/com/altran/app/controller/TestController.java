package com.altran.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("welcome")
	public String getMsg() {
		return "Welcome!";
	}
}
