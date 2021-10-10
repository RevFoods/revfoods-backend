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

import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.repository.HelpRepository;
import com.app.revfoodsbackend.service.HelpService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class HelpServiceTest {
	@MockBean
	private HelpRepository helpRepository;
	
	@Autowired
	private HelpService helpService;
	
	Help help;
	
	@BeforeEach
	void setUp() throws Exception{
		help=new Help();
		help.setHelpId(1);
		help.setHelpStatus(true);
		help.setHelp("Help me");
	}
	
	@Test
	@Order(1)
	public void addHelpTest()
	{
		when(helpRepository.save(help)).thenReturn(help);
		assertEquals(help, helpService.addHelp(help));
	}
	
	@Test
	@Order(2)
	public void UpdateHelpTest()
	{
		when(helpRepository.save(help)).thenReturn(help);
		assertEquals(help, helpService.updateHelp(help));
	}
	
	@Test
	@Order(3)
	public void getHelpByIdTest()
	{
		when(helpRepository.findById(help.getHelpId())).thenReturn(Optional.of(help));
		assertEquals(help, helpService.getHelpById(help.getHelpId()));
	}
	
	@Test
	@Order(4)
	public void getAllHelpsTest() {
		when(helpRepository.findAll()).thenReturn(Stream.of(new Help(),new Help()).collect(Collectors.toList()));
		assertEquals(2, helpService.getAllHelps().size());
	}
	
	@Test
	@Order(5)
	public void deleteFoodTest() {		
		when(helpRepository.findById(help.getHelpId())).thenReturn(Optional.of(help));
		helpService.deleteHelp(help.getHelpId());
		verify(helpRepository).deleteById(help.getHelpId());
	}
	
	@Test
	@Order(6)
	public void updateHelpStatusTest() {
		when(helpRepository.getById(help.getHelpId())).thenReturn(help);
		when(helpRepository.save(help)).thenReturn(help);
		assertEquals(help,helpService.updateHelpStatus(help.getHelpId(),true));
	}
}
