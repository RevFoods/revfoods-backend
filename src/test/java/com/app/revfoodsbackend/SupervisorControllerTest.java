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

import com.app.revfoodsbackend.model.Supervisor;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class SupervisorControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	Supervisor supervisor;
	
	@BeforeEach
	void setUp() throws Exception {
		supervisor = new Supervisor();
		supervisor.setSupervisorUsername("manisha");
		supervisor.setSupervisorPassword("manisha1");
	}
	
	@Test
	@Order(1)
	public void addSupervisorControllerTest() throws Exception {
		mvc.perform(post("/supervisor").contentType(MediaType.APPLICATION_JSON).content(asJsonString(supervisor)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllSupervisorsControllerTest() throws Exception {
		mvc.perform(get("/supervisors").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].supervisorUsername", is("manisha")));
	}
	
	@Test
	@Order(3)
	public void getSupervisorByIdControllerTest()  throws Exception{
		mvc.perform(get("/supervisor/{supervisorId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.supervisorId", is(1)))
        .andExpect(jsonPath("$.supervisorUsername", is("manisha")));
	}
	
	@Test
	@Order(4)
	public void updateSupervisorControllerTest() throws Exception{
		supervisor.setSupervisorUsername("manisha2");
		mvc.perform(put("/supervisor").contentType(MediaType.APPLICATION_JSON).content(asJsonString(supervisor)))
		.andExpect(status().isOk());	
	}
	
	@Test
	@Order(5)
	public void deleteSupervisorControllerTest() throws Exception{
		mvc.perform(delete("/supervisor/{supervisorId}", 1))
        .andExpect(status().isOk());
	}
	
	@Test
	@Order(6)
	public void addSupervisorByUsernameAndPasswordControllerTest() throws Exception {
		mvc.perform(post("/supervisor/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(supervisor)))
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

	
	
	
	
	

