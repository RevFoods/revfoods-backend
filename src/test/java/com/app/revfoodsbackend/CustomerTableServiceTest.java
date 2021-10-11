package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.CustomerTable;
import com.app.revfoodsbackend.repository.CustomerTableRepository;
import com.app.revfoodsbackend.service.CustomerTableService;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CustomerTableServiceTest {

    @Autowired
    CustomerTableService customerTableService;

    @MockBean
    CustomerTableRepository customerTableRepository;

    CustomerTable customerTable;

    @BeforeEach
    void setUp() throws Exception {
        customerTable = new CustomerTable();
        customerTable.setCustomerTableNumber(4);
        customerTable.setCustomerTableStatus(true);
    }

    @Test
    @Order(1)
    public void addCustomerTableTest() {
        when(customerTableRepository.save(customerTable)).thenReturn(customerTable);
        assertEquals(customerTable, customerTableService.addCustomerTable(customerTable));
    }

    @Test
    @Order(2)
    public void getAllCustomerTablesTest() {
        when(customerTableRepository.findAll()).thenReturn(Stream.of(new CustomerTable(), new CustomerTable()).collect(Collectors.toList()));
        assertEquals(2, customerTableService.getAllCustomerTables().size());
    }

    @Test
    @Order(3)
    public void getCustomerTableByIdTest() {
        int id = 1;
        when(customerTableRepository.findById(id)).thenReturn(Optional.of(customerTable));
        assertEquals(customerTable, customerTableService.getCustomerTableById(id));
    }

    @Test
    @Order(4)
    public void updateCustomerTableTest() {
        customerTable.setCustomerTableNumber(5);
        when(customerTableRepository.save(customerTable)).thenReturn(customerTable);
        assertNotEquals("Navi Mumbai", customerTableService.updateCustomerTable(customerTable));
    }

    @Test
    @Order(5)
    public void getAllCustomerTablesByCustomerTableStatusTest() {
        when(customerTableRepository.findAllByCustomerTableStatus(customerTable.isCustomerTableStatus())).thenReturn(Stream.of(new CustomerTable()).collect(Collectors.toList()));
        assertEquals(1, customerTableService.getAllCustomerTablesByCustomerTableStatus(customerTable.isCustomerTableStatus()).size());
    }

    @Test
    @Order(6)
    public void updateCustomerTableStatusTest() {
        customerTable.setCustomerTableStatus(true);
        when(customerTableRepository.findById(customerTable.getCustomerTableId())).thenReturn(Optional.of(customerTable));
        when(customerTableRepository.save(customerTable)).thenReturn(customerTable);
        assertNotEquals("Navi Mumbai", customerTableService.updateCustomerTableStatus(customerTable.getCustomerTableId(), customerTable.isCustomerTableStatus()));
    }

    @Test
    @Order(7)
    public void deleteCustomerTableTest() {
        when(customerTableRepository.findById(customerTable.getCustomerTableId())).thenReturn(Optional.of(customerTable));
        customerTableService.deleteCustomerTable(customerTable.getCustomerTableId());
        verify(customerTableRepository).deleteById(customerTable.getCustomerTableId());
    }

}
