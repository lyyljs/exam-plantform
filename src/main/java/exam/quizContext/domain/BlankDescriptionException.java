package exam.quizContext.domain;

import exam.common.domain.BlankTextFieldException;

public class BlankDescriptionException extends BlankTextFieldException {
    public BlankDescriptionException() {
        super("description");
    }
}
