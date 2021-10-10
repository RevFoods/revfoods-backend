package com.app.revfoodsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.service.FeedbackService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Feedback Operations")
@RestController
@CrossOrigin
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@ApiOperation(value = "To add a new Feedback")
	@PostMapping("/feedback")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return feedbackService.addFeedback(feedback);
	}

	@ApiOperation(value = "To delete the feedback")
	@DeleteMapping("/feedback/{feedbackId}")
	public void deleteFeedback(@PathVariable int feedbackId) {
		feedbackService.deleteFeedback(feedbackId);
	}

	@ApiOperation(value = "To update the feedback")
	@PutMapping("/feedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		return feedbackService.updateFeedback(feedback);
	}

	@ApiOperation(value = "To get the feedback by feedbackId")
	@GetMapping("/feedback/{feedbackId}")
	public Feedback getFeedbackById(@PathVariable int feedbackId) {
		return feedbackService.getFeedbackById(feedbackId);
	}

	@ApiOperation(value = "To get all the feedbacks")
	@GetMapping("/feedbacks")
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAllFeedbacks();
	}
}
