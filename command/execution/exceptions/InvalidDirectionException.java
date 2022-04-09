package command.execution.exceptions;

public class InvalidDirectionException extends CannotExecuteException {
    public InvalidDirectionException() {
        super("Invalid direction, please, try again");
    }
}
