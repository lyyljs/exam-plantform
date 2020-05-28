package exam.quizContext.domain.quiz;

import exam.common.domain.BlankTextFieldException;

public class BlankAnswerException extends BlankTextFieldException {
    public BlankAnswerException() {
        super("answer");
    }
}
