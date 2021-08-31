package com.personal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
@SpringBootTest(value = "InterviewApplication.class")
@AutoConfigureMockMvc
public class ProductSearchControllerITTest {
	
	@Autowired
    private MockMvc mvc;
 

    
    @Test
    public void testProductResponse()
      throws Exception {
    	String jsonContent= "{\r\n" + 
    			"  \"Brand A\": [\r\n" + 
    			"    {\r\n" + 
    			"      \"id\": 1,\r\n" + 
    			"      \"name\": \"Product A\",\r\n" + 
    			"      \"price\": 12.99,\r\n" + 
    			"      \"event\": \"ON SALE\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"id\": 2,\r\n" + 
    			"      \"name\": \"Product B\",\r\n" + 
    			"      \"price\": 7.99\r\n" + 
    			"    }\r\n" + 
    			"  ],\r\n" + 
    			"  \"Brand B\": [\r\n" + 
    			"    {\r\n" + 
    			"      \"id\": 3,\r\n" + 
    			"      \"name\": \"Product C\",\r\n" + 
    			"      \"price\": 14.99\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"id\": 4,\r\n" + 
    			"      \"name\": \"Product D\",\r\n" + 
    			"      \"price\": 10.99\r\n" + 
    			"    }\r\n" + 
    			"  ]\r\n" + 
    			"}";
     
        mvc.perform(get("/api/v1/Products")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(jsonContent));
				;
    }
    

}
