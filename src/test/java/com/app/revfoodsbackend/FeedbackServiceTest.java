package com.app.revfoodsbackend;

import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.repository.FeedbackRepository;
import com.app.revfoodsbackend.service.FeedbackService;
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
public class FeedbackServiceTest {

    @Autowired
    FeedbackService feedbackService;

    @MockBean
    FeedbackRepository feedbackRepository;

    Feedback feedback;

    @BeforeEach
    void setUp() throws Exception {
        feedback = new Feedback();
        feedback.setFeedback("delicious food");
        feedback.setAmbience(4);
        feedback.setHygiene(4);
        feedback.setService(4);
    }


    @Test
    @Order(1)
    public void addFeedbackTest() {
        when(feedbackRepository.save(feedback)).thenReturn(feedback);
        assertEquals(feedback, feedbackService.addFeedback(feedback));
    }

    @Test
    @Order(2)
    public void getAllFeedbacksTest() {
        when(feedbackRepository.findAll()).thenReturn(Stream.of(new Feedback(), new Feedback()).collect(Collectors.toList()));
        assertEquals(2, feedbackService.getAllFeedbacks().size());
    }

    @Test
    @Order(3)
    public void getFeedbackByIdTest() {
        int id = 1;
        when(feedbackRepository.findById(id)).thenReturn(Optional.of(feedback));
        assertEquals(feedback, feedbackService.getFeedbackById(id));
    }

    @Test
    @Order(4)
    public void updateFeedbackTest() {
        feedback.setAmbience(5);
        when(feedbackRepository.save(feedback)).thenReturn(feedback);
        assertNotEquals("Navi Mumbai", feedbackService.updateFeedback(feedback));
    }

    @Test
    @Order(5)
    public void deleteFeedbackTest() {
        when(feedbackRepository.findById(feedback.getFeedbackId())).thenReturn(Optional.of(feedback));
        feedbackService.deleteFeedback(feedback.getFeedbackId());
        verify(feedbackRepository).deleteById(feedback.getFeedbackId());
    }


}
