package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.OrderProcessingService;
import com.company.vo.OrderCartInput;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/process")
@Slf4j
public class OrderProcessingController {
		
	@Autowired
	OrderProcessingService orderProcessingService;
	
	@PostMapping(value = "/customerorder")
	public ResponseEntity<Object> processPenfed(@RequestBody OrderCartInput req) throws Exception {
		
		orderProcessingService.processOrder(req);
		return new ResponseEntity<>("Order Processed Successfully!", HttpStatus.CREATED);
	}

}
