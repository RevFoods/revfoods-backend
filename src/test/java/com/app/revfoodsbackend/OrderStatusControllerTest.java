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

import com.app.revfoodsbackend.model.OrderStatus;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class OrderStatusControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	OrderStatus orderStatus;
	
	@BeforeEach
	void setUp() throws Exception {
		orderStatus = new OrderStatus();
		orderStatus.setOrderStatus("delivered");
	}

	@Test
	@Order(1)
	public void addOrderStatusControllerTest() throws Exception {
		mvc.perform(post("/orderstatus").contentType(MediaType.APPLICATION_JSON).content(asJsonString(orderStatus)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllOrderStatusControllerTest() throws Exception {
		mvc.perform(get("/orderstatuses").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].orderStatus", is("delivered")));
	}
	
	@Test
	@Order(3)
	public void getOrderStatusByIdControllerTest()  throws Exception{
		mvc.perform(get("/orderstatus/{orderStatusId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.orderStatusId", is(1)))
        .andExpect(jsonPath("$.orderStatus", is("delivered")));
	}
	
	@Test
	@Order(4)
	public void updateOrderStatusControllerTest() throws Exception{
		orderStatus.setOrderStatus("Delivered");
		mvc.perform(put("/orderstatus").contentType(MediaType.APPLICATION_JSON).content(asJsonString(orderStatus)))
		.andExpect(status().isOk());	
	}
	
	@Test
	@Order(5)
	public void deleteOrderStatusControllerTest() throws Exception{
		mvc.perform(delete("/orderstatus/{orderStatusId}", 1))
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
