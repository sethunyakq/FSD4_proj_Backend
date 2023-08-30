package com.example.FSD4RestAPI;

import org.springframework.data.jpa.repository.JpaRepository;

//QuestionRepository.java
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
