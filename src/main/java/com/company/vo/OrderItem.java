package com.company.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItem {
	private String item;
	private String unit_price;
	private String quantity;

}
