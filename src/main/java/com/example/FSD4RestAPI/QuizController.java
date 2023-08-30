package com.example.FSD4RestAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//QuizController.java
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class QuizController {
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/questions")
	public List<Question> getQuestions() {
		List<Question> questions = questionRepository.findAll();
		for (Question question : questions) {
			System.out.println("Question: " + question.getQuestionText());
		}
		return questions;
	}

	/*@PostMapping("/submit")
 public ResponseEntity<Map<String, String>> submitAnswers(@RequestBody List<UserAnswerDTO> userAnswers) {
     Map<String, String> results = new HashMap<>();
     System.out.println((userAnswers));

     for (UserAnswerDTO userAnswer : userAnswers) {
         Question question = questionRepository.findById(userAnswer.getQuestionId()).orElse(null);

         if (question != null) {
             if (userAnswer.getAnswer().equalsIgnoreCase(question.getCorrectAnswer())) {
                 results.put(question.getId().toString(), "correct");
             } else {
                 results.put(question.getId().toString(), "incorrect");
             }
         }
     }

     return ResponseEntity.ok(results);
 }*/

	@PostMapping("/submit")
	public ResponseEntity<Map<Long, String>> submitAnswers(@RequestBody Map<Long, String> userAnswers) {
		Map<Long, String> results = new HashMap<>();

		for (Map.Entry<Long, String> entry : userAnswers.entrySet()) {
			Long questionId = entry.getKey();
			String userAnswer = entry.getValue();

			// Retrieve the correct answer from the database
			Question question = questionRepository.findById(questionId).orElse(null);
			if (question != null) {
				String correctAnswer = question.getCorrectAnswer();

				// Compare the user's answer with the correct answer
				if (correctAnswer.equalsIgnoreCase(userAnswer)) {
					results.put(questionId, "correct");
				} else {
					results.put(questionId, "incorrect");
				}
			} else {
				// Handle case where question is not found
				results.put(questionId, "not found");
			}
		}

		return ResponseEntity.ok(results);
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<Map<String, String>> addQuestion(@RequestBody Question question){
		questionRepository.save(question);
		Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Question added successfully");  
        return ResponseEntity.status(HttpStatus.OK).body(response);
	}


}

