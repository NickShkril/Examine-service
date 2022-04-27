package pro.sky.kusrach2.service;

import pro.sky.kusrach2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
