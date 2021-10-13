package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.FoodCategory;
import com.app.revfoodsbackend.repository.FoodCategoryRepository;
import com.app.revfoodsbackend.service.FoodCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FoodCategoryServiceTest {
    FoodCategory foodCategory;
    @Autowired
    private FoodCategoryService foodCategoryService;
    @MockBean
    private FoodCategoryRepository foodCategoryRepository;

    @BeforeEach
    void setUp() throws Exception {
        foodCategory = new FoodCategory();
    }

    @Test
    @Order(1)
    public void addFoodCategoryTest() {
        when(foodCategoryRepository.save(foodCategory)).thenReturn(foodCategory);
        assertEquals(foodCategory, foodCategoryService.addFoodCategory(foodCategory));
    }

    @Test
    @Order(2)
    public void getAllFoodCategoriesTest() {
        when(foodCategoryRepository.findAll()).thenReturn(Stream.of(new FoodCategory(), new FoodCategory()).collect(Collectors.toList()));
        assertEquals(2, foodCategoryService.getAllFoodCategories().size());
    }

    @Order(3)
    @Test
    public void updateFoodCategoryTest() {
        when(foodCategoryRepository.save(foodCategory)).thenReturn(foodCategory);
        assertEquals(foodCategory, foodCategoryService.updateFoodCategory(foodCategory));
    }

    @Test
    @Order(4)
    public void getFoodCategoryByIdTest() throws Exception {
        int id = 1;
        when(foodCategoryRepository.findById(id)).thenReturn(Optional.of(foodCategory));
        assertEquals(foodCategory, foodCategoryService.getFoodCategoryById(id));
    }

    @Test
    @Order(5)
    public void deleteFoodCategoryTest() {
        when(foodCategoryRepository.getById(foodCategory.getFoodCategoryId())).thenReturn(foodCategory);
        foodCategoryService.deleteFoodCategory(foodCategory.getFoodCategoryId());
        verify(foodCategoryRepository).deleteById(foodCategory.getFoodCategoryId());
    }


}