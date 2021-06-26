package com.company.neo4j.vo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Node("OrderItem")
public class OrderItems implements Serializable {
	@Id @GeneratedValue private Long id;
	
	@Property("item") @NonNull private String item;
	@Property("unit_price") @NonNull private String unit_price;
	@Property("quantity") @NonNull private String quantity;

}
