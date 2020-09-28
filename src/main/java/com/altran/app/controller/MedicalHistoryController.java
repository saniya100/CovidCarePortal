package com.altran.app.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altran.app.service.MedicalHistoryService;

@RestController
@RequestMapping(value="/com/history")
public class MedicalHistoryController {
	
	@Autowired
	private MedicalHistoryService service;

	@RequestMapping(value="/addhistory",method =RequestMethod.POST,produces="application/json",consumes="application/json")
	public String addHistory(@RequestBody HashMap map,HttpServletRequest request, HttpServletResponse response ) {
		String data=service.addHistory(map, response);
		return data;
		
	} 
	
	@RequestMapping(value="/getAllHistory",method =RequestMethod.GET,produces="application/json",consumes="application/json")
	public String getAllHistory(@RequestParam(required=false) HashMap map,HttpServletRequest request, HttpServletResponse response ) {
		String data=service.getAllHistory(map, response);
		return data;
		
	} 
}
