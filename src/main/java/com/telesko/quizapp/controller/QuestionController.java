package com.telesko.quizapp.controller;

import com.telesko.quizapp.model.Question;
import com.telesko.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 // Import the QuestionService class

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService; // Autowire the QuestionService

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}