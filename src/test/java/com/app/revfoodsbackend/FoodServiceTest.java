package com.app.revfoodsbackend;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.model.FoodCategory;
import com.app.revfoodsbackend.repository.FoodCategoryRepository;
import com.app.revfoodsbackend.repository.FoodRepository;
import com.app.revfoodsbackend.service.FoodService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FoodServiceTest {
	@Autowired
	private FoodService foodService;
	
	@MockBean
	private FoodRepository foodRepository;
	
	@MockBean
	private FoodCategoryRepository foodCategoryRepository;
	
	Food food;
	FoodCategory foodCategory;
	
	@BeforeEach
	void setUp() throws Exception{
		foodCategory=new FoodCategory();
		foodCategory.setFoodCategoryId(1);
		foodCategory.setFoodCategoryName("Chinese");
		
		food=new Food();
		food.setFoodId(1);
		food.setFoodName("Fried Rice");
		food.setFoodPrepTime(10);
		food.setFoodPrice(100.00);
		food.setFoodStatus(true);
		food.setFoodType("Chinese");
		food.setFoodCategory(foodCategory);
	}
	
	@Test
	@Order(1)
	public void addFoodTest() {
		when(foodRepository.save(food)).thenReturn(food);
		assertEquals(food,foodService.addFood(food));
	}
	
	@Test
	@Order(2)
	public void updateFoodTest() {
		when(foodRepository.save(food)).thenReturn(food);
		assertEquals(food,foodService.updateFood(food));
	}
	
	@Test
	@Order(3)
	public void getAllFoodsTest() {
		when(foodRepository.findAll()).thenReturn(Stream.of(new Food(),new Food()).collect(Collectors.toList()));
		assertEquals(2, foodService.getAllFoods().size());
	}
	
	@Test
	@Order(4)
	public void getFoodByFoodIdTest() {
		when(foodRepository.findById(food.getFoodId())).thenReturn(Optional.of(food));
		assertEquals(food,foodService.getFoodByFoodId(food.getFoodId()));
	}

	@Test
	@Order(5)
	public void getFoodsByCategoryIdTest() {
		when(foodCategoryRepository.findById(foodCategory.getFoodCategoryId())).thenReturn(Optional.of(foodCategory));
		when(foodRepository.findAllByFoodCategory(foodCategory)).thenReturn(Stream.of(new Food(),new Food()).collect(Collectors.toList()));
		assertEquals(0,foodService.getFoodsByCategoryId(1).size());
	}
	
	@Test
	@Order(6)
	public void addFoodToFoodCategoryTest() {
		when(foodCategoryRepository.findById(foodCategory.getFoodCategoryId())).thenReturn(Optional.of(foodCategory));
		when(foodRepository.save(food)).thenReturn(food);
		assertEquals(food,foodService.addFoodToFoodCategory(food, foodCategory.getFoodCategoryId()));		
	}

	@Test
	@Order(7)
	public void updateFoodStatusTest() {
		when(foodRepository.findById(food.getFoodId())).thenReturn(Optional.of(food));
		when(foodRepository.save(food)).thenReturn(food);
		assertEquals(food,foodService.updateFoodStatus(food.getFoodId(), true));
	}
	
	@Test
	@Order(8)
	public void deleteFoodTest() {		
		when(foodRepository.findById(food.getFoodId())).thenReturn(Optional.of(food));
		foodService.deleteFood(food.getFoodId());
		verify(foodRepository).deleteById(food.getFoodId());
	}
}
