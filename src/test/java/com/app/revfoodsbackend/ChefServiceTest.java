package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.Chef;
import com.app.revfoodsbackend.repository.ChefRepository;
import com.app.revfoodsbackend.service.ChefService;
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
public class ChefServiceTest {

    @MockBean
    public ChefRepository chefRepository;
    Chef chef;
    @Autowired
    private ChefService chefService;

    @BeforeEach
    void setUp() throws Exception {
        chef = new Chef();
    }

    @Test
    @Order(1)
    public void addChef() {
        when(chefRepository.save(chef)).thenReturn(chef);
        assertEquals(chef, chefService.addChef(chef));
    }

    @Test
    @Order(2)
    public void updateChef() {
        when(chefRepository.save(chef)).thenReturn(chef);
        assertEquals(chef, chefService.updateChef(chef));
    }

    @Test
    @Order(3)
    public void getChefById() {
        int id = 1;
        when(chefRepository.findById(id)).thenReturn(Optional.of(chef));
        assertEquals(chef, chefService.getChefById(id));
    }

    @Test
    @Order(4)
    public void getAllChefs() {
        when(chefRepository.findAll()).thenReturn(Stream.of(new Chef(), new Chef()).collect(Collectors.toList()));
        assertEquals(2, chefService.getAllChefs().size());

    }

    @Test
    @Order(5)
    public void deleteChef() {
        when(chefRepository.findById(chef.getChefId())).thenReturn(Optional.of(chef));
        chefService.deleteChef(chef.getChefId());
        verify(chefRepository).deleteById(chef.getChefId());
    }

    @Test
    @Order(6)
    public void getChefByChefUsernameAndChefPassword() {
        String chefUsername = "manisha123345@gmai.com";
        String chefPassword = "manisha";
        when(chefRepository.findChefByChefUsernameAndChefPassword(chefUsername, chefPassword)).thenReturn(chef);
        assertEquals(chef, chefService.getChefByChefUsernameAndChefPassword(chefUsername, chefPassword));
    }
}
