package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }

    @DeleteMapping("/feedback/{feedbackId}")
    public void deleteFeedback(@PathVariable int feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }

    @PutMapping("/feedback")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }

    @GetMapping("/feedback/{feedbackId}")
    public Feedback getFeedbackById(@PathVariable int feedbackId) {
        return feedbackService.getFeedbackById(feedbackId);
    }

    @GetMapping("/feedbacks")
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }
}
