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

import com.app.revfoodsbackend.model.FoodCategory;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)

public class FoodCategoryControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	FoodCategory foodCategory;
	
	@BeforeEach
	void setUp() throws Exception {
		foodCategory=new FoodCategory();
		foodCategory.setFoodCategoryName("sweet");
		
	}
	
	@Test
	@Order(1)
	public void addFoodCategoryControllerTest() throws Exception {
		mvc.perform(post("/foodCategory").contentType(MediaType.APPLICATION_JSON).content(asJsonString(foodCategory)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void getAllFoodCategoryControllerTest() throws Exception {
		mvc.perform(get("/foodCategories").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
	}
	
	@Test
	@Order(3)
	public void getFoodCategorieByIdControllerTest()  throws Exception{
		mvc.perform(get("/foodCategory/{foodCategoryId}", 1))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.foodCategoryId", is(1)))
        .andExpect(jsonPath("$.foodCategoryName", is("sweet")));
	}
	
	@Test
	@Order(4)
	public void updateFoodCategoryControllerTest() throws Exception{
		foodCategory.setFoodCategoryName("spicy");
		mvc.perform(put("/foodCategory").contentType(MediaType.APPLICATION_JSON).content(asJsonString(foodCategory)))
		.andExpect(status().isOk());	
	}
	
	@Test
	@Order(5)
	public void deleteFoodCategoryControllerTest() throws Exception{
		mvc.perform(delete("/foodCategory/{foodCategoryId}", 1))
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
