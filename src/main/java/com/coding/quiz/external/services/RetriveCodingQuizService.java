package com.coding.quiz.external.services;

import com.coding.quiz.pojo.CodingQuizExternalPojo;

import reactor.core.publisher.Flux;

public interface RetriveCodingQuizService{
	
	Flux<CodingQuizExternalPojo> getQuestions() ;

}
