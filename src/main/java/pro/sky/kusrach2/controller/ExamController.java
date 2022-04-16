package pro.sky.kusrach2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kusrach2.Question;
import pro.sky.kusrach2.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("exam")
public class ExamController {

    private final ExaminerService service;

    @Autowired
    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping("get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return service.getQuestions(amount);
    }
}
