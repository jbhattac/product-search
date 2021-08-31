package com.personal.product;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author JBhattacharjee
 * 
 * This represents the Service in here we can add some arbitrary logic about
 * displaying the product to the upper layer.
 * 
 */
public interface ProductService {



	/**
	 * Returns a list of products.
	 * Products are grouped by `brand`, sorted alphabetically
	 * Property `brand` should be omitted on products
	 * Products inside a `brand` should be sorted ascending by `price`
	 * Property `onSale` should be converted to a property `event` of type String with the value "ON SALE"
	 * NoProductFoundException is thrown when there is no Product present ....
	 */
	Map<String, List<ProductTO>> getAllProductsByBrand() throws NoProductFoundException;

}