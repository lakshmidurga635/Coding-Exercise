package com.coding.quiz.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizQuestions {
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("results")
	private List<QuizQuestionDomainObject> quizQuestionDomainObjects;

}
