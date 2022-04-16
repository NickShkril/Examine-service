package pro.sky.kusrach2;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pro.sky.kusrach2.service.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceImplTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void shouldReturnQuestionOnSuccessfulAddByQuestionObject() {
        Question question = new Question("Что такое Java?", "Это язык програмирования!");

        assertEquals(question, javaQuestionService.add(question));
    }

    @Test
    public void shouldReturnQuestionOnSuccessfulAddByQuestionAndAnswer() {
        Question question = new Question("Что такое Java?", "Это язык програмирования!");

        assertEquals(question, javaQuestionService.add("Что такое Java?", "Это язык програмирования!"));
    }

    @Test
    public void shouldThrowAnErrorIfOneOfTheParametersIsEmpty() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.add("", "Это язык програмирования!"));

    }

    @Test
    public void mustThrowAnExceptionIfNullIsPassedInTheParameter() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.add(null));
    }

    @Test
    public void shouldReturnAnObjectIfItHasBeenDeleted() {
        Question question = new Question("Что такое Java?", "Это язык програмирования!");
        javaQuestionService.add(question);
        assertEquals(question, javaQuestionService.remove(question));
    }

    @Test
    public void removeMustThrowAnExceptionIfNullIsPassedInTheParameter() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.remove(null));
    }

    @Test
    public void shouldThrowAnExceptionIfTheObjectHasNotBeenDeleted() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.remove(new Question("Что такое Java?", "Это язык програмирования!")));
    }

    @Test
    public void shouldReturnListOfAllQuestions() {
        Question question = new Question("Что такое Java?", "Это язык програмирования!");
        Question question1 = new Question("Что такое Spring?", "Это Framework!");
        Collection<Question> questions = new HashSet<>();
        questions.add(question);
        questions.add(question1);
        javaQuestionService.add(question);
        javaQuestionService.add(question1);

        assertEquals(questions, javaQuestionService.getAll());
    }

    @Test
    public void mustNotReturnNull() {
        Question question = new Question("Что такое Java?", "Это язык програмирования!");
        javaQuestionService.add(question);
        Assertions.assertNotNull(javaQuestionService.getRandomQuestion());
    }

    @Test
    public void shouldReturnRandomObjects() {
        Question question = new Question("Что такое Java?", "Это язык програмирования!");
        Question question1 = new Question("Что такое Spring?", "Это Framework!");
        javaQuestionService.add(question);
        javaQuestionService.add(question1);
        boolean a = true;
        Question question2 = javaQuestionService.getRandomQuestion();
        while (a) {
            Question question3 = javaQuestionService.getRandomQuestion();
            if (question2 != question3) {
                a = false;
            }
        }
        Assertions.assertFalse(a);
    }
}

