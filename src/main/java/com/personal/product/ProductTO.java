package com.personal.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * This is the object that we will use to transfer the product data 
 * for the rest api as per requirement.
 * 
 * Trying to make it a immutable object ..
 */
@JsonInclude(Include.NON_NULL)
@Getter
@EqualsAndHashCode(of = { "id" })
public class ProductTO {

	private final Long id;
	private final String name;
	private final double price;
	@JsonIgnore
	private final String brand;
	private final String event;
	@JsonIgnore
	private final boolean onSale;
	
	public static final String ONSALE = "ON SALE";

	public ProductTO(ProductDO productDO) {
		super();
		this.id = productDO.getId();
		this.name = productDO.getName();
		this.price = productDO.getPrice();
		this.brand = productDO.getBrand();
		this.event = productDO.isOnSale() ? ONSALE : null;
		this.onSale = productDO.isOnSale();
	}



}
