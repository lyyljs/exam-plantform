package exam.quizContext.domain.quiz;

import exam.common.domain.ValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class QuizId implements ValueObject<QuizId> {

    private String id;

    public static QuizId of(String id) {
        return new QuizId(id);
    }

    @Override
    public boolean sameValueAs(QuizId other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return id;
    }
}
