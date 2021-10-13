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

import com.app.revfoodsbackend.model.Chef;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class ChefControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	Chef chef;
	
	@BeforeEach
	void setUp() throws Exception {
		chef = new Chef();
		chef.setChefName("manisha");
		chef.setChefUsername("manisha2");
		chef.setChefPassword("manisha@23");
	}
	
	@Test
	@Order(1)
	public void addChefControllerTest() throws Exception {
		mvc.perform(post("/chef").contentType(MediaType.APPLICATION_JSON).content(asJsonString(chef)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllChefControllerTest() throws Exception {
		mvc.perform(get("/chefs").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].chefName", is("manisha")))
		.andExpect(jsonPath("$[0].chefUsername", is("manisha2")))
		.andExpect(jsonPath("$[0].chefPassword", is("manisha@23")));
	}
	
	@Test
	@Order(3)
	public void getChefByIdControllerTest()  throws Exception{
		mvc.perform(get("/chef/{chefId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.chefId", is(1)))
        .andExpect(jsonPath("$.chefUsername", is("manisha2")));
	}
	
	@Test
	@Order(4)
	public void updateChefControllerTest() throws Exception{
		chef.setChefUsername("manisha2");
		mvc.perform(put("/chef").contentType(MediaType.APPLICATION_JSON).content(asJsonString(chef)))
		.andExpect(status().isOk());	
	}
	
	@Test
	@Order(5)
	public void deleteChefControllerTest() throws Exception{
		mvc.perform(delete("/chef/{chefId}", 1))
        .andExpect(status().isOk());
	}
	
	@Test
	@Order(6)
	public void addChefByUsernameAndPasswordControllerTest() throws Exception {
		mvc.perform(post("/chef/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(chef)))
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
