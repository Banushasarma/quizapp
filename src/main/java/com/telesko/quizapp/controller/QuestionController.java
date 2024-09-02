package com.telesko.quizapp.controller;

import com.telesko.quizapp.model.Question;
import com.telesko.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    //Add the Question
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return "success";
    }
}