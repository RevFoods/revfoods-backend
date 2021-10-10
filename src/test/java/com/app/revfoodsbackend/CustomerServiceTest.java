package com.app.revfoodsbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.CustomerTable;
import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.model.OrderStatus;
import com.app.revfoodsbackend.model.Supervisor;
import com.app.revfoodsbackend.repository.CustomerRepository;
import com.app.revfoodsbackend.repository.CustomerTableRepository;
import com.app.revfoodsbackend.repository.FeedbackRepository;
import com.app.revfoodsbackend.repository.HelpRepository;
import com.app.revfoodsbackend.repository.OrderStatusRepository;
import com.app.revfoodsbackend.repository.SupervisorRepository;
import com.app.revfoodsbackend.service.CustomerService;
import com.app.revfoodsbackend.service.CustomerTableService;
import com.app.revfoodsbackend.service.OrderStatusService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CustomerServiceTest {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerTableService customerTableService;
	
	@Autowired
	OrderStatusService orderStatusService;
	
	@MockBean
	OrderStatusRepository orderStatusRepository;
	
	@MockBean
	CustomerRepository customerRepository;
	
	@MockBean
	CustomerTableRepository customerTableRepository;
	
	@MockBean
	FeedbackRepository feedbackRepository;
	
	@MockBean
	HelpRepository helpRepository;
	
	@MockBean
	SupervisorRepository supervisorRepository;
	
	Customer customer;
	
	OrderStatus orderStatus;
	
	@BeforeEach
	void setUp() throws Exception{
		customer=new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Akshay");
		customer.setCustomerEmail("Akshay@gmail.com");
		customer.setCustomerPhone(3456778893l);
		
		orderStatus = new OrderStatus();
		orderStatus.setOrderStatusId(1);
		orderStatus.setOrderStatus("Prep");
	}

	
	@Test
	@Order(1)
	public void addCustomerTest() {
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.addCustomer(customer));
	}
	
	@Test
	@Order(2)
	public void getAllCustomersTest() {
		when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(),new Customer()).collect(Collectors.toList()));
		assertEquals(2, customerService.getAllCustomers().size());
	}
	
	@Test
	@Order(3)
	public void getCustomerByCustomerIdTest() {
		int id=1;
		when(customerRepository.findById(id)).thenReturn(Optional.of(customer));
		assertEquals(customer,customerService.getCustomerByCustomerId(id));
	}
	
	@Test
	@Order(4)
	public void updateCustomerTest() {
		customer.setCustomerName("Akshay Sargar");
		when(customerRepository.save(customer)).thenReturn(customer);
		assertNotEquals("Navi Mumbai", customerService.updateCustomer(customer));
	}
	
	@Test
	@Order(5)
	public void addCustomerTableToCustomerTest() {
		when(customerRepository.save(customer)).thenReturn(customer);
		when(customerRepository.getById(customer.getCustomerId())).thenReturn(customer);
		when(customerTableRepository.findAllByCustomerTableStatus(false)).thenReturn(Stream.of(new CustomerTable()).collect(Collectors.toList()));
		assertEquals(customer, customerService.addCustomerTableToCustomer(1, customer.getCustomerId()));	
	}
	
	
	@Test
	@Order(6)
	public void addFeedbackToCustomerTest() {
		Feedback feedback = new Feedback();
		feedback.setFeedback("all good");
		feedback.setHygiene(4);
		feedback.setService(4);
		feedback.setAmbience(4);
		Feedback newFeedback = feedbackRepository.save(feedback);
		customer.setFeedback(newFeedback);
		
		when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.addFeedbackToCustomer(1, feedback));
	}
	
	@Test
	@Order(7)
	public void addHelpToCustomerTest() {
		Help help = new Help();
		help.setHelp("Need Help");
		help.setHelpStatus(true);
		Help newHelp = helpRepository.save(help);
		customer.setHelp(newHelp);
		Supervisor supervisor=new Supervisor();
		supervisor.setSupervisorId(1);
		
		when(customerRepository.getById(customer.getCustomerId())).thenReturn(customer);
		when(supervisorRepository.findById(supervisor.getSupervisorId())).thenReturn(Optional.of(supervisor));
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.addHelpToCustomer(1, help));
	}
	
	@Test
	@Order(8)
	public void deleteCustomerTest() {		
		when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
		customerService.deleteCustomer(customer.getCustomerId());
		verify(customerRepository).deleteById(customer.getCustomerId());
	}
	

}
