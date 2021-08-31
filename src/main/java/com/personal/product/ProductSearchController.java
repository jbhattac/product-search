package com.personal.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the rest controller the response to be
 * used by the clients
 * @author JBhattacharjee
 *
 */
@RestController
@RequestMapping("api/v1/Products")
public class ProductSearchController {

	@Autowired
	private ProductService productService;

	
	
	@GetMapping
	public Map<String, List<ProductTO>> getAllProducts() {
		return productService.getAllProductsByBrand();

	}

}
