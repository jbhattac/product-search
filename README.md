# Experiment With Java-8 , Springboot

We would create a service that would offer search and filter capabilities for products. 

## Read Data from Persistence Store

The service should connect to some persistence store, where it can read products with the following structure:

Let us keep the onSale as a part of the Product table for the sake of this problem. 

```JSON
{
	"id": 1,
	"name": "Product A",
	"price": 12.99,
	"brand": "Brand A",
	"onSale": true
}
```

Expected Response
- 
We would return the response in the following format.

- All products are returned
- Products are grouped by `brand`, sorted alphabetically
- Property `brand` should be omitted on products
- Products inside a `brand` should be sorted ascending by `price`
- Property `onSale` should be converted to a property `event` of type String with the value "ON SALE"

```JSON
{
	"Brand A" : [{
		"id": 1,
		"name": "Product A",
		"price": 12.99,
		"event": "ON SALE"
	},
	{
		"id": 2,
		"name": "Product B",
		"price": 7.99
	}],
	"Brand B" : [{
		"id": 3,
		"name": "Product C",
		"price": 14.99
	},
	{
		"id": 4,
		"name": "Product D",
		"price": 10.99
	}]
}
```

# Run the project  

 
 - This needs a JVM using JDK 8 or higher
 - This is maven based can be build with ```maven clean install```
 - copy the jar personal-api-test-0.0.1.RELEASE.jar from <Build_loc>/target/personal-api-test-0.0.1.RELEASE.jar to where it  should be deployed.
 - Use the following command to run the application ```java -jar personal-api-test-0.0.1.RELEASE.jar```
 
 # Testing the project 
 
 There is already a automated  test  that covers the problem situations.
 
 We have provided an UI http://localhost:9001/swagger-ui.html with which the apis can be invoked and tested.
 




