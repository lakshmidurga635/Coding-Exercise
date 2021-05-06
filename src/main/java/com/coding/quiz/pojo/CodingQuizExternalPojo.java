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
public class CodingQuizExternalPojo {
	
	@JsonProperty("response_code")
	private int responseCode;
	
	@JsonProperty("results")
	private List<Result> results;
	
}
