package exam.paperContext.domain.model.quiz;

import exam.quizContext.domain.BlankAnswerException;
import exam.quizContext.domain.BlankDescriptionException;
import exam.quizContext.domain.Quiz;
import exam.quizContext.domain.QuizId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuizTest {

    @Test
    void should_create_quiz_with_new() {
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        final QuizId quizId = QuizId.of("quiz-f500ee0d-3c9f-494a-bc13-993250053194");
        final String description = "a4c68d5d-6c18-4707-b8c2-1fd18846ebf1";
        final String answer = "29bbb66c-80af-45b3-b593-fc4a358e900e";

        Quiz quiz = Quiz.create(quizId, description, answer, teacherId);
        assertThat(quiz, is(notNullValue()));

        assertThat(quiz.getQuizId(), is(QuizId.of("quiz-f500ee0d-3c9f-494a-bc13-993250053194")));
        assertThat(quiz.getDescription(), is("a4c68d5d-6c18-4707-b8c2-1fd18846ebf1"));
        assertThat(quiz.getAnswer(), is("29bbb66c-80af-45b3-b593-fc4a358e900e"));
        assertThat(quiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(quiz.getUpdateTime(), instanceOf(LocalDateTime.class));
    }

    @Test
    void should_quiz_description_not_blank() {
        Assertions.assertThrows(BlankDescriptionException.class, () -> {
            final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
            final QuizId quizId = QuizId.of("quiz-f500ee0d-3c9f-494a-bc13-993250053194");
            final String description = " ";
            final String answer = "29bbb66c-80af-45b3-b593-fc4a358e900e";

            Quiz quiz = Quiz.create(quizId, description, answer, teacherId);
        });
    }

    @Test
    void should_quiz_answer_not_blank() {
        Assertions.assertThrows(BlankAnswerException.class, () -> {
            final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
            final QuizId quizId = QuizId.of("quiz-f500ee0d-3c9f-494a-bc13-993250053194");
            final String description = "a4c68d5d-6c18-4707-b8c2-1fd18846ebf1";
            final String answer = " ";

            Quiz quiz = Quiz.create(quizId, description, answer, teacherId);
        });
    }
}
