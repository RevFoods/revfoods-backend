package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.*;
import com.app.revfoodsbackend.repository.*;
import com.app.revfoodsbackend.service.FoodOrderService;
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
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class FoodOrderServiceImplTest {

    FoodOrder foodOrder;
    Cart cart;
    Chef chef;
    Supervisor supervisor;
    OrderStatus orderStatus;
    @Autowired
    private FoodOrderService foodOrderService;
    @MockBean
    private FoodOrderRepository foodOrderRepository;
    @MockBean
    private CartRepository cartRepository;
    @MockBean
    private ChefRepository chefRepository;
    @MockBean
    private OrderStatusRepository orderStatusRepository;
    @MockBean
    private SupervisorRepository supervisorRepository;
    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() throws Exception {
        foodOrder = new FoodOrder();

        cart = new Cart();
        cart.setCartId(1);

        chef = new Chef();
        chef.setChefId(1);

        supervisor = new Supervisor();
        supervisor.setSupervisorId(1);

        orderStatus = new OrderStatus();
        orderStatus.setOrderStatusId(1);

        foodOrder.setCart(cart);
        foodOrder.setChef(chef);
        foodOrder.setSupervisor(supervisor);
        foodOrder.setOrderStatus(orderStatus);
    }


    @Test
    @Order(1)
    public void addFoodOrder() {
        when(foodOrderRepository.save(foodOrder)).thenReturn(foodOrder);
        assertEquals(foodOrder, foodOrderService.addFoodOrder(foodOrder));

    }

    @Test
    @Order(2)
    public void updateFoodOrder() {
        when(foodOrderRepository.save(foodOrder)).thenReturn(foodOrder);
        assertEquals(foodOrder, foodOrderService.updateFoodOrder(foodOrder));
    }

    @Test
    @Order(3)
    public void getAllFoodOrders() {
        when(foodOrderRepository.findAll()).thenReturn(Stream.of(new FoodOrder(), new FoodOrder()).collect(Collectors.toList()));
        assertEquals(2, foodOrderService.getAllFoodOrders().size());

    }

    @Test
    @Order(4)
    public void getFoodOrderById() {
        int id = 1;
        when(foodOrderRepository.findById(id)).thenReturn(Optional.of(foodOrder));
        assertEquals(foodOrder, foodOrderService.getFoodOrderById(id));
    }

    @Test
    @Order(5)
    public void addCartToFoodOrderTest() {
        when(cartRepository.getById(cart.getCartId())).thenReturn(cart);
        when(chefRepository.findById(chef.getChefId())).thenReturn(Optional.of(chef));
        when(supervisorRepository.findById(supervisor.getSupervisorId())).thenReturn(Optional.of(supervisor));
        when(orderStatusRepository.findById(orderStatus.getOrderStatusId())).thenReturn(Optional.of(orderStatus));
        when(foodOrderRepository.save(foodOrder)).thenReturn(foodOrder);
        assertEquals(foodOrder, foodOrderService.addCartToFoodOrder(cart.getCartId()));
    }

    @Test
    @Order(6)
    public void updateFoodOrderStatus() {
        when(foodOrderRepository.findById(foodOrder.getFoodOrderId())).thenReturn(Optional.of(foodOrder));
        when(orderStatusRepository.findById(orderStatus.getOrderStatusId())).thenReturn(Optional.of(orderStatus));
        when(foodOrderRepository.save(foodOrder)).thenReturn(foodOrder);
        assertEquals(foodOrder, foodOrderService.updateFoodOrderStatus(foodOrder.getFoodOrderId(), orderStatus.getOrderStatusId()));
    }

    @Test
    @Order(7)
    public void getAllFoodOrdersByOrderStatusId() {
        when(orderStatusRepository.findById(orderStatus.getOrderStatusId())).thenReturn(Optional.of(orderStatus));
        when(foodOrderRepository.findAllByOrderStatus(orderStatus)).thenReturn(Stream.of(new FoodOrder(), new FoodOrder()).collect(Collectors.toList()));
        assertEquals(2, foodOrderService.getAllFoodOrdersByOrderStatusId(orderStatus.getOrderStatusId()).size());
    }

    @Test
    @Order(8)
    public void deleteFoodOrder() {
        int id = 1;
        when(foodOrderRepository.findById(id)).thenReturn(Optional.of(foodOrder));
        assertEquals(foodOrder, foodOrderService.getFoodOrderById(id));
    }

}
