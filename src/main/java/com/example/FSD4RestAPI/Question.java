package com.example.FSD4RestAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Question.java
@Entity
public class Question {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String questionText;
 
 private String correctAnswer; 
 public String getCorrectAnswer() {
	return correctAnswer;
}
public void setCorrectAnswer(String correctAnswer) {
	this.correctAnswer = correctAnswer;
}
// Other properties and getters/setters
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getQuestionText() {
	return questionText;
}
public void setQuestionText(String questionText) {
	this.questionText = questionText;
}
}
