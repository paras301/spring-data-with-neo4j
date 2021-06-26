package com.company.neo4j.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Node("OrderItem")
public class OrderItems {
	@Id @GeneratedValue private Long id;
	
	@Property("item") private String item;
	@Property("unit_price") private String unit_price;
	@Property("quantity") private String quantity;

}
