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
import org.springframework.test.web.servlet.MockMvc;

import com.app.revfoodsbackend.model.CustomerTable;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class CustomerTableControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	CustomerTable customerTable;
	
	@BeforeEach
	void setUp() throws Exception{
		customerTable = new CustomerTable();
		customerTable.setCustomerTableNumber(4);
		customerTable.setCustomerTableStatus(true);
	}
	
	@Test
	@Order(1)
	public void addCustomerTableControllerTest() throws Exception{
		mvc.perform(post("/customerTable").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customerTable)))
		.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllCustomerTableControllerTest() throws Exception {
		mvc.perform(get("/customerTables").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].customerTableNumber", is(4)));
	}
	
	@Test
	@Order(3)
	public void getAllCustomerTablesByCustomerTableStatusControllerTest() throws Exception{
		mvc.perform(get("/customerTables/customerTableStatus/{customerTableStatus}",customerTable.isCustomerTableStatus()).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
        
	}
	
	@Test
	@Order(4)
	public void getCustomerTableByIdControllerTest()  throws Exception{
		mvc.perform(get("/customerTable/{customerTableId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.customerTableId", is(1)))
        .andExpect(jsonPath("$.customerTableNumber", is(4)));
	}
	
	@Test
	@Order(5)
	public void updateCustomerTableControllerTest() throws Exception{
		customerTable.setCustomerTableStatus(false);
		mvc.perform(put("/customerTable").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customerTable)))
		.andExpect(status().isOk());	
	}
	
	@Test
	@Order(6)
	public void deleteCustomerTableControllerTest() throws Exception{
		mvc.perform(delete("/customerTable/{customerTableId}", 1))
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
