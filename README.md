# QuizApp
This Spring Boot application implements a basic quiz system.

Project Structure

src/main/java: Contains the Java source code for the application.
com.example.quizapp: Root package for the application's classes.
controller: Contains the QuizController and QuestionsController classes.
model: Contains the Quiz and Question entities.
repository: Contains the QuizRepository and QuestionRepository interfaces.
service: Contains the QuizService and QuestionService interfaces (optional).
src/test/java: Contains the unit tests for the application.
Key Features

Quiz Management:
Create, read, update, and delete quizzes.
Associate questions with quizzes.
Question Management:
Create, read, update, and delete questions.
Support for different question types (optional).
RESTful API:
Exposes endpoints for interacting with quizzes and questions.
