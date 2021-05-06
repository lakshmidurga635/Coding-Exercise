package com.coding.quiz.external.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.coding.quiz.pojo.CodingQuizExternalPojo;

import reactor.core.publisher.Flux;

@Service
public class RetriveCodingQuizServiceImpl implements RetriveCodingQuizService {

	final static Logger logger = Logger.getLogger(RetriveCodingQuizServiceImpl.class);

	private static final String listOneURI = "https://opentdb.com/api.php?amount=5&category=11";
	private static final String listTwoURI = "https://opentdb.com/api.php?amount=5&category=12";

	@Override
	public Flux<CodingQuizExternalPojo> getQuestions() {
		logger.info("Fetching the first list...");
		Flux<CodingQuizExternalPojo> listOneResponseFlux = WebClient.create().get().uri(listOneURI).retrieve()
				.bodyToFlux(CodingQuizExternalPojo.class);
		return listOneResponseFlux.flatMap(listOneResponse -> {
			String listOneResposneString = String.format("Fetched the first response %s", listOneResponse.toString());
			logger.info(listOneResposneString);

			logger.info("Fetching the second list...");
			Flux<CodingQuizExternalPojo> listTwoResponseFlux = WebClient.create().get().uri(listTwoURI).retrieve()
					.bodyToFlux(CodingQuizExternalPojo.class);
			return listTwoResponseFlux.map(listTwoResponse -> {
				String listTwoResponseString = String.format("Fetched the second response %s",
						listTwoResponse.toString());
				logger.info(listTwoResponseString);
				listTwoResponse.getResults().addAll(listOneResponse.getResults());
				return listTwoResponse;
			});
		});
	}

}
