package com.coding.quiz.service;


import com.coding.quiz.pojo.QuizResponse;

import reactor.core.publisher.Flux;

public interface QuizService {
	
	
	Flux<QuizResponse> getQuizQuestions();
	

}
