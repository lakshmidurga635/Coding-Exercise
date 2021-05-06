package com.coding.quiz.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class QuizQuestionDomainObject {
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("difficulty")
	private String difficulty;
	
	@JsonProperty("question")
	private String question;
	
	@JsonProperty("all_answers")
	private List<String> allAnswers;
	
	@JsonProperty("correct_answer")
	private String correctAnswer;
	
	@JsonIgnore
	private String category;

}
