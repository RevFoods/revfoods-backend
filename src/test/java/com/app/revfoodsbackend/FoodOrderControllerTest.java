package com.app.revfoodsbackend;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.model.Chef;
import com.app.revfoodsbackend.model.FoodOrder;
import com.app.revfoodsbackend.model.OrderStatus;
import com.app.revfoodsbackend.model.Supervisor;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)

public class FoodOrderControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	FoodOrder foodOrder;
	Cart cart;
	Chef chef;
	Supervisor supervisor;
	OrderStatus orderStatus;
	
	
	@BeforeEach
	void setUp() throws Exception {
		foodOrder=new FoodOrder();
		cart = new Cart();	
	}

	@Test
	@Order(1)
	public void addFoodOrderControllerTest() throws Exception {
		mvc.perform(post("/foodOrder").contentType(MediaType.APPLICATION_JSON).content(asJsonString(foodOrder)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllFoodOrdersControllerTest() throws Exception {
		mvc.perform(get("/foodOrders").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
	}
	
	@Test
	@Order(3)
	public void getFoodorderByIdControllerTest()  throws Exception{
		mvc.perform(get("/foodOrder/{foodOrderId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.foodOrderId", is(1)));
	}
	
	@Test
	@Order(4)
	public void updateFoodOrderControllerTest() throws Exception{
		foodOrder.setFoodOrderId(1);
		mvc.perform(put("/foodOrder").contentType(MediaType.APPLICATION_JSON).content(asJsonString(foodOrder)))
		.andExpect(status().isOk());	
	}
	

	@Test
	@Order(5)
	public void deleteFoodOrderControllerTest() throws Exception{
		mvc.perform(delete("/foodOrder/{foodOrderId}", 1))
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
