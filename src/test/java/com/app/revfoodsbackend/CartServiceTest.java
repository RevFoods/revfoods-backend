package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.repository.CartRepository;
import com.app.revfoodsbackend.repository.CustomerRepository;
import com.app.revfoodsbackend.repository.FoodRepository;
import com.app.revfoodsbackend.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CartServiceTest {

    @Autowired
    CartService cartService;

    @MockBean
    CartRepository cartRepository;

    @MockBean
    FoodRepository foodRepository;

    @MockBean
    CustomerRepository customerRepository;

    Cart cart;

    @BeforeEach
    void setUp() throws Exception {
        cart = new Cart();
        cart.setCartQuantity(4);
    }

    @Test
    @Order(1)
    public void addCartTest() {
        when(cartRepository.save(cart)).thenReturn(cart);
        assertEquals(cart, cartService.addCart(cart));
    }

    @Test
    @Order(2)
    public void getAllCartsTest() {
        when(cartRepository.findAll()).thenReturn(Stream.of(new Cart(), new Cart()).collect(Collectors.toList()));
        assertEquals(2, cartService.getAllCarts().size());
    }

    @Test
    @Order(3)
    public void getCartByCartIdTest() {
        when(cartRepository.findById(cart.getCartId())).thenReturn(Optional.of(cart));
        assertEquals(cart, cartService.getCartByCartId(cart.getCartId()));
    }

    @Test
    @Order(4)
    public void addFoodAndCustomerToCartTest() {
        Customer customer = new Customer();
        customer.setCustomerName("Akshay");
        customer.setCustomerEmail("Akshay@gmail.com");
        customer.setCustomerPhone(3456778893l);

        Customer newCustomer = customerRepository.save(customer);
        cart.setCustomer(newCustomer);

        Food food = new Food();
        food.setFoodName("Momo");
        food.setFoodPrepTime(20);
        food.setFoodPrice(50.00);
        food.setFoodAvatar("Img");
        food.setFoodType("veg");
        food.setFoodStatus(true);

        Food newFood = foodRepository.save(food);
        cart.setFood(newFood);
        //Cart newCart=cartRepository.save(cart);


        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
        when(foodRepository.findById(food.getFoodId())).thenReturn(Optional.of(food));
        when(cartRepository.save(cart)).thenReturn(cart);
        assertEquals(cart, cartService.addFoodAndCustomerToCart(food.getFoodId(), customer.getCustomerId(), cart.getCartQuantity()));

    }

    @Test
    @Order(5)
    public void getAllCartsByCustomerIdTest() {
        Customer customer = new Customer();
        customer.setCustomerName("Akshay");
        customer.setCustomerEmail("Akshay@gmail.com");
        customer.setCustomerPhone(3456778893l);
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
        when(cartRepository.findCartsByCustomer(customer)).thenReturn(Stream.of(new Cart(), new Cart()).collect(Collectors.toList()));
        assertEquals(2, cartService.getAllCartsByCustomerId(cart.getCartId()).size());
    }

    @Test
    @Order(6)
    public void deleteCartTest() {
        when(cartRepository.findById(cart.getCartId())).thenReturn(Optional.of(cart));
        cartService.deleteCart(cart.getCartId());
        verify(cartRepository).deleteById(cart.getCartId());
    }

}
