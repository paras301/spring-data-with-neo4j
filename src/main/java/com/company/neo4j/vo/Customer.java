package com.company.neo4j.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Node("Customer")
public class Customer implements Serializable {
	@Id @GeneratedValue private Long id;
	
	@Property("customerId") @NonNull  private String customerId;
	@Property("name") @NonNull private String name;
	
	@Relationship(type = "PLACED", direction = Direction.OUTGOING)
	private Set<Order> order;
	
	public void placeOrder(Order order) {
		if(this.order == null) {
			this.order = new HashSet<>();
			this.order.add(order);
		} else {
			this.order.add(order);
		}
	}
	
}