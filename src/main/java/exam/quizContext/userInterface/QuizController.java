package exam.quizContext.userInterface;

import exam.quizContext.application.CreateQuizCommand;
import exam.quizContext.application.QuizService;
import exam.quizContext.domain.quiz.Quiz;
import exam.quizContext.infrastructure.MemoryQuizReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    private final MemoryQuizReadRepository memoryQuizReadRepository;

    @PostMapping("/quizzes")
    @ResponseStatus(HttpStatus.CREATED)
    QuizDTO createQuiz(@RequestBody CreateQuizCommand command) {
        return QuizDTO.from(quizService.createQuiz(command));
    }

    @GetMapping("/quizzes")
    List<Quiz> getAll() {
        return memoryQuizReadRepository.getAllByReversedOrder();
    }

    @GetMapping("/quizzes/{quizId}")
    Quiz findById(@PathVariable String quizId) {
        return memoryQuizReadRepository.findById(quizId);
    }

    @DeleteMapping("/quizzes/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeQuiz(@PathVariable String quizId, @RequestHeader(value = "teacherId") String teacherId) {
        quizService.removeQuiz(quizId, teacherId);
    }

    @PutMapping("/quizzes/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateQuiz(@PathVariable String quizId, @RequestBody CreateQuizCommand command) {
        quizService.reviseQuiz(quizId, command);
    }
}
