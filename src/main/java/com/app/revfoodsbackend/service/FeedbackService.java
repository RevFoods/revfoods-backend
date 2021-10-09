package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Feedback;

import java.util.List;

public interface FeedbackService {
     Feedback addFeedback(Feedback feedback);
     void deleteFeedback(int feedbackId);
     Feedback updateFeedback(Feedback feedback);
     Feedback getFeedbackById(int feedbackId);
     List<Feedback> getAllFeedbacks();
}
