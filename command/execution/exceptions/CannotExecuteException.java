package command.execution.exceptions;

public class CannotExecuteException extends Exception {
    public CannotExecuteException(String err_message) {
        super(err_message);
    }
}
