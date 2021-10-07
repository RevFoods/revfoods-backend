package com.app.revfoodsbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.repository.FeedbackRepository;
import com.app.revfoodsbackend.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	

	@Override
	public Feedback addFeedback(Feedback feedback) {

		return feedbackRepository.save(feedback);
	}

	@Override
	public void deleteFeedback(int feedbackId) {

		feedbackRepository.deleteById(feedbackId);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {

		return feedbackRepository.save(feedback);
	}

	@Override
	public Feedback getFeedbackById(int feedbackId) {

		return feedbackRepository.findById(feedbackId).get();
	}

	@Override
	public List<Feedback> getAllFeedbacks() {

		return feedbackRepository.findAll();
	}

}
