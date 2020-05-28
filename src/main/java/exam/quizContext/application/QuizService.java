package exam.quizContext.application;

import exam.quizContext.domain.quiz.Quiz;
import exam.quizContext.domain.quiz.QuizId;
import exam.quizContext.domain.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public Quiz findById(String quizId) {
        return quizRepository.find(QuizId.of(quizId));
    }

    public QuizId createQuiz(CreateQuizCommand command) {
        final QuizId quizId = quizRepository.nextId();

        quizRepository.save(Quiz.create(quizId, command.getDescription(), command.getAnswer(), command.getTeacherId()));

        return quizId;
    }

    public List<Quiz> getAll() {
        return quizRepository.getAll();
    }

    public void updateQuiz(String quizId, CreateQuizCommand command) {
        quizRepository.find(QuizId.of(quizId)).update(command.getDescription(), command.getAnswer(), command.getTeacherId());
    }

    public void deleteQuiz(String quizId) {
        quizRepository.delete(QuizId.of(quizId));
    }
}
