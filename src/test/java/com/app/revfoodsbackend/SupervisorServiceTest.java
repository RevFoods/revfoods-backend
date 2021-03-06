package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.Supervisor;
import com.app.revfoodsbackend.repository.SupervisorRepository;
import com.app.revfoodsbackend.service.SupervisorService;
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
public class SupervisorServiceTest {

    @MockBean
    public SupervisorRepository supervisorRepository;
    Supervisor supervisor;
    @Autowired
    private SupervisorService supervisorService;

    @BeforeEach
    void setUp() throws Exception {
        supervisor = new Supervisor();
    }

    @Test
    @Order(1)
    public void addSupervisor() {
        when(supervisorRepository.save(supervisor)).thenReturn(supervisor);
        assertEquals(supervisor, supervisorService.addSupervisor(supervisor));
    }

    @Test
    @Order(2)
    public void updateSupervisor() {
        when(supervisorRepository.save(supervisor)).thenReturn(supervisor);
        assertEquals(supervisor, supervisorService.updateSupervisor(supervisor));
    }

    @Test
    @Order(3)
    public void getSupervisorBySupervisorId() {
        int id = 1;
        when(supervisorRepository.findById(id)).thenReturn(Optional.of(supervisor));
        assertEquals(supervisor, supervisorService.getSupervisorBySupervisorId(id));
    }

    @Test
    @Order(4)
    public void getAllSupervisors() {
        when(supervisorRepository.findAll()).thenReturn(Stream.of(new Supervisor(), new Supervisor()).collect(Collectors.toList()));
        assertEquals(2, supervisorService.getAllSupervisors().size());

    }

    @Test
    @Order(5)
    public void deleteSupervisor() {
        when(supervisorRepository.findById(supervisor.getSupervisorId())).thenReturn(Optional.of(supervisor));
        supervisorService.deleteSupervisor(supervisor.getSupervisorId());
        verify(supervisorRepository).deleteById(supervisor.getSupervisorId());
    }

    @Test
    @Order(6)
    public void getSupervisorByUsernameAndPassword() {
        String supervisorUsername = "manisha123345@gmai.com";
        String supervisorPassword = "manisha";
        when(supervisorRepository.findSupervisorBySupervisorUsernameAndSupervisorPassword(supervisorUsername, supervisorPassword)).thenReturn(supervisor);
        assertEquals(supervisor, supervisorService.getSupervisorByUsernameAndPassword(supervisorUsername, supervisorPassword));
    }

}
