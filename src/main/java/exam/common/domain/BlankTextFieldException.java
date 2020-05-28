package exam.common.domain;

public class BlankTextFieldException extends IllegalArgumentException {
    public BlankTextFieldException(String fieldName) {
        super("BlankTextFieldException: exception text is blank: " + fieldName);
    }
}
