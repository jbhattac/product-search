package com.personal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.personal.product.NoProductFoundException;
import com.personal.product.ProductDO;
import com.personal.product.ProductSearchRepository;
import com.personal.product.ProductServiceImpl;
import com.personal.product.ProductTO;

/**
 * There can be some other test as well..
 * 
 * @author JBhattacharjee
 *
 */
public class ProductServiceImplTests {

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Mock
	private ProductSearchRepository repository;
	


	@Mock
	private ProductDO productDO1, productDO2, productDO3, productDO4;

	private Map<String, List<ProductTO>> productMap;

	private static final String BRAND_A = "Brand A";
	private static final String BRAND_B = "Brand B";

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		// gathering all the when conditions together here 
		when(repository.findAll()).thenReturn(createProducts());
		when(productDO1.getBrand()).thenReturn(BRAND_A);
		when(productDO1.getPrice()).thenReturn(12.99);
		when(productDO1.isOnSale()).thenReturn(true);

		when(productDO2.getBrand()).thenReturn(BRAND_A);
		when(productDO2.getPrice()).thenReturn(7.99);

		when(productDO3.getBrand()).thenReturn(BRAND_B);
		when(productDO3.getPrice()).thenReturn(14.99);

		when(productDO4.getBrand()).thenReturn(BRAND_B);
		when(productDO3.getPrice()).thenReturn(10.99);

	
		productMap = productServiceImpl.getAllProductsByBrand();
	}

	@Test
	public void validateProductReturnsizes() {
		// then
		Assert.assertEquals(productMap.get(BRAND_A).size(), 2);
		Assert.assertEquals(productMap.get(BRAND_B).size(), 2);
	}

	@Test
	public void validateOnSaleEvent() {
		//then
		List<ProductTO> products = productMap.get(BRAND_A);
		ProductTO product1 = products.get(0);
		ProductTO product2 = products.get(1);
		// on sale should be be displayed
		Assert.assertTrue(product1.isOnSale());
		Assert.assertTrue(product1.getEvent().equals(ProductTO.ONSALE));
		// on sale should be false and not be displayed
		Assert.assertFalse(product2.isOnSale());
		Assert.assertNull(product2.getEvent());
	}

	@Test
	public void validateAllProductsHaveSameBrandForSameBrandKey() {
		List<ProductTO> products = productMap.get(BRAND_A);
		//then
		for (ProductTO product : products) {
			Assert.assertEquals(product.getBrand(), BRAND_A);
		}
	}

	@Test
	public void validatesortigByPrice() {
		List<ProductTO> products = productMap.get(BRAND_A);
		// validate the order in list according to price.
		//then
		Assert.assertThat(products.get(0).getPrice(), equalTo(12.99));
		Assert.assertThat(products.get(1).getPrice(), equalTo(7.99));

	}
	
	@Test(expected=NoProductFoundException.class)
	public void validateException() {
	     when(repository.findAll()).thenReturn(null);
	     productServiceImpl.getAllProductsByBrand();
	}

	private List<ProductDO> createProducts() {
		List<ProductDO> products = Arrays.asList(productDO1, productDO2, productDO3, productDO4);
		return products;
	}

}
