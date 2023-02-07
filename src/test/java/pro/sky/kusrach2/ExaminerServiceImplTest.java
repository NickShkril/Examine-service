package pro.sky.kusrach2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.Test;
import pro.sky.kusrach2.service.ExaminerServiceImpl;
import pro.sky.kusrach2.service.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Spy
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    private final Set<Question> questionsMock = new HashSet<>();

    @BeforeEach
    public void adding() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        Question question2 = new Question("Вопрос2", "Ответ2");
        Question question3 = new Question("Вопрос3", "Ответ3");
        Question question4 = new Question("Вопрос4", "Ответ4");
        Question question5 = new Question("Вопрос5", "Ответ5");
        Question question6 = new Question("Вопрос6", "Ответ6");
        questionsMock.add(question1);
        questionsMock.add(question2);
        questionsMock.add(question3);
        questionsMock.add(question4);
        questionsMock.add(question5);
        questionsMock.add(question6);
    }

    @Test
    public void shouldThrowAnExceptionIfThereAreNotEnoughQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(questionsMock);

        assertThrows(RuntimeException.class, () -> out.getQuestions(7));
    }

    @Test
    public void shouldReturnTheEntireCollectionIfTheNumberOfQuestionsMatchesTheQuery() {
            when(javaQuestionServiceMock.getAll()).thenReturn(questionsMock);

        assertEquals(questionsMock, out.getQuestions(6));
    }

    @Test
    public void shouldCallTheMethodGetRandomQuestionAtLeastAsManyTimesAsItCameInTheParameters() {
        ReflectionTestUtils.setField(javaQuestionServiceMock,
                "questions",
                questionsMock);

        verify(javaQuestionServiceMock, atMost(5)).getRandomQuestion();

        out.getQuestions(5);
    }
}