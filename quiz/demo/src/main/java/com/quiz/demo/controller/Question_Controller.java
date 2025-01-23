package com.quiz.demo.controller;

import com.quiz.demo.model.Question;
import com.quiz.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class Question_Controller {

    @Autowired
    QuestionService questionservice;

    @GetMapping("allquestions")
    public List<Question> getAllQuestion(){

        return questionservice.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){

        return questionservice.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){

        return questionservice.addQuestion(question);
    }

}
