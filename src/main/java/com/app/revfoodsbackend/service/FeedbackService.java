package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedback(Feedback feedback);
	public void deleteFeedback(int feedbackId);
	public Feedback updateFeedback(Feedback feedback);
	public Feedback getFeedbackById(int feedbackId);
	public List<Feedback> getAllFeedbacks();
	
	
}
