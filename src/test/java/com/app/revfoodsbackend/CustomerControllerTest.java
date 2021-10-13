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
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.CustomerTable;
import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.model.OrderStatus;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	Customer customer;
	
	OrderStatus orderStatus;
	
	CustomerTable customerTable;
	
	Feedback feedback;
	
	@BeforeEach
	void setUp() throws Exception{
		customer=new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Akshay");
		customer.setCustomerEmail("Akshay@gmail.com");
		customer.setCustomerPhone(3456778893l);
		
		orderStatus = new OrderStatus();
		orderStatus.setOrderStatusId(1);
		orderStatus.setOrderStatus("Prep");
		
		customerTable = new CustomerTable();
		customerTable.setCustomerTableNumber(3);
		customerTable.setCustomerTableStatus(true);
		
		feedback = new Feedback();
		feedback.setFeedback("delicious food");
		feedback.setAmbience(4);
		feedback.setHygiene(4);
		feedback.setService(4);
	}
	
	@Test
	@Order(1)
	public void addCustomerControllerTest() throws Exception {
		mvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllCustomerControllerTest() throws Exception {
		mvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].customerName", is("Akshay")));
	}
	
	@Test
	@Order(3)
	public void getCustomerByIdControllerTest()  throws Exception{
		mvc.perform(get("/customer/{customerId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.customerId", is(1)))
        .andExpect(jsonPath("$.customerName", is("Akshay")));
	}
	
	@Test
	@Order(4)
	public void updateCustomerControllerTest() throws Exception{
		customer.setCustomerPhone(6748398656l);
		mvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
		.andExpect(status().isOk());	
	}
//	
//	@Test
//	@Order(5)
//	public void  addFeedbackToCustomerControllerTest() throws Exception{
//       customer.setFeedback(feedback);
//       int id=1;
//		mvc.perform(put("/customer/1/feedback",id).contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
//		.andExpect(status().isOk());
//	}
	
	@Test
	@Order(5)
	public void deleteCustomerControllerTest() throws Exception{
		mvc.perform(delete("/customer/{customerId}", 1))
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
