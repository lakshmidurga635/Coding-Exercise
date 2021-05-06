package com.coding.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.quiz.external.services.RetriveCodingQuizService;
import com.coding.quiz.pojo.CodingQuizExternalPojo;
import com.coding.quiz.pojo.QuizQuestionDomainObject;
import com.coding.quiz.pojo.QuizQuestions;
import com.coding.quiz.pojo.QuizResponse;

import reactor.core.publisher.Flux;


@Service
public class QuizServiceImpl implements QuizService {
	
	final static Logger logger = Logger.getLogger(QuizServiceImpl.class);
	
	@Autowired
	private RetriveCodingQuizService codingQuizService;

	@Override
	public Flux<QuizResponse> getQuizQuestions() {
		
		 return codingQuizService.getQuestions().flatMap(questions ->  {
			logger.info("Retrived questions successfully");
			List<QuizQuestions> quizQuestions = convertToQuizQuestions(questions);
			QuizResponse quizResponse = QuizResponse.builder().quizQuestions(quizQuestions).build();
			return Flux.just(quizResponse);
		});
		 
	}
	
	private static List<QuizQuestions> convertToQuizQuestions(CodingQuizExternalPojo codingQuizExternalPojo) {
		return codingQuizExternalPojo.getResults().stream().map(extPojo -> QuizQuestionDomainObject.builder().
				category(extPojo.getCategory())
				.difficulty(extPojo.getDifficulty())
				.question(extPojo.getQuestion())
				.allAnswers(getAllAnswers(extPojo.getCorrectAnswer(), extPojo.getIncorrectAnswers()))
				.correctAnswer(extPojo.getCorrectAnswer())
				.type(extPojo.getType())
				.build()).collect(Collectors.toList())
				.stream().collect(Collectors.toMap(
						quizObj -> quizObj.getCategory(), 
						quizObj -> {
							List<QuizQuestionDomainObject> domainObjects = new ArrayList<QuizQuestionDomainObject>();
							domainObjects.add(quizObj);
							return domainObjects;
						},
						(oldVal, newVal) -> {
							oldVal.addAll(newVal);
							return oldVal;
						}))
				.entrySet().stream().map(p -> new QuizQuestions(p.getKey(), p.getValue()))
				.collect(Collectors.toList());
	}
	
	private static List<String> getAllAnswers(String answer, List<String> wrongAnswers) {
		wrongAnswers.add(answer);
		List<String> allAnswers = wrongAnswers;
		return allAnswers;
	}

}
