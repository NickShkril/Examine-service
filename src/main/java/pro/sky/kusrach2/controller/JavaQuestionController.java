package pro.sky.kusrach2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kusrach2.Question;
import pro.sky.kusrach2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;


    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("add")
    public void addQuestion(@RequestParam("question") String question,
                            @RequestParam("answer") String answer) {
        service.add(question, answer);
    }

    @GetMapping("remove")
    public void removeQuestion(@RequestParam("question") String question,
                               @RequestParam("answer") String answer) {
        service.remove(new Question(question,answer));
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
