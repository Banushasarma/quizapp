package com.telesko.quizapp.service;

import com.telesko.quizapp.dao.QuestionDao;
import com.telesko.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public void addQuestion(Question question) {
        questionDao.save(question);
    }
}