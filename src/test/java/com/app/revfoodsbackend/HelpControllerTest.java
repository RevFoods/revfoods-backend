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

import com.app.revfoodsbackend.model.Help;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class HelpControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	Help help;
	
	@BeforeEach
	void setUp() throws Exception {
		help=new Help();
		help.setHelpStatus(true);
	}
	
	@Test
	@Order(1)
	public void addHelpControllerTest() throws Exception {
		mvc.perform(post("/help").contentType(MediaType.APPLICATION_JSON).content(asJsonString(help)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllHelpControllerTest() throws Exception {
		mvc.perform(get("/helps").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].helpStatus", is(true)));
	}
	
	@Test
	@Order(3)
	public void getHelpByIdControllerTest()  throws Exception{
		mvc.perform(get("/help/{helpId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.helpId", is(1)))
        .andExpect(jsonPath("$.helpStatus", is(true)));
	}
	
	@Test
	@Order(4)
	public void updateHelpControllerTest() throws Exception{
		help.setHelpStatus(true);
		mvc.perform(put("/help/{helpId}/helpStatus/{helpStatus}",1,help.isHelpStatus()).contentType(MediaType.APPLICATION_JSON).content(asJsonString(help)))
		.andExpect(status().isOk());	
	}
	
	@Test
	@Order(5)
	public void  updateHelpStatusControllerTest() throws Exception {
		help.setHelpStatus(true);
		mvc.perform(put("/help").contentType(MediaType.APPLICATION_JSON).content(asJsonString(help)))
		.andExpect(status().isOk());
	}
	
	@Test
	@Order(6)
	public void deleteHelpControllerTest() throws Exception{
		mvc.perform(delete("/help/{helpId}", 1))
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
