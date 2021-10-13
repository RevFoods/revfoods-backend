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

import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.model.FoodCategory;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class FoodControllerTest {

	@Autowired
	private MockMvc mvc;

	Food food;

	FoodCategory foodCategory;

	@BeforeEach
	void setUp() throws Exception {
		food = new  Food();
		food.setFoodName("Momo");
		food.setFoodPrepTime(20);
		food.setFoodType("veg");
		food.setFoodPrice(50.00);
		food.setFoodAvatar("Img");
		food.setFoodStatus(true);
	}

	@Test
	@Order(1)
	public void addFoodControllerTest() throws Exception {
		mvc.perform(post("/food").contentType(MediaType.APPLICATION_JSON).content(asJsonString(food)))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	public void getAllFoodsControllerTest() throws Exception {
		mvc.perform(get("/foods").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].foodName", is("Momo")));
	}

	@Test
	@Order(3)
	public void getFoodByIdControllerTest()  throws Exception{
		mvc.perform(get("/food/{foodId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.foodId", is(1)))
        .andExpect(jsonPath("$.foodName", is("Momo")));
	}

	@Test
	@Order(4)
	public void updateFoodControllerTest() throws Exception{
		food.setFoodPrice(55.55);
		mvc.perform(put("/food").contentType(MediaType.APPLICATION_JSON).content(asJsonString(food)))
		.andExpect(status().isOk());
	}

	@Test
	@Order(5)
	public void updateFoodStatuControllerTest() throws Exception {
		food.setFoodStatus(true);
		mvc.perform(put("/food/{foodId}/foodStatus/{foodStatus}",1,food.isFoodStatus()).contentType(MediaType.APPLICATION_JSON).content(asJsonString(food)))
		.andExpect(status().isOk());
	}

	@Test
	@Order(6)
	public void deleteFoodControllerTest() throws Exception{
		mvc.perform(delete("/food/{foodId}", 1))
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
