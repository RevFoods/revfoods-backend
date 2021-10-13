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

import com.app.revfoodsbackend.model.Feedback;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class FeedbackControllerTest {

	@Autowired
	private MockMvc mvc;

	Feedback feedback;

	@BeforeEach
	void setUp() throws Exception {
		feedback = new Feedback();
		feedback.setFeedback("delicious food");
		feedback.setAmbience(4);
		feedback.setHygiene(4);
		feedback.setService(4);
	}

	@Test
	@Order(1)
	public void addFeedbackControllerTest() throws Exception {
		mvc.perform(post("/feedback").contentType(MediaType.APPLICATION_JSON).content(asJsonString(feedback)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllFeedbacksControllerTest() throws Exception {
		mvc.perform(get("/feedbacks").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].feedback", is("delicious food")));
	}
	
	@Test
	@Order(3)
	public void getFeedbackByIdControllerTest()  throws Exception{
		mvc.perform(get("/feedback/{feedbackId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.feedbackId", is(1)))
        .andExpect(jsonPath("$.feedback", is("delicious food")));
	}
	
	@Test
	@Order(4)
	public void updateFeedbackControllerTest() throws Exception{
		feedback.setAmbience(5);
		mvc.perform(put("/feedback").contentType(MediaType.APPLICATION_JSON).content(asJsonString(feedback)))
		.andExpect(status().isOk());	
	}
	
	@Test
	@Order(5)
	public void deleteFeedbackControllerTest() throws Exception{
		mvc.perform(delete("/feedback/{feedbackId}", 1))
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
