package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.OrderStatus;
import com.app.revfoodsbackend.repository.OrderStatusRepository;
import com.app.revfoodsbackend.service.OrderStatusService;
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
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class OrderStatusServiceTest {

    @MockBean
    public OrderStatusRepository orderStatusRepository;
    OrderStatus orderStatus;
    @Autowired
    private OrderStatusService orderStatusService;

    @BeforeEach
    void setUp() throws Exception {
        orderStatus = new OrderStatus();
    }

    @Test
    @Order(1)
    public void addOrderStatus() {
        when(orderStatusRepository.save(orderStatus)).thenReturn(orderStatus);
        assertEquals(orderStatus, orderStatusService.addOrderStatus(orderStatus));
    }

    @Test
    @Order(2)
    public void updateOrderStatus() {
        when(orderStatusRepository.save(orderStatus)).thenReturn(orderStatus);
        assertEquals(orderStatus, orderStatusService.updateOrderStatus(orderStatus));
    }

    @Test
    @Order(3)
    public void getOrderStatusById() {
        int id = 1;
        when(orderStatusRepository.findById(id)).thenReturn(Optional.of(orderStatus));
        assertEquals(orderStatus, orderStatusService.getOrderStatusById(id));
    }

    @Test
    @Order(4)
    public void getAllOrderStatuses() {
        when(orderStatusRepository.findAll()).thenReturn(Stream.of(new OrderStatus(), new OrderStatus()).collect(Collectors.toList()));
        assertEquals(2, orderStatusService.getAllOrderStatuses().size());
    }

    @Test
    @Order(5)
    public void deleteOrderStatus() {
        when(orderStatusRepository.findById(orderStatus.getOrderStatusId())).thenReturn(Optional.of(orderStatus));
        orderStatusService.deleteOrderStatus(orderStatus.getOrderStatusId());
        verify(orderStatusRepository).deleteById(orderStatus.getOrderStatusId());
    }
}
