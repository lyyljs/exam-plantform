package exam.quizContext.domain.quiz;

import exam.common.domain.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"quizId"})
public class Quiz implements Entity<Quiz> {

    private QuizId quizId;
    private String description;
    private String answer;
    private String teacherId;
    private boolean removed;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private Quiz(QuizId quizId, String description, String answer, String teacherId) {
        this.quizId = quizId;
        this.description = description;
        this.answer = answer;
        this.teacherId = teacherId;
        this.removed = false;

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

    public void revise(String description, String answer, String teacherId) {
        validateDescriptionAndAnswer(description, answer);
        this.description = description;
        this.answer = answer;
        updateBy(teacherId);
    }

    public void remove(String teacherId) {
        this.removed = true;
        updateBy(teacherId);
    }

    private void updateBy(String teacherId) {
        this.teacherId = teacherId;
        updateTime = LocalDateTime.now();
    }

    @Override
    public boolean sameIdentityAs(Quiz other) {
        return this.equals(other);
    }
}
