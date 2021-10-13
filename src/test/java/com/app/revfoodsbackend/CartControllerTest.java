package com.app.revfoodsbackend;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.Food;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@TestPropertySource(locations = "classpath:application.properties")
public class CartControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	Cart cart;
	
	Customer customer;
	
	Food food; 
	
	@BeforeEach
	void setUp() throws Exception {
		cart = new Cart();
		cart.setCartQuantity(6);
		
	    customer=new Customer();
		customer.setCustomerName("Akshay");
		customer.setCustomerEmail("Akshay@gmail.com");
		customer.setCustomerPhone(3456778893l);
		
	
	    food = new Food();
		food.setFoodName("Momo");
		food.setFoodPrepTime(20);
		food.setFoodPrice(50.00);
		food.setFoodAvatar("Img");
		food.setFoodType("veg");
		food.setFoodStatus(true);
	}
	
	@Test
	@Order(1)
	public void addCartControllerTest() throws Exception{
		mvc.perform(post("/cart").contentType(MediaType.APPLICATION_JSON).content(asJsonString(cart)))
		.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllCartsControllerTest() throws Exception {
		mvc.perform(get("/carts").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].cartQuantity", is(6)));
	}
	
	@Test
	@Order(3)
	public void getCartByCartIdControllerTest() throws Exception {
		mvc.perform(get("/cart/{cartId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.cartId", is(1)))
        .andExpect(jsonPath("$.cartQuantity", is(6)));
        
	}
	
	@Test
	@Order(4)
	public void  updateCartControllerTest() throws Exception {
		cart.setCartQuantity(7);
		mvc.perform(put("/cart").contentType(MediaType.APPLICATION_JSON).content(asJsonString(cart)))
		.andExpect(status().isOk());	
	}

	
	@Test
	@Order(5)
	public void deleteCartControllerTest() throws Exception{
		mvc.perform(delete("/cart/{cartId}", 1))
        .andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
