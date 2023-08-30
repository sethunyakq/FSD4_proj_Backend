package com.example.FSD4RestAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Fsd4RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fsd4RestApiApplication.class, args);
	}
	
	 @Bean
	    public CommandLineRunner commandLineRunner(QuestionRepository questionRepository) {
	        return args -> {
	            Question question1 = new Question();
	            question1.setQuestionText("What is the capital of France?");
	            question1.setCorrectAnswer("Paris");
	            questionRepository.save(question1);

	            Question question2 = new Question();
	            question2.setQuestionText("What is the largest planet in our solar system?");
	            question2.setCorrectAnswer("Jupiter");
	            questionRepository.save(question2);
	            
	            
	            // Add more sample questions as needed
	        };
	    }

}
