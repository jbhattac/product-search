package com.personal.product;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	private  ProductSearchRepository repository;


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.personal.product.service.ProductService#getAllProducts()
	 */
	@Override
	public Map<String, List<ProductTO>> getAllProductsByBrand() throws NoProductFoundException {
		Iterable<ProductDO> pdtItr = repository.findAll();
		if (null == pdtItr ||IterableUtils.size(pdtItr) == 0) {
			throw new NoProductFoundException();
		}

		return StreamSupport.stream(pdtItr.spliterator(), false)
				.map(pDO -> new ProductTO(pDO))
								// the sorting of the Brand property
									.collect(Collectors.groupingBy(ProductTO::getBrand, HashMap::new,
											// For the down stream List Collection we need to do more processing
											Collectors.mapping(p -> p,
																Collectors.collectingAndThen(Collectors.toList(),
																	l -> l.stream()
																	// Now for each of the list corresponding to the brand we sort it by price.
																			.collect(Collectors.toList())))));
	}

}
