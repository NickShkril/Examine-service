package pro.sky.kusrach2.service;

import org.springframework.stereotype.Service;
import pro.sky.kusrach2.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new RuntimeException("Некорретные данные");
        }
            questions.add(question);
            return question;
        }



    @Override
    public Question remove(Question question) {
        if (question == null) {
            throw new RuntimeException("Некорретные данные");
        }

        boolean wasRemoved = questions.remove(question);

        if (!wasRemoved) {
            throw new RuntimeException("Объекта нет, удалить нельзя");
        }

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }



}
