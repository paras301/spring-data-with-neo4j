package com.company.service;

import org.springframework.stereotype.Service;

import com.company.vo.OrderCartInput;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderProcessingService {

	public void processOrder(OrderCartInput req) throws Exception {
		log.info("req --> " + req);
		
	}
}
