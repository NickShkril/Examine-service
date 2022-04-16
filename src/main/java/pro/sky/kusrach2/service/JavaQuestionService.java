package pro.sky.kusrach2.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.sky.kusrach2.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {


        private final Set<Question> questions = new HashSet<>();

        @Override
        public Question add(String question, String answer) {
            if (!StringUtils.hasLength(question) || !StringUtils.hasLength(answer)) {
                throw new RuntimeException("Некорректные входные данные!");
            }
            Question newQuestion = new Question(question, answer);
            return add(newQuestion);
        }

        @Override
        public Question add(Question question) {
            if (question == null) {
                throw new RuntimeException("Некорректные входные данные!");
            }

            questions.add(question);
            return question;
        }

        @Override
        public Question remove(Question question) {
            if (question == null) {
                throw new RuntimeException("Некорректные входные данные!");
            }

            boolean wasRemoved = questions.remove(question);

            if (!wasRemoved) {
                throw new RuntimeException("Данного объекта нет в базе! Удаление не выполнено");
            }

            return question;
        }

        @Override
        public Collection<Question> getAll() {
            return Collections.unmodifiableSet(questions);
        }

        @Override
        public Question getRandomQuestion() {
            Random random = new Random();
            int randomIndex = random.nextInt(questions.size());

            int i = 0;
            for (Question question : questions) {
                if (i++ == randomIndex) {
                    return question;
                }
            }
            return null;
        }
    }
