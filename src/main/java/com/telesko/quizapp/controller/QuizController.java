package com.telesko.quizapp.controller;

import com.telesko.quizapp.model.Question;
import com.telesko.quizapp.model.QuestionWrapper;
import com.telesko.quizapp.model.Quiz;
import com.telesko.quizapp.model.Response;
import com.telesko.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> careateQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {

        return quizService.careateQuiz(category, numQ, title);
    }

    //Get the quiz by id
    @PostMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    //Submit results and calculate the percentage
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuizResults(@RequestBody List<Response> responses, @PathVariable Integer id) {
        return quizService.calculateResults(responses, id);
    }
}