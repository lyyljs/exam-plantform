package exam.quizContext.application;

import exam.quizContext.domain.quiz.Quiz;
import exam.quizContext.domain.quiz.QuizId;
import exam.quizContext.domain.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizId createQuiz(CreateQuizCommand command) {
        final QuizId quizId = quizRepository.nextId();

        quizRepository.save(Quiz.create(quizId, command.getDescription(), command.getAnswer(), command.getTeacherId()));

        return quizId;
    }

    public void reviseQuiz(String quizId, CreateQuizCommand command) {
        quizRepository.find(QuizId.of(quizId)).revise(command.getDescription(), command.getAnswer(), command.getTeacherId());
    }

    public void removeQuiz(String quizId, String teacherId) {
        quizRepository.find(QuizId.of(quizId)).remove(teacherId);
    }
}
