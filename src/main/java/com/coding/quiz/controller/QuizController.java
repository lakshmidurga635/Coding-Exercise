package com.coding.quiz.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.quiz.pojo.QuizResponse;
import com.coding.quiz.service.QuizService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/coding")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	final static Logger logger = Logger.getLogger(QuizController.class);
	
	
	
	@GetMapping(value = "/exercise/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<QuizResponse> getQuestions() {
		logger.info("fetching values for service");
		return quizService.getQuizQuestions();
	}

}
