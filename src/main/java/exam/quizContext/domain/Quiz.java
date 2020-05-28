package exam.quizContext.domain;

import exam.common.domain.Entity;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Getter
public class Quiz implements Entity<Quiz> {

    private QuizId quizId;
    private String description;
    private String answer;
    private String teacherId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private Quiz(QuizId quizId, String description, String answer, String teacherId) {
        this.quizId = quizId;
        this.description = description;
        this.answer = answer;
        this.teacherId = teacherId;

        this.createTime = LocalDateTime.now();
        this.updateTime = createTime;
    }

    private static void validateDescriptionAndAnswer(String description, String answer) {
        if (!StringUtils.hasText(description)) {
            throw new BlankDescriptionException();
        }
        if (!StringUtils.hasText(answer)) {
            throw new BlankAnswerException();
        }
    }

    public static Quiz create(QuizId quizId, String description, String answer, String teacherId) {
        validateDescriptionAndAnswer(description, answer);
        return new Quiz(quizId, description, answer, teacherId);
    }

    public void update(String description, String answer, String teacherId) {
        validateDescriptionAndAnswer(description, answer);
        this.description = description;
        this.answer = answer;
        this.teacherId = teacherId;
        updateTime = LocalDateTime.now();
    }

    @Override
    public boolean sameIdentityAs(Quiz other) {
        return quizId.sameValueAs(other.getQuizId());
    }
}
