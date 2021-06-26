package com.company.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.neo4j.repo.CustomerRepository;
import com.company.neo4j.repo.OrderRepository;
import com.company.neo4j.vo.Customer;
import com.company.neo4j.vo.Order;
import com.company.neo4j.vo.OrderItems;
import com.company.vo.OrderCartInput;
import com.company.vo.OrderItem;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderProcessingService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;

	public String processOrder(OrderCartInput req) throws Exception {
		log.info("req --> " + req);
		
		//Business Logic Layer to process incoming data
		
		Customer c = customerRepository.findCustomerByName(req.getName());
		
		log.info("c --> " + c);
		
		if (c == null) {
			c = new Customer(req.getCustomerId(), req.getName());
		}
		
		log.info("c --> " + c);
		
		Order oTemp = orderRepository.findOrderById(req.getName(), req.getOrderId());
		
		log.info("oTemp --> " + oTemp);
		
		if(oTemp == null) {
			
			oTemp = new Order(req.getOrderId(), req.getOrderDate());
			
			for(OrderItem otTemp : req.getItems()) {
				oTemp.addOrderItem(new OrderItems(otTemp.getItem(), otTemp.getUnit_price(), otTemp.getQuantity()));
			}
			
			
			log.info("oTemp --> " + oTemp);
			
			c.placeOrder(oTemp);
			
			log.info("c --> " + c);
			
			customerRepository.save(c);
		} else {
			log.error("Order --> " + req.getOrderId() + " Already processed!");
			return "Order was already processed";
		}
		
		//Business Logic end
		
		return "Customer Order Processed Successfully";
		
	}
}
