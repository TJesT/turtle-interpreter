package command.execution.exceptions;

public class EnvironmentNotInitializedException extends CannotExecuteException {
    public EnvironmentNotInitializedException() {
        super("Please, execute init command first");
    }
}
