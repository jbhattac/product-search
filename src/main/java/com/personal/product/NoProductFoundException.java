package com.personal.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Let us throw an exception if there is no products.
 * 
 * @author JBhattacharjee
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Products are found, something is not good!")
public class NoProductFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
}
