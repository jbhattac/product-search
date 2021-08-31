package com.personal.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author JBhattacharjee
 * 
 * We use this object as an entity as well we add some 
 * validations just to keep things consistent and in one place.
 *
 */
@Entity
@Table(name = "PRODUCT" )
@Data
@EqualsAndHashCode(of = { "id" })
public class ProductDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="NAME",nullable = false)
	@NotNull(message = "Name  can not be null!")
    private String name;
	@JsonIgnore
	@Column(name="BRAND",nullable = false)
	@NotNull(message = "Brand  can not be null!")
    private String brand;
	@Column(name="PRICE",nullable = false)
	@Min(value = 0, message = "Price cannot be less than 0 ")
    private double price;
    @Column(name="ONSALE")
    private boolean onSale;
}
