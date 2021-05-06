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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result {
	
	/*
	 * public Result() {
	 * 
	 * }
	 * 
	 * public Result(String category, String type, String difficulty, String
	 * question, String correctAnswer, List<String> incorrectAnswers) { super();
	 * this.category = category; this.type = type; this.difficulty = difficulty;
	 * this.question = question; this.correctAnswer = correctAnswer;
	 * this.incorrectAnswers = incorrectAnswers; }
	 */

	@JsonProperty("category")
	private String category;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("difficulty")
	private String difficulty;
	
	@JsonProperty("question")
	private String question;
	
	@JsonProperty("correct_answer")
	private String correctAnswer;
	
	@JsonProperty("incorrect_answers")
	private List<String> incorrectAnswers;

}
