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
@Node("Order")
public class Order implements Serializable {
	@Id @GeneratedValue private Long id;
	
	@Property("oid") @NonNull String orderId;
	@Property("date") @NonNull private String orderDate;
	
	@Relationship(type = "HAS_ITEMS", direction = Direction.OUTGOING)
	private Set<OrderItems> orderItems;
	
	public void addOrderItem(OrderItems orderItem) {
		if(this.orderItems == null) {
			this.orderItems = new HashSet<>();
			this.orderItems.add(orderItem);
		} else {
			this.orderItems.add(orderItem);
		}
	}
}
