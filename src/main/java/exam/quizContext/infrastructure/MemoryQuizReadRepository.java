package exam.quizContext.infrastructure;

import exam.quizContext.domain.quiz.Quiz;
import exam.quizContext.domain.quiz.QuizId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class MemoryQuizReadRepository {

    private final MemoryQuizRepository memoryQuizRepository;

    public List<Quiz> getAllByReversedOrder() {
        return memoryQuizRepository.getAll().stream()
                .sorted(((quiz, quiz1) -> quiz1.getCreateTime().compareTo(quiz.getCreateTime())))
                .collect(Collectors.toList());
    }

    public Quiz findById(String quizId) {
        return memoryQuizRepository.find(QuizId.of(quizId));
    }
}
