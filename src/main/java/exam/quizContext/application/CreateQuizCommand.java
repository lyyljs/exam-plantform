package exam.quizContext.application;

import lombok.Data;

@Data
public class CreateQuizCommand {
    private String teacherId;
    private String description;
    private String answer;
}
