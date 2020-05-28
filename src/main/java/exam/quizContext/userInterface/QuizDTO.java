package exam.quizContext.userInterface;

import exam.quizContext.domain.QuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizDTO {
    private String uri;

    public static QuizDTO from(QuizId quizId) {
        return new QuizDTO("quizzes/" + quizId);
    }
}
