package exam.quizContext.userInterface;

import exam.quizContext.application.CreateQuizCommand;
import exam.quizContext.application.QuizService;
import exam.quizContext.domain.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/quizzes")
    @ResponseStatus(HttpStatus.CREATED)
    QuizDTO createQuiz(@RequestBody CreateQuizCommand command) {
        return QuizDTO.from(quizService.createQuiz(command));
    }

    @GetMapping("/quizzes")
    List<Quiz> getAll() {
        return quizService.getAll();
    }

    @GetMapping("/quizzes/{quizId}")
    Quiz findById(@PathVariable String quizId) {
        return quizService.findById(quizId);
    }

    @DeleteMapping("/quizzes/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteQuiz(@PathVariable String quizId) {
        quizService.deleteQuiz(quizId);
    }

    @PutMapping("/quizzes/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateQuiz(@PathVariable String quizId, @RequestBody CreateQuizCommand command) {
        quizService.updateQuiz(quizId, command);
    }
}
