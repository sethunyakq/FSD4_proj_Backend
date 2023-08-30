CREATE TABLE QUESTION (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question_text VARCHAR(255) NOT NULL,
    correct_answer VARCHAR(255) NOT NULL
);


INSERT INTO question (question_text, correct_answer) VALUES
  ('What is the capital of France?', 'Paris'),
  ('What is the largest planet in our solar system?', 'Jupiter');
