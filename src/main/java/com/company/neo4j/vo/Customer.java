package com.company.neo4j.vo;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Node("Customer")
public class Customer {
	@Id @GeneratedValue private Long id;
	
	@Property("customer_id") private String customerId;
	@Property("name") private String name;
	
	@Relationship(type = "CHILD", direction = Direction.INCOMING)
	private Set<Order> order;
	
	
}
