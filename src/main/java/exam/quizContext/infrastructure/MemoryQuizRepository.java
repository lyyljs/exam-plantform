package exam.quizContext.infrastructure;

import exam.quizContext.domain.quiz.Quiz;
import exam.quizContext.domain.quiz.QuizId;
import exam.quizContext.domain.quiz.QuizRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Optional.of;

@Component
public class MemoryQuizRepository implements QuizRepository {

    private final Map<QuizId, Quiz> quizzes = new ConcurrentHashMap<>();

    @Override
    public Quiz find(QuizId quizId) {
        return of(quizzes.get(quizId)).orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(Quiz entity) {
        quizzes.put(entity.getQuizId(), entity);
    }

    @Override
    public QuizId nextId() {
        return QuizId.of("quiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<Quiz> getAll() {
        return new ArrayList<>(quizzes.values());
    }
}
